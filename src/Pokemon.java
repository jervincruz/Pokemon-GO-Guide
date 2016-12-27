
public class Pokemon {
	
	String name, type;
	int capture, flee, stamina, attack, defense, candies;
	
	public Pokemon(String name, String type, int capture, int flee, int stamina, int attack, int defense, int candies){
		this.name = name;
		this.type = type;
		this.capture = capture;
		this.flee = flee;
		this.stamina = stamina;
		this.attack = attack;
		this.defense = defense;
		this.candies = candies;
	}
	
	public void printPokemon(){
		String s = "[" + this.name + ", "+ this.type + ", " + this.capture + "%, " + this.flee + "%, "
					+ this.stamina + ", " + this.attack + ", " + this.defense + ", " + this.candies + "]";

		System.out.println(s);
	}
}
