import java.awt.*;

public class PlayerBullet extends GraphicsObject{
    Player player;
    Color color;
    double x;
    double y;
    double width;
    double height;
    double speed_y;
    boolean isShot = false;

    /*********************************
     [DEFAULT CONSTRUCTOR] Inherits X
     & Y from GraphicsObject.
     ********************************/
    public PlayerBullet(Player player, double width, double height, double speed_y, Color color) {
        this.player = player;
        this.speed_y = speed_y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.x = player.getX();
        this.y = player.getY();
    }


    /*********************************
     [DRAW] Draws a width by height
     bullet inside the player!
     ********************************/
    public void draw(Graphics g) {
        if (!isShot) {
            this.y = player.getY();
            this.x = player.getX();
        }
        isShot = true;
        g.setColor(color);
        g.fillRect(cast(x - (width/2)), cast(y - (height)), cast(width), cast(height));
    }


    /*********************************
     [UPDATE] updates the position of
     the bullet by the bulletspeed.
     ********************************/
    public void update(int pic_width, int pic_height, int frame){
        this.y -= this.speed_y;
    }


}
