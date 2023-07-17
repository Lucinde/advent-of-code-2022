import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    int indexElf = 1;
    int caloriesElf = 0;
    int indexElfMax = 0;
    int caloriesElfMax = 0;
    BufferedReader in = new BufferedReader(new FileReader("src/input/day01.txt"));
    String str;

    //List<String> list = new ArrayList<>();

    public void countCalories() throws IOException {
        while ((str = in.readLine()) != null) {
            //list.add(str);
            if (str.equals("")) {
                //System.out.println("Elf #" + indexElf + " carries " + caloriesElf + " calories"); //turn this on when you want to see all the elf's
                if (caloriesElf > caloriesElfMax) {
                    caloriesElfMax = caloriesElf;
                    indexElfMax = indexElf;
                }
                indexElf++;
                caloriesElf = 0;
            } else {
                int cal = Integer.parseInt(str);
                caloriesElf += cal;
            }
        }

        System.out.println("The largest number of calories is " + caloriesElfMax + " carried by elf #" + indexElfMax);
    }

    /* part 2 */

    BufferedReader in2 = new BufferedReader(new FileReader("src/input/day01.txt"));

    //int indexElf2 = 1;
    int caloriesElf2 = 0;
    String str2;

    public void countTopThree() throws IOException {

        List<Integer> topThree = new ArrayList<>();
        topThree.add(0);
        topThree.add(0);
        topThree.add(0);

        while ((str2 = in2.readLine()) != null) {
            if (str2.equals("")) {
                if (caloriesElf2 > topThree.get(0)) {
                    topThree.set(0, caloriesElf2);
                }

                Collections.sort(topThree);

                //indexElf2++;
                caloriesElf2 = 0;
            } else {
                int cal = Integer.parseInt(str2);
                caloriesElf2 += cal;
            }
        }

        int total = topThree.get(0) + topThree.get(1) + topThree.get(2);

        System.out.println("The amount of calories of the top three elf's together is: " + total);
    }

    public Day01() throws FileNotFoundException {
    }
}
