package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.olhcim.potato.components.Player;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.components.Velocity;

public class PlayerInput extends IteratingSystem implements InputProcessor {

    private static final float maxVel = 10;
    private static final float fireRate = 0.1f;

    private boolean up, down, left, right;
    private boolean u,d,l,r;
    private boolean shoot;
    private float timeToFire;

    //private final OrthographicCamera camera;

    private ComponentMapper<Player> pm = ComponentMapper.getFor(Player.class);
    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);
    private ComponentMapper<Renderable> rm = ComponentMapper.getFor(Renderable.class);

    public PlayerInput() {
        super(Family.getFor(Player.class, Renderable.class, Velocity.class));
        //this.camera = camera;

        Gdx.input.setInputProcessor(this);
    }

    @Override
    protected void processEntity(Entity e, float delta) {
        
        checkForKeyPress();
        
        Velocity vel = vm.get(e);
        
        float svel = 100f;

        if (up) {
            vel.velY = -svel/(1-vel.friction*delta);//vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (down) {
            vel.velY = svel/(1-vel.friction*delta);//vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (left) {
            vel.velX = -svel/(1-vel.friction*delta);//vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (right) {
            vel.velX = svel/(1-vel.friction*delta);//vel.velX * delta * (1 - vel.velX / maxVel);
        }

        if (timeToFire < fireRate) {
            timeToFire += delta;
        } else {
            if (shoot) {
//                        EntityFactory.createPlayerBullet(world, position.x-27, position.y+2).addToWorld();
//                        EntityFactory.createPlayerBullet(world, position.x+27, position.y+2).addToWorld();
                timeToFire = 0;
            }
        }

    }

    public void checkForKeyPress()
    {
//        boolean l = Gdx.input.isKeyPressed(Input.Keys.A);
//        boolean r = Gdx.input.isKeyPressed(Input.Keys.D);
//        boolean u = Gdx.input.isKeyPressed(Input.Keys.W);
//        boolean d = Gdx.input.isKeyPressed(Input.Keys.S);
        
        if(l && !r && !u && !d)
        {
            left = true;
            right = up = down = false;
        } else if(!l && r && !u && !d) {
            right = true;
            left = up = down = false;
        } else if(!l && !r && u && !d) {
            up = true;
            left = right = down = false;
        } else if(!l && !r && !u && d) {
            down = true;
            left = right = up = false;
        } else {
            left = right = up = down = false;
        }
    }
    
    
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            l = true;
        } else if (keycode == Input.Keys.D) {
            r = true;
        } else if (keycode == Input.Keys.W) {
            u = true;
        } else if (keycode == Input.Keys.S) {
            d = true;
        } else if (keycode == Input.Keys.SPACE) {
            shoot = true;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            l = false;
        } else if (keycode == Input.Keys.D) {
            r = false;
        } else if (keycode == Input.Keys.W) {
            u = false;
        } else if (keycode == Input.Keys.S) {
            d = false;
        } else if (keycode == Input.Keys.SPACE) {
            shoot = false;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

}
