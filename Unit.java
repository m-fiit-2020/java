import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Unit {
    Field field = new Field();
    private int id;
    private int x;
    private int y;
    private int tx;
    private int ty;
    private boolean selected = false;
    ArrayList<Point> path = new ArrayList<Point>();

    public Unit(int id, int x, int y) {
        this.id = id; this.x = x; this.y = y;
        this.tx = this.x; this.ty = y;
    }

    public void paint(Graphics g) {
        int px = field.left+x*field.xSize;
        int py = field.top+y*field.ySize;
        g.setColor(Color.red);
        g.fillOval(px, py, field.xSize, field.ySize);
        g.setColor(Color.yellow);
        if(!selected) {
            g.fillOval(px, py, field.xSize, field.ySize);
        }else {
            g.fillOval(px+3, py+3, field.xSize-6, field.ySize-6);
        }
        g.setColor(Color.blue);
        g.drawString(""+id, px+field.xSize*1/3, py+field.xSize*2/3);
    }

    public void setSelectedState (int qx, int qy) {
        if(x==qx && y==qy)
            selected =! selected;
    }
    public void move() {
        if(path.size()>1) {
            Point p = path.get(1);
            path.remove(1);
            x = p.x; y= p.y;
        }
    }
    public void moveOld() {
        if(x<tx) {
            x++;
        }else if(x>tx) {
            x--;
        }
        if(y<ty) {
            y++;
        }else if(y>ty) {
            y--;
        }
    }

    public void setTarget(int tx, int ty) {
        if(selected) {
            //WaveAlg alg = new WaveAlg();
            path = new WaveAlg().findPath(Field.map0, x, y, tx, ty);
        }
    }
}