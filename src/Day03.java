/*
Each rucksack has two apartments - both the same size

// add the input to arraylist, line by line
// split each item in two
// check each item for the same letters (case-sensitive)
// prioritize items - a-z = 1-26 / A-Z = 27-52 --> hashmap / key/value
// count all priorities

// part 2
// make groups for every three lines in the list
// compare each string from the tree lines to find the right character
// use charToInt and sumChars to count priorities
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {
    BufferedReader in = new BufferedReader(new FileReader("src/input/day03.txt"));
    ArrayList<String> results = new ArrayList<>();
    ArrayList<String> compartmentOne = new ArrayList<>();
    ArrayList<String> compartmentTwo = new ArrayList<>();

    int sumPriorities;
    int sumPrioritiesGroup;

    /*constructor*/
    public Day03() throws FileNotFoundException {
    }

    /*methods*/
    public void countPriorities() throws IOException {
        processInput();
        divideCompartments();
        List<String> equalLetters = checkDoubleChars(compartmentOne, compartmentTwo);
        sumPriorities = sumChars(equalLetters);
    }

    public void addBadges() throws IOException {
        processInput();
        ArrayList<List<String>> groups = listGroups(results);
        List<String> equalLettersGroup = checkTripleChars(groups);
        sumPrioritiesGroup = sumChars(equalLettersGroup);
    }
    private void processInput() throws IOException {
        String line = in.readLine();
        while (line != null) {
            results.add(line);
            line = in.readLine();
        }
    }

    private ArrayList<List<String>> listGroups(ArrayList<String> results) {
        ArrayList<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            List<String> sublist;
            if (i % 3 == 0) {
                sublist = new ArrayList<>();
                groups.add(sublist);
            } else {
                sublist = groups.get(groups.size() - 1);
            }
            sublist.add(results.get(i));
        }
        return groups;
    }

    private void divideCompartments() {
        for (String line : results) {
            int half = line.length() / 2;
            String part1 = line.substring(0, half);
            String part2 = line.substring(half);

            compartmentOne.add(part1);
            compartmentTwo.add(part2);
        }
    }

    private List<String> checkDoubleChars(List<String> compartmentOne, List<String> compartmentTwo) {
        List<String> equalLetters = new ArrayList<>();
        for (int i = 0; i < compartmentOne.size(); i++) {
            String c = doubleChars(compartmentOne.get(i), compartmentTwo.get(i));
            equalLetters.add(c);
        }
        return equalLetters;
    }

    private String doubleChars(String a, String b) {
        String c;
        for (int i = 0; i < a.length(); i++) {
            c = Character.toString(a.charAt(i));
            if(b.contains(c)) {
                return c;
            }
        }
        return " ";
    }
    private int charToInt(char a) {
        if(Character.isUpperCase(a)) {
            return a - 38;
        }
        if(Character.isLowerCase(a)) {
            return a - 96;
        }
        return a;
    }

    private int sumChars(List<String> equalLetters) {
        int sum = 0;
        for (String equalLetter : equalLetters) {
            int c = charToInt(equalLetter.charAt(0));
            sum = sum + c;
        }
        return sum;
    }

    private String tripleChars(String a, String b, String c) {
        String d;
        for (int i = 0; i < a.length(); i++) {
            d = Character.toString(a.charAt(i));
            if(b.contains(d) && c.contains(d)) {
                return d;
            }
        }
        return " ";
    }

    private List<String> checkTripleChars(ArrayList<List<String>> groups) {
        List<String> equalLettersGroup = new ArrayList<>();
        for (List<String> group : groups) {
            String c = tripleChars(group.get(0), group.get(1), group.get(2));
            equalLettersGroup.add(c);
        }
        return equalLettersGroup;
    }
}
