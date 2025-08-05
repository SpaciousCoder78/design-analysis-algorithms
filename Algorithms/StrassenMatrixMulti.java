import java.util.Scanner;

public class StrassenMatMul {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[2][2];
        int[][] b = new int[2][2];
        int[][] c = new int[2][2];
        int p, q, r, s, t, u, v;

        System.out.println("Strassen's Matrix Multiplication");
        System.out.println("Enter the elements of 2x2 Matrix A:");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the elements of 2x2 Matrix B:");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                b[i][j] = sc.nextInt();
            }
        }

        p = (a[0][0] + a[1][1]) * (b[0][0] + b[1][1]);
        q = (a[1][0] + a[1][1]) * b[0][0];
        r = a[0][0] * (b[0][1] - b[1][1]);
        s = a[1][1] * (b[1][0] - b[0][0]);
        t = (a[0][0] + a[0][1]) * b[1][1];
        u = (a[1][0] - a[0][0]) * (b[0][0] + b[0][1]);
        v = (a[0][1] - a[1][1]) * (b[1][0] + b[1][1]);

        c[0][0] = p + s - t + v;
        c[0][1] = r + t;
        c[1][0] = q + s;
        c[1][1] = p + r - q + u;

        System.out.println("\nProduct of A and B is:");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
