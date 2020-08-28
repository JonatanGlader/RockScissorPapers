import java.util.Scanner;
public class rockScissorPaper {
	
	static Scanner reader = new Scanner(System.in);
	static String player1 = " ";
	static String player2 = " ";
	static int p1Score = 0;
	static int p2Score = 0;
	
	public static void main(String[] args) {
		
		boolean twoPlayers = false;
		twoPlayers = modeSelect();
		
		System.out.println(twoPlayers);
		rps(twoPlayers);
		
		if(p1Score == 2)
		{
			System.out.println(player1 +" Congratulations, you have won!");
		}
		else if (p2Score == 2)
		{
			System.out.println(player2 +" Congratulations, you have won!");
		}
		System.out.println("Thanks for playing!");
		reader.close();
		
	}
	
	static void rps(boolean bot) //RPS, Here is where the game starts to play
	{
		System.out.println(bot);
		if (bot==false) //if gamemode is player vs player
		{
			String p1Hand;
			String p2Hand;
			//player1 = setName(1); //Players sets their names
			//player2 = setName(2);
			player1 = "jonte";
			player2 = "gabe";
			System.out.println("let's play! Best out of 3!");
			
			for (int i = 0; i<3; i++)
			{
				System.out.println(player1 + " has: " + p1Score + " score\n" + player2 + " has: " + p2Score + " score\n");
				p1Hand = takeTurn(player1); //lets player1 choose hand
				p2Hand = takeTurn(player2); //lets player2 choose hand
				
				match(p1Hand, p2Hand); //matches the players hands against each other, and gives the winner a score.				
			}
		}
		else if (bot==true) //if gamemode is player vs bot
		{
			String p1Hand;
			String p2Hand;
			player1 = setName(1); //Player sets their name
			player2 = "Computer";
			System.out.println("let's play! Best out of 3!");
			
			for (int i = 0; i<3; i++)
			{
				System.out.println(player1 + " has: " + p1Score + " score\n" + player2 + " has: " + p2Score + " score\n");
				p1Hand = takeTurn(player1); //lets player1 choose hand
				p2Hand = randomizeBotHand(); //gives bot a random hand
				
				match(p1Hand, p2Hand); //matches the players hands against each other, and gives the winner a score.				
			}
		}
	}
	
	static String takeTurn(String name) //Here players get to chose their hands
	{
		String hand = "null";
		while (hand.equals("null"))
		{
		System.out.println("\n" + name + " Please choose: rock, paper or scissor!");
		hand = reader.nextLine();
		if(hand.equalsIgnoreCase("rock") || hand.equalsIgnoreCase("scissor") || hand.equalsIgnoreCase("paper"))
		{
			System.out.println(name + " you have chosen " + hand + "\n");			
		}
		else //if they don't type in a correct hand, they get to try again
			hand = "null";
		}
		return hand;
	}
	
	
	static void match(String playerA, String playerB) //matches the hands against each other
	{
		if (playerA.equalsIgnoreCase("rock"))
		{
			if (playerB.equalsIgnoreCase("rock"))
				System.out.println("rock vs rock - it's a tie!\n");
			else if (playerB.equalsIgnoreCase("scissor"))
			{
				System.out.println("rock vs scissor - " + player1 + " won!\n");
				 p1Score++;
			}
			else if (playerB.equals("paper"))
			{
				System.out.println("rock vs paper - " + player2 + " won!\n");
				p2Score++;
			}
		}
		
		else if (playerA.equalsIgnoreCase("scissor"))
		{
			if (playerB.equalsIgnoreCase("rock"))
			{
				System.out.println("scissor vs rock - " + player2 + " won!\n");
				p2Score++;
			}
			else if (playerB.equalsIgnoreCase("scissor"))
				System.out.println("scissor vs scissor - it's a tie!\n");
			else if (playerB.equalsIgnoreCase("paper"))
			{
				System.out.println("scissor vs paper - " + player1 + " won!\n");
				p1Score++;
			}
		}
		
		else if (playerA.equalsIgnoreCase("paper"))
		{
			if (playerB.equalsIgnoreCase("rock"))
			{
				System.out.println("paper vs rock - " + player1 + " won!\n");
				p1Score++;
			}
			else if (playerB.equalsIgnoreCase("scissor"))
			{
				System.out.println("paper vs scissor - " + player2 + " won!\n");
				p2Score++;
			}
			else if (playerB.equalsIgnoreCase("paper"))
				System.out.println("paper vs paper - it's a tie!\n");
		}
	}
	
	static String randomizeBotHand()
	{
		String hand = "";
		int i = (int) (Math.random() * 3 + 1);
		if (i == 1)
			hand = "rock";
		else if (i == 2)
			hand = "scissor";
		else if (i == 3)
			hand = "paper";
		
		return hand;
	}
	
	static String setName(int i) //here the names are set for the players
	{
		String playerName;
		System.out.println("Player " + i +", Please enter your name!");
		playerName = reader.nextLine();
		System.out.println("Player " + i +", Your name has been set to: " + playerName + "\n");
		return playerName;
	}
	
	static boolean modeSelect() //here the player selects if they want to play 2 player, or vs a bot
	{
		System.out.println("Welcome!\nWhat mode do you want to play?\n\n[2]-Player vs Player\n[1]Player vs Bot");
		int i = 0;
		
		while(i < 1 || i > 2)
		try
		{
			i = Integer.parseInt(reader.nextLine());
			if (i == 2)				
				System.out.println("You have chosen Player vs Player\n");
			else if (i == 1)		 
				System.out.println("You have chosen Player vs bot\n");
			else
				System.out.println("Please answer with either 2 (for 2 players) or 1 (for bot)");
		}
		catch (NumberFormatException e)
		{
			System.out.println("Please answer with either 2 (for 2 players) or 1 (for bot)");
		}
		if (i==2)
			return false;
		else
			return true;
	}
}
