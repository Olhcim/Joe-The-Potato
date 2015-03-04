
package com.olhcim.potato.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author Nathan
 */
public class TimeExpire extends Component {
    
    public float delay, progress;
    
    public TimeExpire(float delay)
    {
        this.delay = delay;
        this.progress = 0;
    }
}
