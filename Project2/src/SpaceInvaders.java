// utility
import java.util.ArrayList;
import java.util.Random;

// graphics
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

// events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpaceInvaders extends JPanel implements ActionListener, KeyListener, Runnable {

    private final int canvasWidth;
    private final int canvasHeight;
    private final Color backgroundColor;

    private final int framesPerSecond = 25;
    private final int msPerFrame = 1000 / framesPerSecond;
    private Timer timer;
    private int frame = 0;

    /**** GAME VARIABLES ****/
    private double alienSpeed = 2.5;
    private boolean bulletDraw = false;
    private double alienWidth = 40;
    private double playerWidth = 20;
    private double bulletWidth = 4;
    private double bulletHeight = 8;
    private int playerSpeed = 5;
    private double bulletSpeed = 1;
    /************************/

    /***** GAME OBJECTS *****/
    Player player1;
    Alien alien1;
    Alien alien2;
    Alien alien3;
    Alien alien4;
    Alien alien5;
    Alien alien6;
    Alien alien7;
    Alien alien8;
    PlayerBullet bullet;
    /************************/


    /* Constructor for a Space Invaders game
     */
    public SpaceInvaders() {
        // fix the window size and background color
        this.canvasWidth = 600;
        this.canvasHeight = 400;
        this.backgroundColor = Color.WHITE;
        setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));

        // set the drawing timer
        this.timer = new Timer(msPerFrame, this);

        // FIXME initialize your game objects
        this.player1 = new Player(300, 350, playerWidth, Color.PINK);
        this.alien1 = new Alien(50, 50, alienSpeed, alienWidth, Color.lightGray);
        this.bullet = new PlayerBullet(player1, bulletWidth, bulletHeight, bulletSpeed, Color.red);

        /*this.alien2 = new Alien(100, 50, alienSpeedX,40, Color.lightGray);
        this.alien3 = new Alien(150, 50, alienSpeedX,40, Color.lightGray);
        this.alien4 = new Alien(200, 50, alienSpeedX,40, Color.lightGray);
        this.alien5 = new Alien(250, 50, alienSpeedX,40, Color.lightGray);
        this.alien6 = new Alien(250, 50, alienSpeedX,40, Color.lightGray);
        this.alien7 = new Alien(50, 10, alienSpeedX,40, Color.lightGray);*/
    }

    /* Start the game
     */
    @Override
    public void run() {
        // show this window
        display();

        // set a timer to redraw the screen regularly
        this.timer.start();
    }

    /* Create the window and display it
     */
    private void display() {
        JFrame jframe = new JFrame();
        jframe.addKeyListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(this);
        jframe.pack();
        jframe.setVisible(true);
    }

    /* Run all timer-based events
     *
     * @param e  An object describing the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // update the game objects
        update();
        // draw every object (this calls paintComponent)
        repaint(0, 0, this.canvasWidth, this.canvasHeight);
        // increment the frame counter
        this.frame++;
    }

    /* Paint/Draw the canvas.
     *
     * This function overrides the paint function in JPanel. This function is
     * automatically called when the panel is made visible.
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    protected void paintComponent(Graphics g) {
        // clear the canvas before painting
        clearCanvas(g);
        if (hasWonGame()) {
            paintWinScreen(g);
        } else if (hasLostGame()) {
            paintLoseScreen(g);
        } else {
            paintGameScreen(g);
        }
    }

    /* Clear the canvas
     *
     * @param g The Graphics representing the canvas
     */
    private void clearCanvas(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);
    }

    /* Respond to key release events
     *
     * A key release is when you let go of a key
     * 
     * @param e  An object describing what key was released
     */
    public void keyReleased(KeyEvent e) {
        // you can leave this function empty
    }

    /* Respond to key type events
     *
     * A key type is when you press then let go of a key
     * 
     * @param e  An object describing what key was typed
     */
    public void keyTyped(KeyEvent e) {
        // you can leave this function empty
    }

    /* Respond to key press events
     *
     * A key type is when you press then let go of a key
     * 
     * @param e  An object describing what key was typed
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(!(player1.getX() - 10 <= 0)) {
                player1.setSpeed_x(-playerSpeed);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(!(player1.getX() + 10 >= canvasWidth)) {
                player1.setSpeed_x(playerSpeed);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player1.setColor(Color.RED);
            bulletDraw = true;
        }
    }

    /* Update the game objects
     */
    private void update() {
        player1.update(canvasWidth, canvasHeight, this.frame);
        bullet.update(canvasWidth, canvasHeight, this.frame);
        alien1.update(canvasWidth, canvasHeight, this.frame);

        /*alien2.update(canvasWidth, canvasHeight, this.frame);
        alien3.update(canvasWidth, canvasHeight, this.frame);
        alien4.update(canvasWidth, canvasHeight, this.frame);
        alien5.update(canvasWidth, canvasHeight, this.frame);
        alien6.update(canvasWidth, canvasHeight, this.frame);
        alien7.update(canvasWidth, canvasHeight, this.frame);*/
    }

    /* Check if the player has lost the game
     * 
     * @returns  true if the player has lost, false otherwise
     */
    private boolean hasLostGame() {
        return false; // FIXME delete this when ready
    }

    /* Check if the player has won the game
     * 
     * @returns  true if the player has won, false otherwise
     */
    private boolean hasWonGame() {
        return false; // FIXME delete this when ready
    }

    /* Paint the screen during normal gameplay
     *
     * @param g The Graphics for the JPanel
     */
    private void paintGameScreen(Graphics g) {
        player1.draw(g);
        alien1.draw(g);
        /*alien2.draw(g);
        alien3.draw(g);
        alien4.draw(g);
        alien5.draw(g);
        alien6.draw(g);
        alien7.draw(g);*/
        if(bulletDraw == true) {
            bullet.draw(g);
        }
        // FIXME draw game objects here
    }

    /* Paint the screen when the player has won
     *
     * @param g The Graphics for the JPanel
     */
    private void paintWinScreen(Graphics g) {
        // FIXME draw the win screen here
    }

    /* Paint the screen when the player has lost
     *
     * @param g The Graphics for the JPanel
     */
    private void paintLoseScreen(Graphics g) {
        // FIXME draw the game over screen here
    }

    public static void main(String[] args) {
        SpaceInvaders invaders = new SpaceInvaders();
        EventQueue.invokeLater(invaders);
    }
}
