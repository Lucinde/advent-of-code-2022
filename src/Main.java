import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("-----DAY 1-----");
        Day01 elf1 = new Day01();
        elf1.countCalories();
        elf1.countTopThree();
        System.out.println("---------------");

        System.out.println("-----DAY 2-----");
        Day02 rps = new Day02();
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
        Day03 prioItems = new Day03();
        prioItems.countPriorities();
        System.out.println("The sum of priorities is " + prioItems.sumPriorities);
        prioItems.addBadges();
        System.out.println("The sum of the badges is " + prioItems.sumPrioritiesGroup);
        System.out.println("---------------");

        System.out.println("-----DAY 4-----");
        Day04 range = new Day04();
        range.getRange();
        System.out.println("---------------");
    }
}