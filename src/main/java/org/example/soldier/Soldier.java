package org.example.soldier;

import org.example.enums.Types;

public abstract class Soldier {
    private final String name = "Soldier";
    private String soldierClass;
    private int number;
    private Types type;
    private int health = 100;
    private String description;


    public Soldier(int number, String soldierClass, Types type, int health) {
        this.health = health;
        this.number = number;
        this.soldierClass = soldierClass;
        this.type = type;
        this.description = findDescription(type);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    public String getSoldierClass() {
        return soldierClass;
    }

    public Types getType() {
        return type;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getDescription() {
        return description;
    }
    public String findDescription(Types type){
        switch (type){
            case GROUND -> {
                return "deals 15 - 35 damage to ground troops";}
            case AIR -> {
                return " deals 15 - 25 to all types of troops";}
            case ADAPTABLE -> {
                return " deals 15 - 35 to ground troops and 15 - 25 to all types of troops";}
            case HEALING -> {
                return " heals 50 health point to all soldiers";}
            default -> {
                return " Error while finding description ";
            }
            }
        }
    }


