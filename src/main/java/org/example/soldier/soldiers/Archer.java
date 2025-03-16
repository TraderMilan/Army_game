package org.example.soldier.soldiers;

import org.example.enums.Types;
import org.example.interfaces.FullAttack;
import org.example.soldier.Soldier;

public class Archer extends Soldier implements FullAttack {

    public Archer(int number, String soldierClass) {
        super(number, soldierClass, Types.AIR, 100);
    }

    public Types getType(){
        return super.getType();
    }


    @Override
    public void fullAttack() {
    }
}
