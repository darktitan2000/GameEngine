package Core.game;
import Core.game_engine.GameObject;
import Core.game_engine.Sprite;
import processing.core.PApplet;
import processing.core.PVector;

public class Platform extends Sprite {
    public PVector size;
    public Platform(PApplet p, int x, int y, int w, int h){
        super(p,x,y,w,h);
        this.parent = p;
        this.size = new PVector(w,h, 0);
        this.position = new PVector(x, y,0);

    }
    @Override
    public void update(){
        parent.pushMatrix();
        // platform rectangle
        parent.rectMode(PApplet.CENTER);
        parent.translate(this.position.x, this.position.y);
        this.parent.rect(0,0, this.size.x, this.size.y);
        parent.popMatrix();
    }
}
