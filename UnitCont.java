import java.awt.*;
import java.awt.event.MouseEvent;

public class UnitCont {
    Unit[] units = new Unit[5];
    Field field = new Field();

    public UnitCont() {
        units[0]= new Unit(1,2,3);
        units[1]= new Unit(2,5,7);
        units[2]= new Unit(3,8,3);
        units[3]= new Unit(4,6,2);
        Unit unit5 = new Unit(5,10,1);
        units[4]= unit5;
    }

    public void paint(Graphics g) {
        for(int _i=0; _i<units.length; _i++) {
            units[_i].paint(g);
        }
        for(Unit u: units) {
            u.paint(g);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int qx = (e.getX()-field.left)/field.xSize;
        int qy = (e.getY()-field.top)/field.ySize;
        if(e.getButton()==MouseEvent.BUTTON3) {

            for(int _i=0; _i<units.length; _i++) {
                if(units[_i].getX()==qx && units[_i].getY()==qy) {
                    units[_i].setSelectedState();
                }
            }
//            for(Unit u: units) {
//                u.setPosition(qx,qy);
//            }
        }else if(e.getButton()==MouseEvent.BUTTON1){
            for(Unit u: units) {
                u.setTarget(qx,qy);
            }
        }
    }
    public void refresh() {
        for(Unit u: units) {
            u.move();
        }
    }
}
