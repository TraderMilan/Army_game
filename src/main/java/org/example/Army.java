package org.example;

import org.example.enums.Types;
import org.example.interfaces.FullAttack;
import org.example.interfaces.GroundAttack;
import org.example.interfaces.Heal;
import org.example.soldier.Soldier;
import org.example.soldier.soldiers.Healer;


import java.util.List;

public class Army {
    private List<Soldier> soldiers;

    public Army(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }



    public void report(List<Soldier> soldiers) {
        System.out.println("---------Report---------");
        for (Soldier soldier : soldiers) {
            if (soldier.getHealth() <= 0) {
                deathSoldier(soldier);
            } else {
                printSoldier(soldier);
            }
        }
    }


    // jeden healer dokáže pridať 50 životov (dokopy) živým jednotkám
    public void heal(List<Soldier> soldiers) {
        int heal = 50;
        int total = (int) soldiers.stream().filter(soldier -> soldier.getType().equals(Types.HEALING))
                .filter(soldier -> soldier.getHealth() > 0).count() * heal;
        if(total == 0){
            System.out.println("--- All healers are death ---");
            return;
        }

        int countOfAliveSoldiers = (int) soldiers.stream().filter(soldier -> !(soldier.getType().equals(Types.HEALING)))
                .filter(soldier -> soldier.getHealth() > 0).count();

        System.out.println("---------Heal---------");
        System.out.println("--- Healers healed total of " + total + " health ---");
        for (Soldier soldier : soldiers) {
            if ((!(soldier instanceof Healer)) && soldier.getHealth() > 0) {
                System.out.println(soldier.getSoldierClass() + " " + soldier.getHealth() + " -> " + (soldier.getHealth() + (total/countOfAliveSoldiers)));
                soldier.setHealth(soldier.getHealth() + (total/countOfAliveSoldiers));

            }
        }
    }


    // Útok na pozemné jednotky (na Všetky okrem healer), útočia wizardi a swordmani
    public void groundAttack(List<Soldier> AttackingSoldiers, List<Soldier> DefendingSoldiers) {

        int defendingAliveCount = (int) DefendingSoldiers.stream()
                .filter(soldier -> soldier.getHealth() > 0).filter(soldier -> !(soldier.getSoldierClass()
                        .equals("Healer"))).count();


        int attackingAliveCount = (int) AttackingSoldiers.stream()
                .filter(soldier -> soldier.getHealth() > 0).filter(soldier -> soldier.getType().equals(Types.GROUND)
                || soldier.getType().equals(Types.ADAPTABLE)).count();

        int sumOfDamages = 0;


        System.out.println("---------Full Attack---------");
        for (Soldier soldier : DefendingSoldiers) {
            if (soldier.getHealth() > 0 && !(soldier instanceof Heal)) {
                int Damage = (int) (((Math.random() * 35) + 15) * ((double) attackingAliveCount/defendingAliveCount));
                sumOfDamages += Damage;
                soldier.setHealth(soldier.getHealth() - Damage);
            }
        }

        for (Soldier soldierA : AttackingSoldiers) {
            if (soldierA.getHealth() <= 0) {
                deathSoldier(soldierA);
            } else if (soldierA instanceof GroundAttack) {
                System.out.println(soldierA.getName() + " " + soldierA.getSoldierClass() + " " + soldierA.getNumber()
                        + " is attacking... " );
            } else {
                System.out.println(soldierA.getSoldierClass() + " is resting... ");
            }
        }

        System.out.println("\n Your soldiers dealt " + sumOfDamages + " damage");
    }



    // Full Attack útočia wizards a archers na všetky jednotka (aj na healers)
    public void fullAttack(List<Soldier> AttackingSoldiers, List<Soldier> DefendingSoldiers) {
        int defendingAliveCount = (int) DefendingSoldiers.stream()
                .filter(soldier -> soldier.getHealth() > 0).count();


        int attackingAliveCount = (int) AttackingSoldiers.stream()
                .filter(soldier -> soldier.getHealth() > 0).filter(soldier -> soldier.getType().equals(Types.AIR)
                        || soldier.getType().equals(Types.ADAPTABLE)).count();

        int sumOfDamages = 0;


        System.out.println("---------Ground Attack---------");
        for (Soldier soldier : DefendingSoldiers) {
            if (soldier.getHealth() > 0) {
                int Damage = (int) (((Math.random() * 25) + 15) * ((double)attackingAliveCount/defendingAliveCount));
                sumOfDamages += Damage;
                soldier.setHealth(soldier.getHealth() - Damage);
            }
        }

        for (Soldier soldierA : AttackingSoldiers) {
            if (soldierA.getHealth() <= 0) {
                deathSoldier(soldierA);
            } else if (soldierA instanceof FullAttack) {
                System.out.println(soldierA.getName() + " " + soldierA.getSoldierClass() + " " + soldierA.getNumber()
                        + " is attacking... " );
            } else {
                System.out.println(soldierA.getSoldierClass() + " is resting... ");
            }
        }

        System.out.println("\n Your soldiers dealt " + sumOfDamages + " damage");
    }

    public void deathSoldier(Soldier soldier) {
        System.out.println(soldier.getName() + " " + soldier.getSoldierClass() + "-" + soldier.getNumber() + " ---Death---");
    }


    private void printSoldier(Soldier soldier) {
        System.out.println(soldier.getName() + " " + soldier.getSoldierClass() + "-" + soldier.getNumber()
                + " |  • Type: " + soldier.getType() + " |  • Health: " + soldier.getHealth()
                + " |  • Description: " + soldier.getDescription());
    }


}
