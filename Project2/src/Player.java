import java.awt.*;

public class Player extends GraphicsObject {
    private double x;
    private double y;
    double speed_x = 0;
    Color color;

    /*********************************
     [DEFAULT CONSTRUCTOR] Converts X
     and Y to integers, sets the color
     ********************************/
    public Player(double x, double y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /*********************************
     [CAST] Used to quickly convert
     doubles into integers.
     ********************************/
    public int cast(double i) {
        int inti = (int) i;
        return inti;
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
    public void setColor(Color color){
        this.color = color;
    }

    /*********************************
     [DRAW] Draws a 20 x 20 spaceship
     where X and Y are the position
     of the front facing vertex
     ********************************/
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(new int[] {(cast(x)-10), cast(x), (cast(x)+10), cast(x)}, new int[] {cast(y)+20, cast(y), cast(y)+20, cast(y)+15}, 4);
    }

    /*********************************
     [UPDATE] updates the position of
     the spaceship unless the X and Y
     are out of bounds of the picture
     ********************************/
    public void update(int pic_width, int pic_height, int frame){
        if(this.x - 10 <= 0) {
            this.speed_x = 0;
            this.x += 1;
        }
        else if (this.x + 10 >= pic_width) {
            this.speed_x = 0;
            this.x -= 1;
        }
        else {
            this.x += this.speed_x;
        }
    }


}
