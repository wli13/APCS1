/*Wenting Li
APCS1 pd08
HW06 -- BigSibg Individuality and the Elimination of Radio Fuzz
2017-09-26 */

public class BigSib {
     private String HelloMsg;
    
    public void SetHelloMsg(String newMsg) {
	HelloMsg = newMsg;
	}

    public String greet(String name) {
	return HelloMsg + " " + name;
    }
}
