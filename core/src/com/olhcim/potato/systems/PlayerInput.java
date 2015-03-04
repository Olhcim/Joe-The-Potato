package com.olhcim.potato.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.olhcim.potato.Main;
import com.olhcim.potato.components.Player;
import com.olhcim.potato.components.Position;
import com.olhcim.potato.components.Velocity;
import com.olhcim.potato.util.EntityFactory;

public class PlayerInput extends IteratingSystem {

    private static final float maxVel = 200;
    private static final float diagMaxVel = (float) (maxVel * Math.sqrt(0.5)); 
    private static final float fireRate = 0.5f;
    private static final float shootDist = 500;
    private static final float shootVel = 700;

    private boolean moveUp, moveDown, moveLeft, moveRight;
    private boolean shootUp, shootDown, shootLeft, shootRight;
    private float timeToFire;

    private ComponentMapper<Position> pm = ComponentMapper.getFor(Position.class);
    private ComponentMapper<Velocity> vm = ComponentMapper.getFor(Velocity.class);

    public PlayerInput(Entity player) {
        super(Family.getFor(Player.class, Position.class, Velocity.class));
    }

    @Override
    protected void processEntity(Entity e, float delta) {

        checkForKeyPress();

        Position pos = pm.get(e);
        Velocity vel = vm.get(e);

        move(vel);

        if (timeToFire < fireRate) {
            timeToFire += delta;
        } else if (shootUp || shootDown || shootLeft || shootRight) {
            
            Entity bullet;
            
            if (shootUp) {
                bullet = EntityFactory.createBullet(pos.x, pos.y, vel.velX, vel.velY - shootVel, shootDist);
            } else if (shootDown) {
                bullet = EntityFactory.createBullet(pos.x, pos.y, vel.velX, vel.velY + shootVel, shootDist);
            } else if (shootLeft) {
                bullet = EntityFactory.createBullet(pos.x, pos.y, vel.velX - shootVel, vel.velY, shootDist);
            } else {
                bullet = EntityFactory.createBullet(pos.x, pos.y, vel.velX + shootVel, vel.velY, shootDist);
            }
            
            Main.screenGame.engine.addEntity(bullet);
            
            timeToFire = 0;
        }
    }
    
    public void move(Velocity vel)
    {
        boolean uORd = moveUp != moveDown;
        boolean lORr = moveLeft != moveRight;
        
        boolean u = moveUp      && uORd && !lORr;
        boolean d = moveDown    && uORd && !lORr;
        boolean l = moveLeft    && lORr && !uORd;
        boolean r = moveRight   && lORr && !uORd;
        
//        boolean ul = moveUp && !moveDown && moveLeft && !moveRight;
//        boolean ur = moveUp && !moveDown && !moveLeft && moveRight;
//        boolean dl = !moveUp && moveDown && moveLeft && !moveRight;
//        boolean dr = !moveUp && moveDown && !moveLeft && moveRight;
        
        if( u ) {
            vel.velY = -maxVel;
        } else if ( d ) {
            vel.velY = maxVel;
        } else if ( l ) {
            vel.velX = -maxVel;
        } else if ( r ) {
            vel.velX = maxVel;
        }
        
//        else if ( ul ) {
//            vel.velY = -diagMaxVel;
//            vel.velX = -diagMaxVel;
//        } else if ( ur ) {
//            vel.velY = -diagMaxVel;
//            vel.velX = diagMaxVel;
//        }  else if ( dl ) {
//            vel.velY = diagMaxVel;
//            vel.velX = -diagMaxVel;
//        } else if ( dr ) {
//            vel.velY = diagMaxVel;
//            vel.velX = diagMaxVel;
//        }
    }

    public void checkForKeyPress() {
        
        boolean ml = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean mr = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean mu = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean md = Gdx.input.isKeyPressed(Input.Keys.S);

        if (ml) {
            moveLeft = true;
            moveRight = moveUp = moveDown = false;
        } else if (mr) {
            moveRight = true;
            moveLeft = moveUp = moveDown = false;
        } else if (mu) {
            moveUp = true;
            moveLeft = moveRight = moveDown = false;
        } else if (md) {
            moveDown = true;
            moveLeft = moveRight = moveUp = false;
        } else {
            moveLeft = moveRight = moveUp = moveDown = false;
        }
        
        boolean sl = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean sr = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean su = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean sd = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (sl && !sr && !su && !sd) {
            shootLeft = true;
            shootRight = shootUp = shootDown = false;
        } else if (!sl && sr && !su && !sd) {
            shootRight = true;
            shootLeft = shootUp = shootDown = false;
        } else if (!sl && !sr && su && !sd) {
            shootUp = true;
            shootLeft = shootRight = shootDown = false;
        } else if (!sl && !sr && !su && sd) {
            shootDown = true;
            shootLeft = shootRight = shootUp = false;
        } else {
            shootLeft = shootRight = shootUp = shootDown = false;
        }
    }
}
