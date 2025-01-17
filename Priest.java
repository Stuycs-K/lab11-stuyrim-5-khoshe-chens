import java.util.*;
public class Priest extends Adventurer{
  //priest special is called mana for now, is subject to change
  int faith, faithMax;

  public Priest(String name, int hp) {
    super(name, hp);
    faithMax = 20;
    faith = faithMax/2;
  }

  public Priest(String name) {
    this(name, 20);
  }

  public Priest() {
    this("Jesus");
  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "Faith";
  }

  public int getSpecial() {
    return faith;
  }

  public int getSpecialMax() {
    return faithMax;
  }

  public void setSpecial(int n) {
    faith = n;
  }




  //attack/support/special

  //Low damage (deals random dmg from 1-3 on opponent)
  public String attack(Adventurer other){
    int damage = (int) (Math.random()*3) + 1;
    damage += other.getDmg();
    other.applyDamage(damage);
    return this + " attacked " + other + " for " + damage + " damage.";
  }

  //heals its own team by 3 and buffs each persons damage (including own) by 2
  public String specialAttack(ArrayList<Adventurer> other){
    for(int i = 0; i < other.size(); i++) {
      Adventurer current = other.get(i);
      current.setHP(current.getHP() + 3);
      current.setDmg(current.getDmg() + 2);
    }
    return this + " healed their whole team for 3HP and buffed everyone's damage by 2";
  }

  public String specialAttack(Adventurer other) {
    return "doesn't do anything";
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
