public class Priest extends Adventurer{
  //priest special is called mana for now, is subject to change
  int mana, manaMax;
  int baseDmg;

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

  public int getDmg() {
    return baseDmg;
  }

  public void setDmg(int newDmg) {
    baseDmg = newDmg;
  }



  //attack/support/special

  //Low damage (deals random dmg from 1-3 on opponent)
  public String attack(Adventurer other){
    int damage = (int) (Math.random()*3) + 1;
    damage += baseDmg;
    other.applyDamage(damage);
    return this + " attacked " + other + " for " + damage + " damage.";
  }

  //heals its own team by 3 and buffs each persons damage (including own) by 2
  public String specialAttack(ArrayList<Adventurer> other){
    return "";
  }

  //heals target by 5 hp (doesnt restore special)
  public String support(Adventurer other){
    if(this == other) {
      return this.support();
    }
    setHP(getHP() + 5);
    return "Cast a spell to heal " + other + " by 5 hp.";
  }

  public String support(){
    setHP(getHP() + 5);
    return "Healed themselves for 5 HP";
  }





}
