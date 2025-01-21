import java.util.*;
public class Priest extends Adventurer{
  int faith, faithMax;

  public Priest(String name, int hp) {
    super(name, hp);
    faithMax = 15;
    faith = 7;
  }

  public Priest(String name) {
    this(name, 20);
  }

  public Priest() {
    this("Jesus");
  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "faith";
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
    if (other.getHP() - damage < 0) {
      other.setHP(0);
    } else {
      other.applyDamage(damage);
    }
    return this + " struck " + other + " with Holy Light, dealing " + damage + " damage to them.";
  }

  //heals its own team by 3 and buffs each persons damage (including own) by 2
  public String specialAttack(ArrayList<Adventurer> other){
    if(getSpecial() >= 9) {
      setSpecial(getSpecial()-9);
      for(int i = 0; i < other.size(); i++) {
        Adventurer current = other.get(i);
        if(current.getHP() + 3 > current.getmaxHP()) {
          current.setHP(current.getmaxHP());
        } else {
          current.setHP(current.getHP() + 3);
        }
        current.setDmg(current.getDmg() + 2);
      }
      return this + " blessed their own team with Divine Grace and healed everyone for 3 hp and buffed everyone's damage by 2.";
    } else {
      return this + " did not have enough faith to use Divine Grace. Instead "+ support(other.get(1));
    }
    
  }
    

  public String specialAttack(Adventurer other) {
    return "doesn't do anything";
  }

  //heals target by 5 hp (doesnt restore special)
  public String support(Adventurer other){
    if(this == other) {
      return this.support();
    }
    if(other.getHP() + 5 > other.getmaxHP()) {
      other.setHP(other.getmaxHP());
    } else {
      other.setHP(other.getHP() + 5);
    }
    return this + " casted a healing spell to rejuvenate " + other + " by 5 hp.";
  }

  public String support(){
    if(getHP() + 5 > getmaxHP()) {
      setHP(getmaxHP());
    } else {
      setHP(getHP() + 5);
    }
    return this + " casted a spell and healed themselves for 5 hp.";
  }





}
