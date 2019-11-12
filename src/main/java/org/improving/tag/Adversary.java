package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;

@Entity (name = "Adversary")
public class Adversary {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "Name")
   private String name;

    @Column(name = "HitPoints")
   private int hitPoints;

    @Column(name = "DamageTaken")
   private int DamageTaken;

    @Column(name = "AttackDamage")
   private int AttackDamage;

    @Transient()
    private Item Item;

    @Transient
   private Item item = UniqueItems.NOTHING;

    @Column(name = "DropItem")
    private UniqueItems uniqueItems;


    public Adversary(){

    }

   public Adversary(String name){
       this.id=id;
       this.name=name;
       this.hitPoints = 50;
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

    public Item getItem() {
        return Item;
    }

    public void setItem(Item item) {
        Item = item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @PostLoad
//    public void postLoad(){
//        //String dropItem = result.getString("DropItem");
//        if (null != itemstr) {
//            this.setItem(Arrays
//                    .stream(UniqueItems.values())
//                    .filter(uniqueItems -> uniqueItems.getName().equals(itemstr))
//                    .findFirst()
//                    .orElse(null));
//        }
}
