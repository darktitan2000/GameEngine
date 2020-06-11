package Core.game_engine;
import processing.core.PApplet;
import java.util.ArrayList;
public class GameManager {
    public PApplet parent;
    private ArrayList<Sprite> game_objects;

    public GameManager(PApplet p){
        this.parent = p;
        startup();
    }

    public void add_game_object(Sprite g){
        //add a gameobject to list
        this.game_objects.add(g);
    }

    public void startup(){
        // initialize the list
        this.game_objects = new ArrayList<Sprite>();
    }

    public void update(){
        for(int i = 0; i < this.game_objects.size(); i++){
            Sprite gA = this.game_objects.get(i);
            for (int j = i + 1; j < this.game_objects.size(); j++){
                Sprite gB = this.game_objects.get(j);
                // use layers to seperate moving from static
                if(gA.getLayerType() == LayerTypes.MOVING && gB.getLayerType() != LayerTypes.BACKGROUND) {
                    gA.boxCollider2D.check_Collisions(gB.boxCollider2D);
                }
            }
            gA.update();
        }
    }


}
