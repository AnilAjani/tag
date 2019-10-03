package org.improving.tag;

public class Adversary {
   private String name;
   private int hitPoints;
   private int DamageTaken;
   private int AttackDamage;

   public Adversary(String name){
       this.name=name;
       this.hitPoints = 20;
       this.DamageTaken = 0;
       this.AttackDamage =10;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return DamageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        DamageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        AttackDamage = attackDamage;
    }
}
