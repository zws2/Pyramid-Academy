package com.company;

import java.util.Random;

public class Player {

    protected String name;
    protected char token;
    protected int[] position;

    protected int attackMod;
    protected int damageDie;
    protected int damageMod;
    protected int ac;
    protected int hp;

    protected boolean isDead;

    protected Player enemy;

    public void takeTurn(){
        char[][] grid = Game.getGrid();
        if(position[0] >= 0 && position[1] >= 0){
            if(attemptMove(new int[]{1,0})){
                System.out.println("up");
            }else if(attemptMove(new int[]{-1,0})){
                System.out.println("down");
            }else if(attemptMove(new int[]{0,1})){
                System.out.println("left");
            }else if(attemptMove(new int[]{0,-1})){
                System.out.println("right");
            }else System.out.println("no move");
        }
    }

    protected boolean attemptMove(int[] coords){
        if(position[0]-coords[0] >= Game.GRID_SIZE || position[1]+coords[1] >= Game.GRID_SIZE
            || position[0]-coords[0] < 0 || position[1]+coords[1] < 0) return false;

        char[][] grid = Game.getGrid();
        if(grid[position[0]-coords[0]][position[1]+coords[1]] == enemy.token){
            Game.combat(this, enemy);
        }
        if(grid[position[0]-coords[0]][position[1]+coords[1]] == ' '){

            grid[position[0]][position[1]] = ' ';
            grid[position[0]-coords[0]][position[1]+coords[1]] = token;

            position[0] = position[0]-coords[0];
            position[1] = position[1]+coords[1];

            return true;
        }else return false;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    public void attack(Player enemy){

            System.out.println(name + " Turn...");

            int damage = rollDamage();
            System.out.println(name + " Dealt " + damage + " damage to " + enemy.name + "!");
            enemy.takeDamage(damage);

            System.out.println(enemy.toString());
    }

//    private int rollAttack(){
//
//
//    }

    private int rollDamage(){
        Random rand = new Random();

        return rand.nextInt(damageDie) + damageMod;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int damage){

        hp -= damage;
        if(hp < 0) isDead = true;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }
}
