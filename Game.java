import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Game extends JFrame implements Runnable {
    Field field = new Field();
    UnitCont unitCont = new UnitCont();

    public static void main(String[] args) {
        Game frame = new Game();
        frame.setDefaultCloseOperation(2);
        frame.setBounds(10, 50, 900, 700);
        frame.setVisible(true);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int qx = (e.getX() - frame.field.left)/frame.field.xSize;
                int qy = (e.getY() - frame.field.top)/frame.field.ySize;
                frame.unitCont.mouseClicked(e);
                frame.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        new Thread(frame).start();

        frame.setLocationRelativeTo(null);
//        JButton comp = new JButton("Нажми");
//        frame.add(comp, BorderLayout.NORTH);
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
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
