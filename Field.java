import java.awt.*;

public class Field {
    int count;
    final int xNum = 10;
    final int yNum = 14;
    final int xSize= 50;
    final int ySize= 50;
    final int left = 100;
    final int top = 100;

    public void paint(Graphics g) {
        g.setColor(Color.red);
        for(int _i=0; _i<yNum+1; _i++) {
            g.drawLine(left+_i*xSize, top, left+_i*xSize, top+ySize*xNum);
        }
        g.setColor(Color.blue);
        for(int _i=0; _i<yNum+1; _i++) {
            g.drawLine(left, top+_i*ySize, left+xSize*yNum, top+_i*ySize);
        }
        g.setFont(new Font("Arial",1,20));
        count++;
        g.drawString(""+count, 300, 300);
    }
}
