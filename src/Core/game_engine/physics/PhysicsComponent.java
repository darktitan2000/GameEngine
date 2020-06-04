package Core.game_engine.physics;

import Core.game_engine.Component;
import Core.game_engine.Sprite;
import processing.core.PVector;

public class PhysicsComponent extends Component {
    private PVector velocity = new PVector(0,0,0);
    public float maxSpeed = 5f;
    private float friction = 0.9f;
    private float spacer = 0.3f;
    private float gravity = 1.1f;
    private BoxCollider2D boxCollider2D;
    public PhysicsComponent(Sprite g, BoxCollider2D b) {
        super(g);
        this.boxCollider2D = b;
    }

    @Override
    public void update() {
        if(velocity.mag() > maxSpeed){
            velocity.setMag(maxSpeed);
        }
        if(this.boxCollider2D.otherColliders.size() > 0){
            for(BoxCollider2D b : this.boxCollider2D.otherColliders){
                // has hit do something

                setCollisionSide(b);

            }
            this.boxCollider2D.otherColliders.clear();
        }
        this.velocity.mult(friction);
        this.gameObject.position = this.gameObject.next_position.copy();
        this.gameObject.next_position.add(this.velocity);
    }

    public void setVelocity(float x, float y) {
        velocity.x += x;
        velocity.y += y;
    }

    private void setCollisionSide(BoxCollider2D otherBox2D){
        this.boxCollider2D.findCollisionSide(otherBox2D);
        Point otherTopRight = otherBox2D.getBounds().getTopRight();
        Point otherBottomLeft = otherBox2D.getBounds().getBottomLeft();
        // switch case for the side hit
        switch (this.boxCollider2D.getHitSide()){
            case TOP:
                // put this object on the bottom
                this.gameObject.next_position.y = otherBottomLeft.getY() + this.boxCollider2D.getBounds().getHeight() / 2f + spacer;
                velocity.y = gravity;
                System.out.println("Hit Top");
                break;
            case BOTTOM:
                this.gameObject.next_position.y = otherTopRight.getY() - this.boxCollider2D.getBounds().getHeight() / 2f - spacer;
                velocity.y = 0f;
                System.out.println("Hit Bottom");
                break;
            case LEFT:
                velocity.y = 0f;
                this.gameObject.next_position.x = otherBottomLeft.getX() - this.boxCollider2D.getBounds().getWidth() / 2f - spacer;
                System.out.println("Hit Left");
                break;
            case RIGHT:
                velocity.y = 0f;
                this.gameObject.next_position.x = otherTopRight.getX() - this.boxCollider2D.getBounds().getWidth() / 2f + spacer;
                System.out.println("Hit Right");
                break;
        }
    }
}
