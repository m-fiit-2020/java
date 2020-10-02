import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapLoader {

    public static void main(String[] args) {
//		int[] arr = new int[12];
//		int[] arr2 = new int[] {12,23,34,12,46,12};
//		//print(arr);
//		int[][] arr3 = new int[12][23];
//		print(arr3);
//		//arr2 = addOneElement(arr2,123);
//		addOneElement(arr2,123);
//		print(arr2);
        print(load("map.txt"));

    }

    public static int[][] load(String string) {
        try {
            Scanner sc =new  Scanner(new File("map.txt"));
            int lineNum = 0;
            while(sc.hasNextLine()) {
                //System.out.println(sc.nextLine());
                sc.nextLine();
                lineNum++;
            }
            int [][] map1 = new int[lineNum][];
            int count = 0;
            sc =new  Scanner(new File("map.txt"));
            while(sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] sArr = str.split(" ");
                int[] iArr = new int[sArr.length];
                for(int _i=0; _i<iArr.length; _i++) {
                    iArr[_i] = Integer.parseInt(sArr[_i]);
                }
                map1[count] = iArr;
                count++;
            }
            return map1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void addOneElement(int[] arr, int i) {
        int[] newarr = new int[arr.length+1];
        for(int _i=0; _i<arr.length; _i++) {
            newarr[_i]=arr[_i];
        }
        newarr[6] = i;
        newarr[0] =200000;
        arr = newarr;
        //arr[0]=10000000;
    }

    public static void print(int[][] arr3) {
        for(int _i=0; _i<arr3.length; _i++) {
            for(int _j=0; _j<arr3[_i].length; _j++) {
                System.out.print(arr3[_i][_j]+",");
            }
            System.out.println();
        }
    }

    private static void print(int[] arr) {
        for(int _i=0; _i<arr.length; _i++) {
            System.out.print(arr[_i]+",");
        }
    }
}