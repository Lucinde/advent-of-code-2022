import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
add txt-file
read first column and add to player 1
read second column and add to player 2

var playerOne
var playerTwo

choices playerOne a = rock/b = paper/c = scissor
choices playerTwo x = rock/y = paper/z = scissor

De twee lijsten tegenover elkaar zetten. Elke positie[x] tegen elkaar afwegen en een winnaar bepalen.
Punten van de uitslag berekenen
Punten bij elkaar optellen
Degene die aan het eind de meeste punten heeft wint.
*/
public class Day02 {
    BufferedReader in = new BufferedReader(new FileReader("src/input/day02.txt"));
    List<String> results = new ArrayList<>();

    List<String> playerOne = new ArrayList<>();
    List<String> playerTwo = new ArrayList<>();
    int scoreSelectedP1 = 0;
    int scoreSelectedP2 = 0;
    int outcomeRoundP1 = 0;
    int outcomeRoundP2 = 0;
    int totalResultP2 = 0;


    /*constructor*/
    public Day02() throws FileNotFoundException {
    }

    /* read the input from the file */
    public void processInput() throws IOException {
        String line = in.readLine();
        while (line != null) {
            results.add(line);
            line = in.readLine();
        }
    }

    /* add the input to the players strings */
    public void inputPlayers(List<String> results) {
        for (String line : results) {
            String[] columns = line.split("\\s+"); // \\s+ is regex that splits string by 1 or more white-characters

            playerOne.add(columns[0]);
            playerTwo.add(columns[1]);
        }
    }

    /* play the game with the first plan */
    public void playGame() {
        for (int i = 0; i < results.size(); i++) {
            if(playerOne.get(i).equals("A")) {
                scoreSelectedP1 = scoreSelectedP1 + 1;
            } else if (playerOne.get(i).equals("B")) {
                scoreSelectedP1 = scoreSelectedP1 + 2;
            } else {
                scoreSelectedP1 = scoreSelectedP1 + 3;
            }

            if(playerTwo.get(i).equals("X")) {
                scoreSelectedP2 = scoreSelectedP2 + 1;
            } else if (playerTwo.get(i).equals("Y")) {
                scoreSelectedP2 = scoreSelectedP2 + 2;
            } else {
                scoreSelectedP2 = scoreSelectedP2 + 3;
            }

            switch (playerOne.get(i)) {
                case "A":
                    switch (playerTwo.get(i)) {
                        case "X":
                            outcomeRoundP1 += 3;
                            outcomeRoundP2 += 3;
                            break;
                        case "Y":
                            outcomeRoundP2 += 6;
                            break;
                        case "Z":
                            outcomeRoundP1 += 6;
                            break;
                    }
                    break;
                case "B":
                    switch (playerTwo.get(i)) {
                        case "X":
                            outcomeRoundP1 += 6;
                            break;
                        case "Y":
                            outcomeRoundP1 += 3;
                            outcomeRoundP2 += 3;
                            break;
                        case "Z":
                            outcomeRoundP2 += 6;
                            break;
                    }
                    break;
                case "C":
                    switch (playerTwo.get(i)) {
                        case "X":
                            outcomeRoundP2 += 6;
                            break;
                        case "Y":
                            outcomeRoundP1 += 6;
                            break;
                        case "Z":
                            outcomeRoundP1 += 3;
                            outcomeRoundP2 += 3;
                            break;
                    }
                    break;
            }
//            System.out.println(outcomeRoundP1 + " - " + outcomeRoundP2); //remove the comment to see the result of each round
        }
        totalResultP2 += scoreSelectedP2 + outcomeRoundP2;
    }

    /* reset the game after playing */
    public void resetGame() {
        scoreSelectedP1 = 0;
        scoreSelectedP2 = 0;
        outcomeRoundP2 = 0;
        outcomeRoundP1 = 0;
        totalResultP2 = 0;
    }

    /* give playerTwo the right input to play the game with the real strategy */
    public void playGameStrategy() {
        for (int i = 0; i < results.size(); i++) {
            switch (playerTwo.get(i)) {
                case "Z":
                    switch (playerOne.get(i)) {
                        case "A":
                            playerTwo.set(i, "Y");
                            break;
                        case "B":
                            playerTwo.set(i, "Z");
                            break;
                        case "C":
                            playerTwo.set(i, "X");
                            break;
                    }
                    break;
                case "X":
                    switch (playerOne.get(i)) {
                        case "A":
                            playerTwo.set(i, "Z");
                            break;
                        case "B":
                            playerTwo.set(i, "X");
                            break;
                        case "C":
                            playerTwo.set(i, "Y");
                            break;
                    }
                            break;
                case "Y":
                    switch (playerOne.get(i)) {
                        case "A":
                            playerTwo.set(i, "X");
                            break;
                        case "B":
                            playerTwo.set(i, "Y");
                            break;
                        case "C":
                            playerTwo.set(i, "Z");
                            break;
                    }
                    break;
            }
        }

    }
}
