public class Monster {
    
    public int HP;
    public int strength;
    public int defense;
    public double attack;

    public Monster(){
	HP = 150;
	strength = 45;
	defense = 20;
	attack = 1;
    }

    public boolean isAlive(){
	return (HP > 0);
	
    }//end of isAlive()

    public int getDefense(){
	return defense;
    }

    public void lowerHP(int dam){
	HP -= dam;
	
    }

    public int attack(Protagonist pro){
	int damage = (int)( (strength * attack) - pro.getDefense() );
	pro.lowerHP(damage);
	
	return damage;
    }	
    
}//end class Monster
    
