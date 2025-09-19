import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.random.*;

public class SimpleCircle extends JPanel implements KeyListener {
    static int screenx=1000;
    static int screeny=1000;
    private ArrayList<ScreenObject> screenObjects = new ArrayList<>();

    public SimpleCircle() { 
        screenObjects.add(new ScreenObject());
        screenObjects.get(0).vx=1;
        screenObjects.add(new ScreenObject());


        new Timer(10, e -> {//draw timer
            repaint();//calls paintComponent
        }).start();

        new Timer(10,e->{//phyiscs timer
            for (ScreenObject o : screenObjects) {
                o.step();
            }
        }).start();
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                System.out.print("w");
                break;
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ScreenObject o : screenObjects) {
            o.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new SimpleCircle());
        f.setSize(screenx, screeny);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

class ScreenObject{
    int px,py;
    int vx,vy;
    int ax,ay;
    int dt;

    int sx,sy;//size
    Color color=Color.RED;
    public ScreenObject(){
        px=0;
        py=0;
        vx=2;
        vy=1;
        ax=0;
        ay=0;
        dt=1;
        sx=30;
        sy=30;
    }

    public void step(){
        vx=vx+ax*dt;
        vy=vy+ay*dt;
        px=px+vx*dt;
        py=py+vy*dt;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(px,py,sx,sy);
    }
}