package Core.game;
import Core.game_engine.LayerTypes;
import Core.game_engine.Sprite;
import Core.game_engine.input_commands.MoveAble;
import Core.game_engine.physics.PhysicsComponent;
import processing.core.PApplet;
import processing.core.PVector;

public class Player extends Sprite implements MoveAble {
    public PVector size;
    public PhysicsComponent physicsComponent;
    public float acceleration = 2f;
    public Player(PApplet p, int x, int y, int w, int h){
        super(p, x, y, w, h);
        this.parent = p;
        this.layerType = LayerTypes.MOVING;
        this.size = new PVector(w,h, 0);
        physicsComponent = new PhysicsComponent(this, this.boxCollider2D);
    }

    @Override
    public void update(){
        super.update();
        // player
        parent.pushMatrix();
        parent.rectMode(PApplet.CENTER);
        parent.translate(this.position.x, this.position.y);
        parent.fill(150,0,200,200);
        this.parent.rect(0,0, this.size.x, this.size.y);
        parent.popMatrix();
    }

    @Override
    public void moveLeft(){
        this.physicsComponent.setVelocity(-acceleration, 0);
    }

    @Override
    public void moveRight() {
        this.physicsComponent.setVelocity(acceleration, 0);
    }

    @Override
    public void moveUp() {
        this.physicsComponent.setVelocity(0, -acceleration);
    }

    @Override
    public void moveDown() {
        this.physicsComponent.setVelocity(0, acceleration);;
    }
}
