public class Priest extends Adventurer{
  //priest special is called mana for now, is subject to change
  int mana, manaMax;

  public Priest(String name, int hp) {
    super(name, hp);
    manaMax = 20;
    mana = manaMax/2;
  }

  public Priest(String name) {
    this(name, 20);
  }

  public Priest() {
    this("Jesus");
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
