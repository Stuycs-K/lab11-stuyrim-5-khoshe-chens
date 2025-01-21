public class Necromancer extends Adventurer{

  //necromancer special is called mana for now, is subject to change
  int souls, soulsMax;

  public Necromancer(String name, int hp) {
    super(name, hp);
    soulsMax = 15;
    souls = 8;
  }

  public Necromancer(String name) {
    this(name, 25);
  }

  public Necromancer() {
    this("Morty");
  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "souls";
  }

  public int getSpecial() {
    return souls;
  }

  public int getSpecialMax() {
    return soulsMax;
  }

  public void setSpecial(int n) {
    souls = n;
  }





  //attack/support/special

  //Low percent based damage (deals random dmg from 10%-20% on opponent)
  public String attack(Adventurer other){
    double percent = ((int) (Math.random()*2) + 1) * 0.05 + 0.1;
    double damage =  other.getHP() * percent;
    damage += other.getDmg();
    if (other.getHP() - damage < 0) {
      other.setHP(0);
    } else {
      other.applyDamage((int) damage);
    }
    return this + " drained " + other + "'s health using its staff and dealt " + (int) damage + " damage.";
  }

  //set targets health to 0.3 of what it originally was (rounds to integer if there is decimal)
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 9){
      setSpecial(getSpecial()-9);
      int damage = 0;
      setHP((int) (getHP() * 0.3));
      damage += other.getDmg();
      if (other.getHP() - damage < 0) {
        other.setHP(0);
      } else {
        other.applyDamage(damage);
      }
      return this + " cursed " + other + " with Death's Touch and set their hp to 0.3 of what it originally was.";
    }else{
      return this + " did not have enough souls to perform Death's Touch. Instead "+attack(other);
    }

    
  }

  //buffs damage of target by 3 hp (doesnt restore special)
  public String support(Adventurer other){
    if(this == other) {
      return this.support();
    }
    other.setDmg(other.getDmg() + 3);
    return this + " summoned skeletons to help " + other + " in battle and buffed their damage by 3.";
  }

  public String support(){
    this.setDmg(this.getDmg() + 3);
    return this + " summoned skeletons to defend themself and buffed their own damage by 3.";
  }

}
