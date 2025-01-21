public class Boss extends Adventurer{
  
  int voidEssence, voidEssenceMax;

  public Boss(String name, int hp) {
    super(name, hp);
    voidEssenceMax = 20;
    voidEssence = 9;
  }

  public Boss(String name) {
    this(name, 40);
  }

  public Boss() {
    this("Voldemort");
  }
  //add overloaded contructors if necessary

  public String getSpecialName() {
    return "Void Essence";
  }

  public int getSpecial() {
    return voidEssence;
  }

  public int getSpecialMax() {
    return voidEssenceMax;
  }

  public void setSpecial(int n) {
    voidEssence = n;
  }


  //attack/support/special

  public String attack(Adventurer other){
    int damage = 5 + (int)(Math.random() * 3);
    damage += other.getDmg();
    if (other.getHP() - damage < 0) {
      other.setHP(0);
    } else {
      other.applyDamage(damage);
    }
    return this + " used Corrupting Touch on " + other + " and dealt " + damage + " damage by spreading darkness throughout their body.";
  }

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
      return this + " summoned black holes and took away 50% of " + other + "'s health.";
    }else{
      return this + " did not have enough void essence to summon black holes. Instead "+attack(other);
    }

  }


  public String support(Adventurer other){
    //if(this == other) {
      //return this.support();
    //}
    if (getHP() - 5 > 0) {
      setHP(getHP() - 5);
      setSpecial(getSpecial() + 7);
      return this + " sacrificed 5 of their own hp in return for 7 void essence.";
    }
    else {
      setHP(getHP() + 5);
      return this + " did not have enough health to perform Void Sacrifice. Instead they healed themself for 5 hp.";
    }
  }

  public String support(){
    if (getHP() - 5 > 0) {
      setHP(getHP() - 5);
      setSpecial(getSpecial() + 7);
      return this + " sacrificed 5 of their own hp in return for 7 void essence.";
    } else {
      return this + " did not have enough health to perform Void Sacrifice. Instead ";
    }
    
  }
}
