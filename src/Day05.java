import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day05 {
//    BufferedReader inCrates = new BufferedReader(new FileReader("src/input/day05-crates.txt"));
    HashMap<Integer, ArrayList<String>> crateItems = new HashMap<>();
    BufferedReader inMoves = new BufferedReader(new FileReader("src/input/day05-moves.txt"));

    ArrayList<String> allMoves = new ArrayList<>();

    ArrayList<String> moveTo = new ArrayList<>();

    public Day05() throws FileNotFoundException {
    }

    public void getMoves() throws IOException {
        processInputMoves();
        ArrayList<int[]> movesNumbers = getNumbersForMoves(allMoves);
        crateItems = addCrateItems();
        System.out.println("START VALUES");
        cratePrint();
        System.out.println("------------");
        System.out.println("--MOVE ONE--");
        moveSingleCrateItems(crateItems, movesNumbers);
        cratePrint();
        System.out.println("------------");
        System.out.println("--MOVE ALL--");


    }

    private ArrayList<int[]> getNumbersForMoves(ArrayList<String> allMoves) {
        ArrayList<int[]> numericMoves = new ArrayList<>();

        for (String move : allMoves) {
            String[] splitMove = move.split("move")[1].trim().split("from|to");
            int[] numbers = new int[splitMove.length];

            for (int i = 0; i < splitMove.length; i++) {
                numbers[i] = extractNumber(splitMove[i].trim());
            }

            numericMoves.add(numbers);
        }

        return numericMoves;
    }

    private int extractNumber(String text) {
        StringBuilder numericString = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                numericString.append(c);
            }
        }

        return Integer.parseInt(numericString.toString());
    }

    private void processInputMoves() throws IOException {
        String line = inMoves.readLine();
        while (line != null) {
            allMoves.add(line);
            line = inMoves.readLine();
        }
    }

    public void cratePrint() {
        // Print the crate-item list
        for (int crate : crateItems.keySet()) {
            ArrayList<String> items = crateItems.get(crate);
            System.out.print("Line " + crate + " contains crates: ");
            for (String item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static HashMap<Integer, ArrayList<String>> addCrateItems() {
        // Manually add the crates to the lines
        HashMap<Integer, ArrayList<String>> crateItems = new HashMap<>();

        //arrays as list toevoegen
        crateItems.put(1, new ArrayList<>(Arrays.asList("Z", "T", "F", "R", "W", "J", "G")));
        crateItems.put(2, new ArrayList<>(Arrays.asList("G", "W", "M")));
        crateItems.put(3, new ArrayList<>(Arrays.asList("J", "N", "H", "G")));
        crateItems.put(4, new ArrayList<>(Arrays.asList("J", "R", "C", "N", "W")));
        crateItems.put(5, new ArrayList<>(Arrays.asList("W", "F", "S", "B", "G", "Q", "V", "M")));
        crateItems.put(6, new ArrayList<>(Arrays.asList("S", "R", "T", "D", "V", "W", "C")));
        crateItems.put(7, new ArrayList<>(Arrays.asList("H", "B", "N", "C", "D", "Z", "G", "V")));
        crateItems.put(8, new ArrayList<>(Arrays.asList("S", "J", "N", "M", "G", "C")));
        crateItems.put(9, new ArrayList<>(Arrays.asList("G", "P", "N", "W", "C", "J", "D", "L")));

        return crateItems;
    }

    public static void moveSingleCrateItems(HashMap<Integer, ArrayList<String>> crateItems, ArrayList<int[]> movesNumbers) {

        for (int[] move: movesNumbers) {
            //get number of items to move
            int moves = move[0];
            //get line to move from
            int from = move[1];
            //get line to move to
            int to = move[2];

            //get the current lists
            ArrayList<String> fromValues = crateItems.get(from);
            ArrayList<String> toValues = crateItems.get(to);

            //make the moves
            for (int i = 0; i < moves; i++) {
                String lastValue = fromValues.remove(fromValues.size() - 1);
                toValues.add(lastValue);
            }

            //save the items
            crateItems.put(from, fromValues);
            crateItems.put(to, toValues);
        }

    }

}


