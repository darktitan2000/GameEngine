package Core.game;

import Core.game_engine.GameObject;
import Core.game_engine.LayerTypes;
import Core.game_engine.physics.BoxCollider2D;
import Core.game_engine.Sprite;
import processing.core.PApplet;
import processing.core.PVector;

public class CollectableThing extends Sprite {

    public PVector size;

    public CollectableThing(PApplet p, int x, int y, int w, int h) {
        super(p, x, y, w, h);
        this.parent = p;
        this.layerType = LayerTypes.INTERACTABLE;
        this.size = new PVector(w, h, 0);
        this.position = new PVector(x, y, 0);

    }

    @Override
    public void update() {
        if(!this.isActive){ return; }
        super.update();
        parent.pushMatrix();
        // platform rectangle
        parent.rectMode(PApplet.CENTER);
        parent.translate(this.position.x, this.position.y);
        parent.fill(0,0,200,200);
        this.parent.rect(0, 0, this.size.x, this.size.y);
        parent.popMatrix();
    }

}
