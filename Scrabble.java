package Constructors;

import java.util.Scanner;

public class Scrabble {
	//declaring variables
	private static String playerOne;
	private static String playerTwo;
	private static String currentPlayer;
	private static int    playerNumber=1;
	//declaring variable to hold the value of the played word
	private static String playedWord="";
	//declaring a varible to hold alphabet list
	private static String alphabetList="abcdefghijklmnopqrstuvwxyz";
	//declare a variable to store used letters
	private static String  usedLetters="";
	//Point  Calculator
	private static int  playerOnePoint=0;
	private static int playerTwoPoint=0;
	
	/*
	 * Write a Scrabble Game for two person Rules OK==
	 *  1- At the beginning Ask to first Player enter a word for starting game OK
	 *  2- Then change the player ask to new player if given word is valid or not OK 
	 *  i) If new player accepts the given word add number of letters in the word as points to player who wrote the word And go to step 3 OK 
	 * ii) If new player does not accept the word as valid then print "Invalid word, player X(Current player) won the game" and finish the game

		OK 3- Ask to users if user want to continue game or not OK
		 	i) If player want to continue, OK ask to user a letter to add to word OK and ask to user side to add (beginning or end) OK then add letter to word and run step 2

		OK ii) If player does not want to continue then print "Game Finished" and print points and winner
	 */


	public static void main(String[] args) {
		
		System.out.println("WELCOME TO SCRABBLE GAME" +
		"\nEnter (Y) to play the game or Enter any key to Exit : ");
		
		if (new Scanner(System.in).next().equalsIgnoreCase("y")) {
			
			System.out.println("Enter the player one name : ");
			playerOne= new Scanner(System.in).next();
			
			System.out.println("Enter the player two name : ");
			playerTwo= new Scanner(System.in).next();
			
			System.out.println("Her anlamlý kelime 5 puan...");
			
			startGame();
		}
		else {
			//Exiting the program
			System.exit(0);
		}
		
		
		
		
		
	}

	//this method starts the game
	private static void startGame() 
	{
		//while loop to loop the game
		while(!playedWord.equals("###")) {
			
			//determine current player
			currentPlayer();
			System.out.println(currentPlayer+"\n Alphabets : " +updateAlphabets());
			System.out.println("\n Enter a word : ");
			playedWord =new Scanner(System.in).next();
			
			System.out.println("Player one : "+playerOnePoint);
			System.out.println("Player two : "+playerTwoPoint);
			
		}
		
	}

	

	private static String updateAlphabets() {
		//for loop to loop through the alphabet list
		for (int i = 0; i < alphabetList.toCharArray().length; i++) {
			
			//get used letters
			if (playedWord.contains(alphabetList.toCharArray()[i]+"")) {
				usedLetters += alphabetList.toCharArray()[i]+"";
				alphabetList=alphabetList.replace((alphabetList.toCharArray()[i]+""), "*");
			}
			
			if (alphabetList==alphabetList.replaceAll("\\w", "*")) {
				System.out.println("alfabe de harf kalmadý oyun bitti.");
				System.exit(0);
			}
			
		
		}
		
		
		playerOnePoint+=5;
		playerTwoPoint+=5;
		
		playerOnePoint-=5;
		playerTwoPoint-=5;
		
		if (currentPlayer.isEmpty()) {
			currentPlayer=playerOne;
			playerOnePoint-=5;
		}
		
		if (currentPlayer.isEmpty()) {
			currentPlayer=playerTwo;
			playerTwoPoint-=5;
		}
		
		return alphabetList;
	}
	
	
	
	//this method determine the current player
	private static void currentPlayer() {
		if (playerNumber==1) {
			currentPlayer=playerOne;
			playerNumber+=1;
			playerOnePoint+=5;
		}
		else {
			currentPlayer=playerTwo;
			playerNumber-=1;
			playerTwoPoint+=5;
			
		}
		
	}

}
