package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.olhcim.potato.components.Player;
import com.olhcim.potato.components.Renderable;
import com.olhcim.potato.components.Velocity;

public class PlayerInput extends IteratingSystem implements InputProcessor {

    private static final float maxVel = 10;
    private static final float fireRate = 0.1f;

    private boolean up, down, left, right;
    private boolean shoot;
    private float timeToFire;

    //private final OrthographicCamera camera;

    private ComponentMapper<Player> pm = ComponentMapper.getFor(Player.class);
    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);
    private ComponentMapper<Renderable> rm = ComponentMapper.getFor(Renderable.class);

    public PlayerInput() {
        super(Family.getFor(Player.class, Renderable.class, Velocity.class));
        //this.camera = camera;

        //Gdx.input.setInputProcessor(this);
    }

    @Override
    protected void processEntity(Entity e, float delta) {
        Renderable renderable = rm.get(e);
        Velocity vel = vm.get(e);
        
        System.out.println("YEP");

        if (up) {
            System.out.println("up");
            vel.velX -= vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (down) {
            System.out.println("down");
            vel.velX += vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (left) {
            System.out.println("left");
            vel.velX -= vel.velX * delta * (1 - vel.velX / maxVel);
        }
        if (right) {
            System.out.println("right");
            vel.velX += vel.velX * delta * (1 - vel.velX / maxVel);
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

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            left = true;
        } else if (keycode == Input.Keys.D) {
            right = true;
        } else if (keycode == Input.Keys.W) {
            up = true;
        } else if (keycode == Input.Keys.S) {
            down = true;
        } else if (keycode == Input.Keys.SPACE) {
            shoot = true;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            left = false;
        } else if (keycode == Input.Keys.D) {
            right = false;
        } else if (keycode == Input.Keys.W) {
            up = false;
        } else if (keycode == Input.Keys.S) {
            down = false;
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
