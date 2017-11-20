public class Protagonist {
    
    public String name;
    public int HP;
    public int strength;
    public int defense;
    public double attack;

    public Protagonist(String newName){
	name = newName;
	HP = 125;
	strength = 100;
	defense = 40;
	attack = 0.4;
    }//end of default constructor

    public boolean isAlive(){
	return HP > 0;

    }//end of isAlive()

    public int getDefense(){
	return defense;
    }

    public String getName(){
	return name;
    }

    public void lowerHP(int dam){
	HP -= dam;

    }	
    
    public int attack(Monster mon){
	int damage = (int)( (strength * attack) - mon.getDefense() );
	mon.lowerHP(damage);
	
	return damage;
    }

    public void specialize(){
        double attBoost = 0.2;
	int defBoost = 20;
	
        attack += attBoost;
	defense -= defBoost;
    }

    public void normalize(){
	double attBoost = 0.2;
	int defBoost = 20;

	attack -= attBoost;
	defense += defBoost;
    }

    public static void main(String[] args){

    }
    
}//end class Protagonist
