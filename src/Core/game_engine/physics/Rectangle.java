package Core.game_engine.physics;

public class Rectangle {
    private float x, y, width, height;
    private Point topRight = new Point(1,1);
    private Point bottomLeft = new Point(-1, -1);

    public Rectangle(float x, float y, float w, float h){
        this.width = w;
        this.height = h;
        this.updateBounds(x, y);
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public void updateBounds(float _x, float _y){
        this.x = _x;
        this.y = _y;
        this.bottomLeft.setX(this.x - this.width / 2f);
        this.bottomLeft.setY(this.y + this.height / 2f);
        this.topRight.setX(this.x + this.width / 2f);
        this.topRight.setY(this.y - this.height / 2f);
    }
    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public boolean isOverlapping(Rectangle other){
        // check if top bottom not overlapping
        if(this.topRight.getY() > other.bottomLeft.getY() || this.bottomLeft.getY() < other.topRight.getY()){
            return false;
        }
        //check sides
        if(this.topRight.getX() < other.bottomLeft.getX() || this.bottomLeft.getX() > other.topRight.getX()){
            return false;
        }
        return true;
    }

    public boolean getIsTouchingAbove(Rectangle other){
        return other.topRight.getY() <= this.bottomLeft.getY() && other.topRight.getY() > this.topRight.getY();
    }
    public boolean getIsTouchingBelow(Rectangle other){
        return other.bottomLeft.getY() >= this.topRight.getY() && other.bottomLeft.getY() < this.bottomLeft.getY();
    }
    public boolean getIsTouchingRight(Rectangle other){
        return other.topRight.getX() >= this.bottomLeft.getX() && other.topRight.getX() < this.topRight.getX();
    }
    public boolean getIsTouchingLeft(Rectangle other){
        return other.bottomLeft.getX() <= this.topRight.getX() && other.bottomLeft.getX() > this.bottomLeft.getX();
    }
}
