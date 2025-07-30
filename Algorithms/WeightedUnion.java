//	Algorithm: Weighted Union
//	Written by: Aryan Karamtoth
//	Date: 29th July 2025
//	Java Version: 24
//	License: BSD-3-Clause

import java.util.Scanner;

public class WeightedUnion{
	
	private int[] parent;
	private int[] rank;
	private int count;
	private int[] size;
	
	public WeightedUnion(int n){
		count = n;
		parent = new int[n];
		size = new int[n];
		for(int i=0;i<n;i++){
			parent[i]=i;
			size[i]=1;
		}
	}
	
	public int count(){
		return count;
	}
	
	public int find(int p){
		validate(p);
		while(p!=parent[p])
			p=parent[p];
		return p;
	}
	
	public boolean connected(int p,int q){
		return find(p) == find (q);
	}
	
	private void validate(int p){
		int n = parent.length;
		if (p<0||p>=n){
			throw new IllegalArgumentException("index "+p+" is not between 0 and " + (n-1));
		}
	}
	
	public void union(int p,int q){
		int rootP=find(p);
		int rootQ=find(q);
		if(rootP==rootQ) return;
		
		if (size[rootP]<size[rootQ]){
			parent[rootP]=rootQ;
			size[rootQ]+=size[rootP];
		}
		else{
			parent[rootQ]=rootP;
			size[rootP]+=size[rootQ];
		}
		count--;
	}
	
	
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter n:");
    int n = sc.nextInt();
    WeightedUnion uf = new WeightedUnion(n);

    System.out.println("Enter pairs of p and q (Ctrl+D to stop):");

    while (true) {
        System.out.print("Enter p: ");
        if (!sc.hasNextInt()) break;
        int p = sc.nextInt();

        System.out.print("Enter q: ");
        if (!sc.hasNextInt()) break;
        int q = sc.nextInt();

        if (p < 0 || p >= n || q < 0 || q >= n) {
            System.out.println("Invalid input. Enter values between 0 and " + (n - 1));
            continue;
        }

        if (uf.find(p) == uf.find(q)) continue;

        uf.union(p, q);
        System.out.println("Connected: " + p + " - " + q);
    }

    System.out.println(uf.count() + " components");
    sc.close();




	}
}
