//	Algorithm: Weighted Union
//	Author: Aryan Karamtoth
//	Date: 29th July 2025
//	Java Version: 24
//	License: BSD-3-Clause

import java.util.Scanner;

public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        UnionFind uf = new UnionFind(size);

        System.out.print("Enter number of union operations: ");
        int unions = sc.nextInt();
        System.out.println("Enter " + unions + " pairs to union:");
        for (int i = 0; i < unions; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            uf.union(a, b);
        }

        System.out.print("Enter number of connectivity checks: ");
        int checks = sc.nextInt();
        System.out.println("Enter " + checks + " pairs to check connectivity:");
        for (int i = 0; i < checks; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Connected(" + x + ", " + y + "): " + uf.connected(x, y));
        }

        sc.close();
    }
}
