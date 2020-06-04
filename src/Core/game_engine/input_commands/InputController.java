package Core.game_engine.input_commands;

import processing.core.PApplet;

public class InputController {
    public InputHandler inputHandler;
    MoveLeftCommand moveLeftCommand;
    MoveRightCommand moveRightCommand;
    MoveUpCommand moveUpCommand;
    MoveDownCommand moveDownCommand;
    boolean left, right, up, down;
    public InputController(MoveAble _actor){
        moveLeftCommand = new MoveLeftCommand(_actor);
        moveRightCommand = new MoveRightCommand(_actor);
        moveUpCommand = new MoveUpCommand(_actor);
        moveDownCommand = new MoveDownCommand(_actor);
        inputHandler = new InputHandler(moveLeftCommand, moveRightCommand, moveUpCommand, moveDownCommand);
    }

    public void keyHandler(char key, int keyCode, boolean active){
        if(key == 'a' || keyCode == PApplet.LEFT){
            left = active;
        }else if(key == 'd' || keyCode == PApplet.RIGHT){
            right = active;
        }else if(key == 'w' || keyCode == PApplet.UP){
            up = active;
        }else if(key == 's' || keyCode == PApplet.DOWN){
            down = active;
        }else if(!active && keyCode != 0){
            left = false;
            right = false;
            up = false;
            down = false;
        }
    }
    public void checkInput(){
        // update this in draw
        if(left){
            inputHandler.moveLeft();
        }else if(right){
            inputHandler.moveRight();
        }
        if(up){
            inputHandler.moveUp();
        }else if(down){
            inputHandler.moveDown();
        }
    }
}
