package Core.game_engine.physics;

import Core.game_engine.Component;
import Core.game_engine.Sprite;
import java.util.ArrayList;

public class BoxCollider2D extends Component {
    private boolean hasCollided = false;
    private Rectangle bounds;

    private SIDES hitSide = SIDES.NONE;

    public SIDES getHitSide(){ return hitSide;}


    public Rectangle getBounds() {
        return bounds;
    }

    public ArrayList<BoxCollider2D> otherColliders = new ArrayList<>();


    public BoxCollider2D(Sprite g, float w, float h){
        super(g);
        this.bounds = new Rectangle(gameObject.position.x, gameObject.position.y, w, h);
        // update next collision

    }
    @Override
    public void update() {
        this.bounds.updateBounds(gameObject.position.x, gameObject.position.y);
    }
    public void check_Collisions(BoxCollider2D other){
        this.hasCollided = this.bounds.isOverlapping(other.bounds);
        if(this.hasCollided){
            this.otherColliders.add(other);
        }
    }
    public void findCollisionSide(BoxCollider2D otherBox2D){
        // overlap confirmed, now detect actual size
        hitSide = SIDES.NONE;
        // is touching above
        boolean isTouchingAbove = this.bounds.getIsTouchingAbove(otherBox2D.bounds);
        boolean isTouchingBelow = false;
        if(!isTouchingAbove){
            //check below
            isTouchingBelow = this.bounds.getIsTouchingBelow(otherBox2D.bounds);
        }
        if(isTouchingAbove){
            hitSide = SIDES.BOTTOM;
        }else if(isTouchingBelow){
            hitSide = SIDES.TOP;
        }
        // do side
        if (hitSide == SIDES.NONE){
            boolean isTouchingRight = this.bounds.getIsTouchingRight(otherBox2D.bounds);
            boolean isTouchingLeft = false;
            if(!isTouchingRight){
                isTouchingLeft = this.bounds.getIsTouchingLeft(otherBox2D.bounds);
            }
            if (isTouchingLeft){
                hitSide = SIDES.LEFT;
            }else if (isTouchingRight){
                hitSide = SIDES.RIGHT;
            }
        }
    }
}
