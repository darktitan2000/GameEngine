package Core.game;
import Core.game_engine.GameManager;
import Core.game_engine.GameObject;
import Core.game_engine.data_management.DataManager;
import Core.game_engine.input_commands.InputController;
import processing.core.PApplet;

public class TestGame {
    public PApplet parent;
    private GameManager game_manager;
    Platform gamePlatform;
    Player player;
    InputController playerInput;
    DataManager dataManager;
    public TestGame(PApplet p){
        this.parent = p;
    }
    public void Start(){
        game_manager = new GameManager(this.parent);

        // add player
        player = new Player(this.parent, 300, 200, 20, 20);
        playerInput = new InputController(player);
        game_manager.add_game_object(player);

        gamePlatform = new Platform(this.parent, 300, 350, 200, 80);
        game_manager.add_game_object(gamePlatform);

        CollectableThing collectableThing = new CollectableThing(parent,450,300,20,20);
        game_manager.add_game_object(collectableThing);
    }

    public void Update(){
        playerInput.checkInput();
        game_manager.update();
    }

    public void keyReleased(char key, int keyCode){
        playerInput.keyHandler(key, keyCode, false);
    }

    public void keyPressed(char key, int keyCode){
        playerInput.keyHandler(key, keyCode, true);
    }

}
