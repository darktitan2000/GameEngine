package Core.game_engine;

public abstract class Component {
    public GameObject gameObject;
    public Component(GameObject gameObject){
        this.gameObject = gameObject;
        this.gameObject.addcomponentList(this);
        //add component
    }
    public abstract void update();
}
