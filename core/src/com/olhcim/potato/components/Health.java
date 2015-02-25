
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Health extends Component {
    
    public int health;
    public int maxHealth;
    
    public Health(int maxHealth)
    {
        this(maxHealth, maxHealth);
    }
    
    public Health(int health, int maxHealth)
    {
        this.health = health;
        this.maxHealth = maxHealth;
    }
}
