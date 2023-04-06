import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("-----DAY 1-----");
        Day1 elf1 = new Day1();
        elf1.countCalories();
        elf1.countTopThree();
        System.out.println("---------------");

        System.out.println("-----DAY 2-----");
        Day2 rps = new Day2();
        rps.processInput();
        rps.inputPlayers(rps.results);
        rps.playGame();
        System.out.println("My total score would be " + rps.totalResultP2);
        rps.resetGame();
        rps.playGameStrategy();
        rps.playGame();
        System.out.println("With the right strategy my total score would be " + rps.totalResultP2);
        System.out.println("---------------");

        System.out.println("-----DAY 3-----");
        Day3 prioItems = new Day3();
        prioItems.countPriorities();
        System.out.println("The sum of priorities is " + prioItems.sumPriorities);
        prioItems.addBadges();
        System.out.println("The sum of the badges is " + prioItems.sumPrioritiesGroup);
        System.out.println("---------------");

    }
}