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
        System.out.println("---------------");

    }
}