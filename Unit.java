import java.awt.*;

public class Unit {
    Field field = new Field();
    private int id;
    private int x = 2;
    private int y = 3;
    private int tx;
    private int ty;
    private boolean selected = false;

    public Unit(int i, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.tx = this.x;
        this.ty = this.y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(field.left+x*field.xSize, field.top+y*field.ySize, field.xSize, field.ySize);
        g.setColor(Color.yellow);
        if(!selected) {
            g.fillOval(field.left+x*field.xSize, field.top+y*field.ySize, field.xSize, field.ySize);
        }else {
            g.fillOval(field.left+x*field.xSize+3, field.top+y*field.ySize+3, field.xSize-6, field.ySize-6);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setPosition(int x, int y) {
        if (selected) {
            this.x = x;
            this.y = y;
        }
    }
    public void setSelectedState() {
        selected =! selected;
    }
    public void move() {
        if(x<tx) {
            x++;
        }else if(x>tx){
            x--;
        }
        if(y<ty) {
            y++;
        }else if(y>ty){
            y--;
        }
    }

    public void setTarget(int qx, int qy) {
        if(selected) {
            this.tx = qx;
            this.ty = qy;
        }
    }
}
