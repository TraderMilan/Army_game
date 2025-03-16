package org.example.soldier.soldiers;

import org.example.enums.Types;
import org.example.interfaces.Heal;
import org.example.soldier.Soldier;

public class Healer extends Soldier implements Heal {

    public Healer(int number, String soldierClass) {
        super(number, soldierClass, Types.HEALING, 50);
    }

    @Override
    public void heal() {
    }


    @Override
    public Types getType() {
        return super.getType();
    }
}
