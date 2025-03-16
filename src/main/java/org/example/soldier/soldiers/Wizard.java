package org.example.soldier.soldiers;

import org.example.enums.Types;
import org.example.interfaces.GroundAttack;
import org.example.interfaces.FullAttack;
import org.example.soldier.Soldier;

public class Wizard extends Soldier implements GroundAttack, FullAttack {

    public Wizard(int number, String soldierClass) {
        super(number, soldierClass, Types.ADAPTABLE, 75);
    }

    public Types getType(){
        return super.getType();
    }


    @Override
    public void groundAttack() {
    }

    @Override
    public void fullAttack() {
    }
}
