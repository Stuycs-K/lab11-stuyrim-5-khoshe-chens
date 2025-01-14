public class Necromancer extends Adventurer{

  //necromancer special is called mana for now, is subject to change
  int mana, manaMax;

  public Priest(String name, int hp) {

  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "";
  }

  public int getSpecial() {
    return 0;
  }

  public int getSpecialMax() {
    return 0;
  }

  public void setSpecial(int n) {

  }

  //attack/support/special

  //Low percent based damage (deals random dmg from 0.1%-0.2% on opponent)
  public String attack(Adventurer other){
    return "";
  }

  //set targets health to 0.3 of what it originally was (rounds to integer if there is decimal)
  public String specialAttack(Adventurer other){
    return "";
  }

  //buffs damage of target by 3 hp (doesnt restore special)
  public String support(Adventurer other){
    return "";
  }

}
