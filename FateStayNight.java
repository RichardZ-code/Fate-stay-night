// This program runs a Text-Based Adventure game - Fate/stay night by Richard. Enjoy it!

import java.io.*;// tells Java input will be used

class FateStayNight
{	// begins class definition

	// the program starts running when the main method is called
    public static void main (String[] args) throws IOException
	{ 	// main method begins
	
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);
		String inData, charName;
		int direction, option;
		
		System.out.println("Please enter your name, Valiant Saber!"); // asks for user input
		inData = stdin.readLine();/* places input into inData 
                                   * variable */
        charName = inData;
		
		Character Saber = new Character(charName, 85, "Excalibur", 25, "Invisible Air");
		Character Assassin = new Character("Assassin", 115, "Zabaniya", 20, "Cursed Arm");

		Saber.preface();
		
		while (Assassin.characterHP > 0) {
			System.out.println("Please enter the direction you want to go:");
			inData = stdin.readLine();/* places input into inData 
                                   * variable */
			direction = Integer.parseInt(inData);/* converts inData character
                                           data to int data type */
			
			if (direction == 1) {
				System.out.println("Now you are in the North, but you have not obtained the gate key yet, go South to defeat Assassin!");
			}
			
			if (direction == 2) {
				Saber.characterHP = Saber.characterHP + 15;
				System.out.println("Congratulations! Your HP has been replenished to " + Saber.characterHP + ".");
			}
			
			if (direction == 3) {
				Saber.attackPower = Saber.attackPower + 3;
				System.out.println("Congratulations! The attack power of Excalibur has been upgraded to " + Saber.attackPower + ".");
			}
				
			if (direction == 4) {
				System.out.println("Watch out! You are now faced with Assassin! Enter 5 if you want to attack him!");
				inData = stdin.readLine();/* places input into inData 
									   * variable */
				option = Integer.parseInt(inData);/* converts inData character
                                            data to int data type */
				if (option == 5) {
					Assassin.characterHP = Assassin.characterHP - Saber.attackPower;
					Saber.characterHP = Saber.characterHP - Assassin.attackPower;
					Saber.attack();
					Assassin.attack();
					if ((Assassin.characterHP >= 0) && (Saber.characterHP >= 0)) {
						System.out.println("Assassin's HP has dropped to " + Assassin.characterHP + "! But Assassin hit you at the same time! Your HP has dropped to " + Saber.characterHP + "!");
					}
					else if ((Assassin.characterHP < 0) && (Saber.characterHP >= 0)) {
						System.out.println("Assassin's HP has dropped to 0! But Assassin hit you at the same time! Your HP has dropped to " + Saber.characterHP + "!");
					}
					else if ((Assassin.characterHP >= 0) && (Saber.characterHP < 0)) {
						System.out.println("Assassin's HP has dropped to " + Assassin.characterHP + "! But Assassin hit you at the same time! Your HP has dropped to 0!");
					}
					else if ((Assassin.characterHP < 0) && (Saber.characterHP < 0)) {
						System.out.println("Assassin's HP has dropped to 0! But Assassin hit you at the same time! Your HP has dropped to 0 too!");
					}
				}
			}
		}
		
		if ((Assassin.characterHP <= 0) && (Saber.characterHP > 0)) {
			System.out.println("Awesome!! Congratulations!! You have defeated Assassin!!");
			System.out.println("To enter the Village, please enter 1 to go North.");
			inData = stdin.readLine();/* places input into inData 
								   * variable */
			option = Integer.parseInt(inData);/* converts inData character
                                        data to int data type */	
			if (option == 1) {
				System.out.println("You have entered the Village.");
				System.out.println();
				System.out.println("GAME");
				System.out.println("OVER");
				System.out.println();
				System.out.println("Thank you for trying Fate/stay night, and I hope you enjoy it!");
			}
		} else {
			System.out.println("Unfortunately, your heart is eaten by Assassin.");
			System.out.println();
			System.out.println("GAME");
			System.out.println("OVER");
			System.out.println();
			System.out.println("Thank you for trying Fate/stay night, and I hope you enjoy it!");
		}
		
    }	// ends the main method
}	// ends the class definition

class Character {
	
	public String characterName;
	public int characterHP;
	public String characterWeapon;
	public int attackPower;
	public String specialMove;
	
	Character(String cNameIn, int cHPIn, String cWeaponIn, int cPowerIn, String cMoveIn) {
		characterName = cNameIn;
		characterHP = cHPIn;
		characterWeapon = cWeaponIn;
		attackPower = cPowerIn;
		specialMove = cMoveIn;
	}
	
	void preface() {
		System.out.println("Welcome to this Text-Based Adventure game - Fate/stay night! " + characterName + "!");
		System.out.println("In this game, you have the choice of going North, West, East or South. Each of these directions will take you to one of the following:");
        System.out.println("-	The main gates to the Village, which are locked.");
		System.out.println("-	Location to replenish your HP.");
		System.out.println("-	Location to upgrade your weapon.");
		System.out.println("-	Location where you are faced with an enemy that holds the key to the Village gates.");
		System.out.println("Please enter 1 if you want to go North, 2 if you want to go West, 3 if you want to go East, 4 if you want to go South.");
		System.out.println("Your goal is to defeat the main enemy - Assassin and obtain the gate key in order to enter the Village.");
		System.out.println();
		System.out.println("Your HP is 85.");
		System.out.println("Your weapon is Excalibur - the legendary sword of King Arthur.");
		System.out.println("The attack power of Excalibur is 25.");
		System.out.println("Your special move is Invisible Air.");
		System.out.println();
		System.out.println("Now let's start the game!");
		System.out.println();
	}
	
	void attack() {
		System.out.println(characterName + " prepares for the attack and does a " + specialMove + " with " + characterWeapon + ".");
	}
	
}