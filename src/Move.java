
public class Move {
	String name, type;
	double DPS;
	int power, duration, damageWindow;
	Move m;
	
	Move(String name, String type, double DPS, int power, int duration, int damageWindow){
		this.name = name;
		this.type = type;
		this.DPS = DPS;
		this.power = power;
		this.duration = duration;
		this.damageWindow = damageWindow;
	}
	
	void printMove(){
			System.out.println("[" + this.name + ", "+ this.type + ", " + this.DPS + ", " + this.power + ", "
					+ this.duration + ", " + this.damageWindow + "]");
		}	
}
