
package com.olhcim.joe_the_potato.entities;

public abstract class EntityLiving extends Entity {

    protected int health;

    
    public EntityLiving(double x, double y) {
        super(x, y);
        this.health = getMaxHealth();
    }
    
    protected abstract int getMaxHealth();
    protected abstract int getAttackStrength();
    
    public void heal(int amount)
    {
        health = health + amount > getMaxHealth() ? getMaxHealth() : health + amount;
    }
    
    public void damage(int amount)
    {
        health = health - amount < 0 ? 0 : health - amount;
    }
    
    public boolean isDead()
    {
        return this.health <= 0;
    }
    
    protected abstract void onDeath();
    
    public abstract void attack(EntityLiving target);
    
}
