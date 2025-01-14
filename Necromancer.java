public class Necromancer extends Adventurer{

  //necromancer special is called mana for now, is subject to change
  int mana, manaMax;

  public Necromancer(String name, int hp) {
    super(name, hp);
    manaMax = 20;
    mana = manaMax/2;
  }

  public Necromancer(String name) {
    this(name, 25);
  }

  public Necromancer() {
    this("Morty");
  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "mana";
  }

  public int getSpecial() {
    return mana;
  }

  public int getSpecialMax() {
    return manaMax;
  }

  public void setSpecial(int n) {
    mana = n;
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
