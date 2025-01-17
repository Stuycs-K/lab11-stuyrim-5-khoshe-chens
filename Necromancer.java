public class Necromancer extends Adventurer{

  //necromancer special is called mana for now, is subject to change
  int mana, manaMax;
  int baseDmg;

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

  public int getDmg() {
    return baseDmg;
  }

  public void setDmg(int newDmg) {
    baseDmg = newDmg;
  }

  //attack/support/special

  //Low percent based damage (deals random dmg from 10%-20% on opponent)
  public String attack(Adventurer other){
    double damage =  other.getHP() * ((int) (Math.random()*2) + 1) * 0.05 + 0.1;
    damage += baseDmg;
    other.applyDamage(damage);
    return this + " attacked " + other + " for " + damage + " damage.";
    return "";
  }

  //set targets health to 0.3 of what it originally was (rounds to integer if there is decimal)
  public String specialAttack(Adventurer other){
    if(this == other) {
      return this.support();
    }
    setHP((int) (getHP() * 0.3));
    return "Cast a spell to heal " + other + " by 5 hp.";
  }

  //buffs damage of target by 3 hp (doesnt restore special)
  public String support(Adventurer other){
    if(this == other) {
      return this.support();
    }
    setDmg(getDmg() + 3);
    return "Buffed " + other + " damage by 3.";
  }

  public String support(){
    setDmg(getDmg() + 3);
    return "Buffed their own damage by 3.";
  }

}
