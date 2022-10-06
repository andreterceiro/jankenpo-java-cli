package Jankenpo;
import java.util.Random;
import java.util.Scanner;

/**
 * The unique class of the system
 */
public class Main {
	/**
	 * All the computer options 
	 */
	private static char[] computerOptions = new char[3]; 
	
	/**
	 * Integer constants to define the winner
	 */
	private static final byte COMPUTER_WINS = -1;
	private static final byte DRAW = 0;
	private static final byte USER_WINS = 1;

	/**
	 * Main method - initial
	 * 
	 * @static 
	 * 
	 * @param arguments Shell arguments
	 * 
	 * @return void
	 */
    public static void main(String[] arguments) {
    	Main.initializeComputerOptions();

    	char computerOption = Main.getComputerOption();
    	Main.showResult(
			Main.getWinner(
				Main.receiveUserOption(), 
				computerOption
			),
			computerOption
		);
	}
    
    /**
     * Receives the user option
     * 
     * @return String
     */
    private static String receiveUserOption() {
    	Scanner scanner = new Scanner(System.in);
    	String option = "";
    	
    	while ((!option.equals("R")) && (!option.equals("P")) && (!option.equals("S")) ) {
        	System.out.print("Please insert 'P' for 'paper' or 'R' for 'rock' or 'S' for 'scissors': ");
        	option = scanner.nextLine();
    	}
    	scanner.close();
    	
    	return option;
    }
    
    /**
     * Returns the computer option:
     * - "P" for "paper"
     * - "R" for "rock"
     * - "S" for "scissors"
     * 
     * @return char
     */
    private static char getComputerOption() {
        Random gerador = new Random();

        return Main.computerOptions[gerador.nextInt(3)];
    }
    
    /**
     * Initialize an array of computer options
     * - "P" for "paper"
     * - "R" for "rock"
     * - "S" for "scissors"
	 *
	 * @return void
     */
    private static void initializeComputerOptions() {
    	Main.computerOptions[0] = 'P';
    	Main.computerOptions[1] = 'R';
    	Main.computerOptions[2] = 'S';
    }
    
    /**
     * Return the winner
     * - 1  - user (Main.USER_WINS)
     * - 0  - draw (Main.DRAW)
     * - -1 - computer (Main.COMPUTER_WINS
     * )
     * @param userOption     A string of the user option (first char of the word - 
     *                       'Paper' or 'Rock' or 'Scissor'
     * @param computerOption A char of the computer option (first char of the word - 
     *                       'Paper' or 'Rock' or 'Scissor'
     * 
     * @return return a byte related of the winner (Main.USER_WINS or Main.DRAW or
     *         Main.COMPUTER_WIN 
     */
    private static byte getWinner(String userOption, char computerOption) {
        byte dataToReturn = Main.DRAW; 
        if ((userOption.equals("P") && computerOption == 'R') || (userOption.equals("R") && computerOption == 'S') || (userOption.equals("S") && computerOption == 'P')) {
        	return Main.USER_WINS;
        } else if (! userOption.equals(String.valueOf(computerOption))) {
            return Main.COMPUTER_WINS;
        }

    	return dataToReturn;
    }
    
    /**
     * Displays a human readable text of the result
     * 
     * @param result         Byte representing the result (Main.USER_WINS or Main.DRAW or
     *                       Main.COMPUTER_WIN)
     * 
     * @param computerOption The computer random option to show to the user
     * 
     * @return void
     */
    private static void showResult(byte result, char computerOption) {
    	String stringComputerOption = Main.getStringOption(computerOption);
    	if (result == Main.DRAW) {
        	System.out.printf(
    			"Draw. Computer choosed '%s'", 
    			stringComputerOption
			);
        } else if (result == Main.COMPUTER_WINS) {
        	System.out.printf(
    			"Computer wins. Computer choosed '%s'", 
    			stringComputerOption
			);        	
        } else {
        	System.out.printf(
    			"User wins. Computer choosed '%s'", 
    			stringComputerOption
			);        	
        }
    }
    
    /**
     * Return a string related to the option
     * - "Paper" - 'P'
     * - "Rock" - 'R'
     * - "Scissors" - S
     *
     * @param option The char related to the option
     * 
     * @return Return a string related to the option
     */
    private static String getStringOption(char option) {
    	if (option == 'P') {
    		return "Paper";
    	} else if (option == 'R') {
    		return "Rock";
    	}
    	return "Scissors";    	
    }
}
