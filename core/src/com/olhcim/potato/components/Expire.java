
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class Expire extends Component {
    public float delay;
    
    public Expire(float delay)
    {
        this.delay = delay;
    }
}
