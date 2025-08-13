// Algorithm: Defective Chessboard
//	Written by: Aryan Karamtoth
//	Date: 13 August 2025
//	Java Version: 24
//	License: BSD-3-Clause

import java.util.*;

class Defect {
    public static int tiles = 1;
    public static int board[][] = new int[10][10];

    public static void TileBoard(int trow, int tcol, int drow, int dcol, int size) {
        if (size == 1)
            return;

        int tileno = tiles++;
        int qsize = size / 2;

        // Top-left quadrant
        if (drow < trow + qsize && dcol < tcol + qsize) {
            TileBoard(trow, tcol, drow, dcol, qsize);
        } else {
            board[trow + qsize - 1][tcol + qsize - 1] = tileno;
            TileBoard(trow, tcol, trow + qsize - 1, tcol + qsize - 1, qsize);
        }

        // Top-right quadrant
        if (drow < trow + qsize && dcol >= tcol + qsize) {
            TileBoard(trow, tcol + qsize, drow, dcol, qsize);
        } else {
            board[trow + qsize - 1][tcol + qsize] = tileno;
            TileBoard(trow, tcol + qsize, trow + qsize - 1, tcol + qsize, qsize);
        }

        // Bottom-left quadrant
        if (drow >= trow + qsize && dcol < tcol + qsize) {
            TileBoard(trow + qsize, tcol, drow, dcol, qsize);
        } else {
            board[trow + qsize][tcol + qsize - 1] = tileno;
            TileBoard(trow + qsize, tcol, trow + qsize, tcol + qsize - 1, qsize);
        }

        // Bottom-right quadrant
        if (drow >= trow + qsize && dcol >= tcol + qsize) {
            TileBoard(trow + qsize, tcol + qsize, drow, dcol, qsize);
        } else {
            board[trow + qsize][tcol + qsize] = tileno;
            TileBoard(trow + qsize, tcol + qsize, trow + qsize, tcol + qsize, qsize);
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int i, j, drow, dcol, n;

        System.out.print("Enter the value of n (size of the chessboard, must be power of 2): ");
        n = inp.nextInt();

        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                board[i][j] = 0;

        System.out.println("Enter the defective row and column (0-indexed): ");
        drow = inp.nextInt();
        dcol = inp.nextInt();

        TileBoard(0, 0, drow, dcol, n);

        System.out.println("\nTiled Board:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }
}
