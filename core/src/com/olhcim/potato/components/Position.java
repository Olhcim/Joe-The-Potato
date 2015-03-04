
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Position extends Component {
    
    public float x,y,prex,prey;
    
    public Position()
    {
        this(0,0);
    }
    
    public Position(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.prex = x;
        this.prey = y;
    }
}
