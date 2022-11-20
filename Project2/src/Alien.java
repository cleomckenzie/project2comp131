import java.awt.*;

public class Alien extends GraphicsObject {
    double speed_x;
    double width;
    Color color;

    /*********************************
     [DEFAULT CONSTRUCTOR] Inherits X
     & Y from GraphicsObject, sets the
     color, speed_x, speed_y and width
     ********************************/
    public Alien(double x, double y, double speed_x, double width, Color color){
        super(x, y);
        this.speed_x = speed_x;
        this.width = width;
        this.color = color;
    }


    /*********************************
     [DRAW] Draws a cute little UFO :3
     ********************************/
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(cast(x+(width/4)), cast(y-(width/8)), cast(width/2), cast(width/2));
        g.setColor(color.darker());
        g.fillOval(cast(x), cast(y), cast(width), cast(width/2));
        g.setColor(color.brighter());
        g.fillOval(cast(x+(width/4)), cast(y+(width/4)-1), cast(width/2), cast(width/4));
    }


    /*********************************
     [UPDATE] the alien goes left until
     it hits the side of the wall, then
     it moves forward and turns.
     ********************************/
    public void update(int pic_width, int pic_height, int frame){
        if(this.x  <= 0 || this.x + width >= pic_width) {
            this.speed_x = -speed_x;
            this.y += this.width;
        }
        this.x += this.speed_x;

    }




}
