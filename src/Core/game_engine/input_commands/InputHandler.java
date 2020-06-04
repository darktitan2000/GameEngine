package Core.game_engine.input_commands;

public class InputHandler {
    private Command leftCommand, rightCommand, upCommand, downCommand;
    public InputHandler(Command left, Command right, Command up, Command down){
        leftCommand = left;
        rightCommand = right;
        upCommand = up;
        downCommand = down;
    }
    public void moveLeft(){
        leftCommand.execute();
    }
    public void moveRight(){
        rightCommand.execute();
    }
    public void moveUp(){ upCommand.execute(); }
    public void moveDown(){
        downCommand.execute();
    }
}
