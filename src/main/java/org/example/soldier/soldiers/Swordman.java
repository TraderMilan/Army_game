package org.example.soldier.soldiers;

import org.example.enums.Types;
import org.example.interfaces.GroundAttack;
import org.example.soldier.Soldier;

public class Swordman extends Soldier implements GroundAttack {


    public Swordman(int number, String soldierClass) {
        super(number, soldierClass, Types.GROUND, 100);
    }

    public Types getType() {
        return super.getType();
    }

    @Override
    public void groundAttack() {
    }
}
