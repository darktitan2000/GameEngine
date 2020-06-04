import Core.game.TestGame;
import processing.core.PApplet;

public class Main extends PApplet {
    private int WIDTH = 600, HEIGHT = 400;
    private TestGame testGame;
    public void settings(){
        size(WIDTH,HEIGHT);
    }
    public void setup(){
        background(0);
        testGame = new TestGame(this);
        testGame.Start();
    }

    public void draw(){
        background(0);
        testGame.Update();
    }

    public static void main(String args[]){
        //System.out.println("Hello World");
        PApplet.main("Main");
    }

    public void keyPressed(){
        testGame.keyPressed(key, keyCode);
    }
    public void keyReleased(){
        testGame.keyReleased(key, keyCode);
    }
}
