import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    BufferedReader in = new BufferedReader(new FileReader("day4.txt"));
    ArrayList<String> results = new ArrayList<>();

    public Day4() throws FileNotFoundException {
    }

    public void getRange() throws IOException {
        processInput();
        ArrayList<String[]> sections = getSections(results);
        //System.out.println(sections);
        int numbers = getNumbers(sections);
        System.out.println("Assignment pairs that fully contain each-others range: " + numbers);
    }

    private void processInput() throws IOException {
        String line = in.readLine();
        while (line != null) {
            results.add(line);
            line = in.readLine();
        }
    }

    private ArrayList<String[]> getSections(ArrayList<String> results) {
        ArrayList<String[]> sections = new ArrayList<>();
        for (String result : results) {
            sections.add(result.split(","));
        }
        return sections;
    }

    private int getNumbers(ArrayList<String[]> sections) {
        //ArrayList<String[]> numbersString = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int range = 0;
        for (String[] section : sections) {
            //System.out.println(section);
            for (int i = 0; i < section.length; i++) {
                String[] k = section[i].split("-");
                numbers.add(Integer.parseInt(k[0]));
                numbers.add(Integer.parseInt(k[1]));
            }
        }
        for (int i = 0; i < numbers.size(); i+=4) {
            if(numbers.get(i) <= numbers.get(i+2) && numbers.get(i+3) <= numbers.get(i+1) ||
                    numbers.get(i) >= numbers.get(i+2) && numbers.get(i+3) >= numbers.get(i+1)) {
                range += 1;
            }
        }
        return range;
    }


}
