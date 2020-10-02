import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Field {
    int count;//=0
    final static int xNum = 14;
    final static int yNum = 14;
    final int xSize = 50;
    final int ySize = 50;
    final int left = 100;
    final int top = 100;
    final static int[][] map0;
    final static int[][] map1;

    static {
        map1 = MapLoader.load("map.txt");
        map0 = new int[yNum][xNum];
        for(int _i=0; _i<map0.length;_i++) {
            for(int _j=0; _j<map0[_i].length; _j++) {
                map0[_i][_j]=-1;
            }
        }
        for(int _i=0; _i<map1.length;_i++) {
            for(int _j=0; _j<map1[_i].length; _j++) {
                if(map1[_i][_j]==1) {
                    map0[_i][_j]=-4;
                }
            }
        }
    }


    public void paint(Graphics g) {
        g.setColor(Color.red);
        for(int _i=0; _i<yNum+1; _i++) {
            g.drawLine(left+_i*xSize, top, left+_i*xSize, top+ySize*xNum);
        }
        g.setColor(Color.blue);
        for(int _i=0; _i<xNum+1; _i++) {
            g.drawLine(left, top+_i*ySize, left+xSize*yNum, top+_i*ySize);
        }
        for(int _i=0; _i<map1.length; _i++) {
            for(int _j=0; _j<map1[_i].length; _j++) {
                if(map1[_j][_i]==1)
                    g.fillRect(left+_i*xSize, top+_j*ySize, xSize, ySize);
            }
        }


        g.setFont(new Font("Arial",1,20));
        count++;//count=count+1
        g.drawString(""+count, 300, 300);
        //g.drawString(String.valueOf(count), 300, 300);
    }

}