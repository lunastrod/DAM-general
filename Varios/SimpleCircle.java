import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class SimpleCircle extends JPanel {
    static int screenx=1000;
    static int screeny=1000;
    private ArrayList<ScreenObject> screenObjects = new ArrayList<>();
    HashSet<Boolean> keys = new HashSet<>();

    public SimpleCircle(JFrame f) {
        f.setFocusable(true);
        f.setSize(screenx, screeny);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(this);

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
        setupKeyBindings();
    }
    
    private void setupKeyBindings() {
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = this.getActionMap();

        // Bind W key press
        im.put(KeyStroke.getKeyStroke("W"), "wPressed");
        am.put("wPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("W pressed");
                System.out.println(keys.toString());
                // Your code here (e.g., move your ScreenObject)
            }
        });
    
        // Bind W key release (optional)
        im.put(KeyStroke.getKeyStroke("released W"), "wReleased");
        am.put("wReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("W released");
                // Your code here if you want to handle key release
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ScreenObject o : screenObjects) {
            o.draw(g);
        }
    }

    public static void main(String[] args) {
        SimpleCircle panel=new SimpleCircle(new JFrame());
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
        vx=0;
        vy=0;
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