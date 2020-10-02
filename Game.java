import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
public class Game extends JFrame implements Runnable{
    Field field = new Field();
    UnitCont unitCont = new UnitCont();

    public static void main(String[] args) {
        Game frame = new Game();
        frame.setDefaultCloseOperation(3);
        frame.setBounds(10, 50, 1200, 700);
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.unitCont.mouseClicked(e);
                frame.repaint();
            }
        });
        new Thread(frame).start();
    }
    @Override
    public void paint(Graphics g) {
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();
        g = bs.getDrawGraphics();

        super.paint(g);
        field.paint(g);
        unitCont.paint(g);

        bs.show();

    }
    @Override
    public void run() {
        while(true) {
            unitCont.refresh();
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}