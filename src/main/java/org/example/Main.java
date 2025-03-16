package org.example;

import org.example.enums.Types;
import org.example.soldier.Soldier;
import org.example.soldier.soldiers.Archer;
import org.example.soldier.soldiers.Healer;
import org.example.soldier.soldiers.Swordman;
import org.example.soldier.soldiers.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Army 1

        Swordman swordman1 = new Swordman(1, "Swordman");
        Swordman swordman2 = new Swordman(2, "Swordman");
        Swordman swordman3 = new Swordman(3, "Swordman");

        Archer archer1 = new Archer(1, "Archer");
        Archer archer2 = new Archer(2, "Archer");
        Archer archer3 = new Archer(3, "Archer");

        Wizard wizard1 = new Wizard(1, "Wizard");
        Wizard wizard2 = new Wizard(2, "Wizard");
        Wizard wizard3 = new Wizard(3, "Wizard");

        Healer healer1 = new Healer(1, "Healer");
        Healer healer2 = new Healer(2, "Healer");
        Healer healer3 = new Healer(3, "Healer");

        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(swordman1);
        soldiers.add(swordman2);
        soldiers.add(swordman3);
        soldiers.add(archer1);
        soldiers.add(archer2);
        soldiers.add(archer3);
        soldiers.add(wizard1);
        soldiers.add(wizard2);
        soldiers.add(wizard3);
        soldiers.add(healer1);
        soldiers.add(healer2);
        soldiers.add(healer3);

        Army army = new Army(soldiers);

        // Army 2

        Swordman swordman1_a2 = new Swordman(1, "Swordman_a2");
        Swordman swordman2_a2 = new Swordman(2, "Swordman_a2");
        Swordman swordman3_a2 = new Swordman(3, "Swordman_a2");

        Archer archer1_a2 = new Archer(1, "Archer_a2");
        Archer archer2_a2 = new Archer(2, "Archer_a2");
        Archer archer3_a2 = new Archer(3, "Archer_a2");

        Wizard wizard1_a2 = new Wizard(1, "Wizard_a2");
        Wizard wizard2_a2 = new Wizard(2, "Wizard_a2");
        Wizard wizard3_a2 = new Wizard(3, "Wizard_a2");

        Healer healer1_a2 = new Healer(1, "Healer_a2");
        Healer healer2_a2 = new Healer(2, "Healer_a2");
        Healer healer3_a2 = new Healer(3, "Healer_a2");

        List<Soldier> soldiers_a2 = new ArrayList<>();
        soldiers_a2.add(swordman1_a2);
        soldiers_a2.add(swordman2_a2);
        soldiers_a2.add(swordman3_a2);
        soldiers_a2.add(archer1_a2);
        soldiers_a2.add(archer2_a2);
        soldiers_a2.add(archer3_a2);
        soldiers_a2.add(wizard1_a2);
        soldiers_a2.add(wizard2_a2);
        soldiers_a2.add(wizard3_a2);
        soldiers_a2.add(healer1_a2);
        soldiers_a2.add(healer2_a2);
        soldiers_a2.add(healer3_a2);

        Army army2 = new Army(soldiers_a2);


        System.out.println("\n--- Vitaj v mojej armade ---");

        int count = 1;
        while (true) {

            if (checkWinner(count % 2 == 0 ? soldiers_a2 : soldiers)) {
                System.out.println("\n--- Hrac cislo " + (count % 2 == 0 ? 1 : 2) + " je VITAZ !!! ---");
                break;
            }
            System.out.println("\n--- Na rade je hrac cislo " + (count % 2 == 0 ? 2 : 1) + " ---\n");

            System.out.println("0. Quit application ");
            System.out.println("1. Report your army "); // pridaj
            System.out.println("2. Report opponents army "); // pridaj
            System.out.println("3. Ground Attack ");
            System.out.println("4. Full Attack ");
            System.out.println("5. Heal your army ");
            System.out.println("\nType command: ");
            int choice = scanner.nextInt();


            if (count % 2 != 0) {

                switch (choice) {
                    case 0 -> {
                        System.out.println("--------Koniec hry--------");
                        return;
                    }
                    case 1 -> army.report(soldiers);
                    case 2 -> army2.report(soldiers_a2);
                    case 3 -> army.groundAttack(soldiers, soldiers_a2);
                    case 4 -> army.fullAttack(soldiers, soldiers_a2);
                    case 5 -> army.heal(soldiers);

                    default -> {
                        System.out.println("Invalidny prikaz, skus znova:");
                        scanner.nextLine();
                    }
                }
            } else {
                switch (choice) {
                    case 0 -> {
                        System.out.println("Koniec hry");
                        return;
                    }
                    case 1 -> army2.report(soldiers_a2);
                    case 2 -> army.report(soldiers);
                    case 3 -> army2.groundAttack(soldiers_a2, soldiers);
                    case 4 -> army2.fullAttack(soldiers_a2, soldiers);
                    case 5 -> army2.heal(soldiers_a2);

                    default -> {
                        System.out.println("Invalidny prikaz, skus znova:");
                        scanner.nextLine();
                    }

                }
            }

            count++;
        }


    }

    public static boolean checkWinner(List<Soldier> soldiers) {
        for (Soldier soldier : soldiers) {
            if (!(soldier instanceof Healer) && soldier.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

}