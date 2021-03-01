package SportsAcademy;

import java.util.Scanner;

public class PlayersDriver {

	static Scanner in = new Scanner(System.in);
	static Player[] players = new Player[10];
	static int playersCount;

	public static void main(String[] args) {
		/*
		 * 1. Add a new player in the system. 2. Display all the player details. 3.
		 * Search players by their label. 4. Sort all player details by their age in
		 * descending order & if age is same sort by name. 5. Update number of matches
		 * played by given player name. 9. Exit.
		 */
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				addNewPlayer();
				break;
			case 2:
				displayAllPlayers();
				break;
			case 3:
				searchPlayersByLabel();
				break;
			case 4:
				sortPlayersByAge();
				break;
			case 5:
				updateMatchesPlayedByName();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect Input! Try Again");
			}
		}

	}

	static int displayMenu() {
		System.out.println("====================================================");
		System.out.println("1. Add a new player");
		System.out.println("2. Display all players");
		System.out.println("3. Search players by their label");
		System.out.println("4. Sort players by age in descending order");
		System.out.println("5. Update number of matches played by given player name");
		System.out.println("9. Exit");
		System.out.println("====================================================");
		System.out.println("Enter Choice");
		return in.nextInt();
	}

	static void addNewPlayer() {
		if (playersCount == players.length)
			resize();
		System.out.println("Enter Player Id-");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter Player Name-");
		String name = in.nextLine();
		System.out.println("Enter Player Age-");
		byte age = in.nextByte();
		in.nextLine();
		String label = inputLabel();
		in.nextLine();
		System.out.println("Enter number of matches played-");
		short matchesPlayed = in.nextShort();
		in.nextLine();
		players[playersCount++] = new Player(id, name, age, label, matchesPlayed);
		displayAllPlayers();
	}

	private static String inputLabel() {
		System.out.println("Enter Player Label");
		System.out.println("1. International");
		System.out.println("2. Domestic");
		System.out.println("3. Both");
		int ch = in.nextInt();
		switch (ch) {
		case 1:
			return "International";
		case 2:
			return "Domestic";
		case 3:
			return "Both";
		default:
			System.out.println("Wrong Input! Try Again");
		}
		return inputLabel();
	}

	private static void resize() {
		Player[] newarr = new Player[players.length + 10];
		for (int i = 0; i < playersCount; i++)
			newarr[i] = players[i];
		players = newarr;
	}

	static void displayAllPlayers() {
		if (playersCount == 0)
			System.out.println("No Player Data Available");
		else {
			for (int i = 0; i < playersCount; i++)
				displayOnePlayer(i,players);
		}
	}

	private static void displayOnePlayer(int i,Player[] array) {
		System.out.println("===================================");
		System.out.println("Player Id- " + array[i].getId());
		System.out.println("Player Name- " + array[i].getName());
		System.out.println("Player Age- " + array[i].getAge());
		System.out.println("Player Label- " + array[i].getLabel());
		System.out.println("Number of matches played- " + array[i].getMatchesPlayed());
		System.out.println("===================================");
	}

	static void searchPlayersByLabel() {
		String label=inputLabel();
		for (int i = 0; i < playersCount; i++) {
			if(players[i].getLabel().equals(label))
				displayOnePlayer(i,players);
		}
	}

	static void sortPlayersByAge() {
		Player[] newarr=new Player[playersCount];
		for (int i = 0; i < playersCount; i++) {
			newarr[i]=players[i];
		}
		for (int i = 0; i < newarr.length-1; i++) {
			for (int j = 0; j < newarr.length-i-1; j++) {
				if(newarr[j].getAge()<newarr[j+1].getAge()) {
					swap(newarr,j,j+1);
				}
				else if(newarr[j].getAge()==newarr[j+1].getAge()) {
					if(newarr[j].getName().compareTo(newarr[j+1].getName())>0) {
						swap(newarr,j,j+1);
					}
				}
			}
		}
		for (int i = 0; i < newarr.length; i++) {
			displayOnePlayer(i,newarr);
		}

	}

	private static void swap(Player[] newarr,int i, int j) {
		Player temp=newarr[i];
		newarr[i]=newarr[j];
		newarr[j]=temp;
	}

	static void updateMatchesPlayedByName() {
		System.out.println("Enter player name whose number of matches played to be updated");
		String name=in.next();
		in.nextLine();
		boolean found=false;
		for (int i = 0; i < playersCount; i++) {
			if(players[i].getName().equals(name)) {
				found=true;
				System.out.println("Enter updated number of matches played");
				short matchesPlayed=in.nextShort();
				players[i].setMatchesPlayed(matchesPlayed);
				System.out.println("number of matches played got updated");
				displayOnePlayer(i,players);
			}
		}
		if(found==false) {
			System.out.println("Player name doesn't exist in the system! Try Again");
			updateMatchesPlayedByName();
		}
	}
}
