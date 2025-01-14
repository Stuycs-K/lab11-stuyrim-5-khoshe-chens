public class Priest extends Adventurer{
  //priest special is called mana for now, is subject to change
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

  //Low damage (deals random dmg from 1-3 on opponent)
  public String attack(Adventurer other){
    return "";
  }

  //heals its own team by 3 and buffs each persons damage (including own) by 2
  public String specialAttack(Adventurer other){
    return "";
  }

  //heals target by 5 hp (doesnt restore special)
  public String support(Adventurer other){
    return "";
  }





}
