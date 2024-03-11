import java.util.Scanner;
import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int a = in.nextInt();
        System.out.println("Enter the number of columns");
        int b = in.nextInt();
        int[][] arr1 = new int[a][b];
        System.out.println("enter the elements: ");
        for (int r=0;r< arr1.length;r++){
            for (int c=0;c<arr1[r].length;c++){
                arr1[r][c]= in.nextInt();
            }
        }
        /*for (int[] a:arr1){
            System.out.println(Arrays.toString(a));
        }*/
        for (int r=0;r< arr1.length;r++){
            for (int c=0;c<arr1[r].length;c++){
                System.out.print(arr1[r][c]+" ");
            }
            System.out.println("");
        }
        for (int r=0;r<arr1.length;r++) {
            for (int c = 0; c < arr1[r].length; c++) {
                if (arr1[r][c] < arr1[r + 1][c+1]) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
            }
        }

    }

}
