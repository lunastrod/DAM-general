import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class SimpleCircle extends JPanel {
    static int screenx=1000;
    static int screeny=1000;
    private ArrayList<Asteroid> asteroids = new ArrayList<>();
    private Rocket rocket = new Rocket(screenx, screeny);
    HashSet<Character> keys = new HashSet<>();

    public SimpleCircle(JFrame f) {
        f.setFocusable(true);
        f.setSize(screenx, screeny);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(this);

        
        for(int i=0; i<10; i++){
            asteroids.add(new Asteroid(screenx, screeny));
        }

        new Timer(10, e -> {//draw timer
            repaint();//calls paintComponent
        }).start();

        new Timer(10,e->{//phyiscs timer
            for (Asteroid o : asteroids) {
                o.step();
            }
            rocket.step(keys.contains('W'), keys.contains('A'), keys.contains('D'));
        }).start();
        setupKeyBind("W",'W');
        setupKeyBind("D",'D');
        setupKeyBind("A",'A');

    }

    private void setupKeyBind(String name, char c){
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = this.getActionMap();

        im.put(KeyStroke.getKeyStroke("pressed "+name), name+"pressed");
        am.put(name+"pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keys.add(c);
            }
        });

        im.put(KeyStroke.getKeyStroke("released "+name), name+"released");
        am.put(name+"released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keys.remove(c);
            }
        });
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint background black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Asteroid o : asteroids) {
            o.draw(g);
        }
        rocket.draw(g);
        //System.out.println(keys);
    }

    public static void main(String[] args) {
        SimpleCircle panel=new SimpleCircle(new JFrame());
    }
}

class ScreenObject{
    double px,py;
    double zoom;
    protected int pixelx,pixely;
    int screenx,screeny;
    double vx,vy;
    double ax,ay;
    double angle;
    double w;
    double dt;

    int sx,sy;//size
    Color color=Color.RED;
    public ScreenObject(int screensizex,int screensizey){
        px=0;
        py=0;
        pixelx=0;
        pixely=0;
        screenx=screensizex;
        screeny=screensizey;
        zoom=1;
        vx=0;
        vy=0;
        ax=0;
        ay=0;
        dt=1;
        sx=30;
        sy=30;
    }

    public void step(){
        //update angle
        angle=angle+w*dt;

        //update position
        vx=vx+ax*dt;
        vy=vy+ay*dt;
        px=px+vx*dt;
        py=py+vy*dt;

        //calculate pixel
        pixelx=(int) (px*zoom);
        pixely=(int) (py*zoom);

        //reset a
        ax=0;
        ay=0;

        checkBorders();
    }

    public void checkBorders(){
        if(px<0){
            px=screenx/zoom;
        }
        if(py<0){
            py=screeny/zoom;
        }
        if(px>screenx/zoom){
            px=0;
        }
        if(py>screeny/zoom){
            py=0;
        }
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(pixelx,pixely,sx,sy);
    }
}

class Asteroid extends ScreenObject{
    public Asteroid(int screensizex,int screensizey){
        super(screensizex,screensizey);
        color=Color.getHSBColor(0.10f, 0.3f, 0.75f);

        px=Math.random()*screenx/zoom;
        py=Math.random()*screeny/zoom;
        vx=Math.random()*2-1;
        vy=Math.random()*2-1;
        
    }
}

class Missile extends ScreenObject{
    Missile(int screensizex,int screensizey,double startvx,double startvy){
        super(screensizex, screensizey);

    }
}

class Rocket extends ScreenObject{
    Rocket(int screensizex,int screensizey){
        super(screensizex,screensizey);
        color=Color.getHSBColor(0.10f, 1.0f, 0.75f);
    }
    public void step(boolean forward, boolean left, boolean right){
        if(forward){
            double strength=0.1;
            ax=Math.cos(Math.toRadians(angle))*strength;
            ay=Math.sin(Math.toRadians(angle))*strength;
        }
        if(left){
            double strength=0.2;
            w-=strength*dt;
        }
        if(right){
            double strength=0.2;
            w+=strength*dt;
        }
        super.step();
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillArc(pixelx, pixely, sx, sy, 180-((int)angle)-25, 50);
    }
}