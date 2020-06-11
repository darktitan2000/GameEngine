package Core.game_engine.data_management;

import processing.core.PApplet;
import processing.data.JSONObject;

public class DataManager {
    PApplet parent;
    private String load_game_file = "game.json";
    private String data_folder = "data_folder";
    public JSONObject game_data;
    public DataManager(PApplet p){
        this.parent = p;
    }
    public void load(){
        this.game_data = parent.loadJSONObject(data_folder+load_game_file);
    }
    public void save(){

    }
}
