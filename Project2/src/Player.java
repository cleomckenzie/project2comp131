import java.awt.*;

public class Player extends GraphicsObject {
    double speed_x;
    double width;
    Color color;

    /*********************************
     [DEFAULT CONSTRUCTOR] Inherits XY
     from GraphicsObject, sets color
     ********************************/
    public Player(double x, double y, double width, Color color){
        super(x, y);
        this.width = width;
        this.color = color;
    }

    /*********************************
     [SETSPEED_X] sets player's speed
     ********************************/
    public void setSpeed_x(int speed_x){
        this.speed_x = speed_x;
    }

    /*********************************
     [GET_X] returns the player's x val
     ********************************/
    public int getX(){return cast(this.x);}
    public int getY(){return cast(this.y);}
    public int getWidth(){return cast (this.width);}
    public void setColor(Color color){
        this.color = color;
    }

    /*********************************
     [DRAW] Draws a width sized ship
     where X and Y are the position
     of the front facing vertex
     ********************************/
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(new int[] {cast(x - (width/2)), cast(x), cast(x + (width / 2)), cast(x)}, new int[] {cast(y + width), cast(y), cast(y + width), cast(y + (width * .75))}, 4);
    }

    /*********************************
     [UPDATE] updates the position of
     the spaceship unless the X and Y
     are out of bounds of the picture
     ********************************/
    public void update(int pic_width, int pic_height, int frame){
        if(this.x - (width/2) <= 0) {
            this.speed_x = 0;
            this.x += 1;
        }
        else if (this.x + (width/2) >= pic_width) {
            this.speed_x = 0;
            this.x -= 1;
        }
        else {
            this.x += this.speed_x;
        }
    }


}
