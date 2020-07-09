package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.Arrays;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF status;
    private int size;
    private int N;
    private int top;
    private int bottom;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Illegal N value");
        }
        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        status = new WeightedQuickUnionUF(N * N + 2);
        top = 0;
        bottom = N * N + 1;
        size = 0;
        this.N = N;
    }

    private int xyTo1D(int row, int col) {
        return row * N + col + 1;
    }

    private boolean validate(int row, int col) {
        return !(row >= N || row < 0 || col >= N || col < 0);
    }

    private ArrayList<Integer[]> gerNeighbors(int row, int col) {
        ArrayList<Integer[]> results = new ArrayList<>();
        int[][] neighbors = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] i : neighbors) {
            if (validate(row + i[0], col + i[1])) {
                results.add(new Integer[]{row + i[0], col + i[1]});
            }
        }
        return results;
    }

    public void open(int row, int col) {
        if (row >= N || row < 0 || col >= N || col < 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate for sites");
        }
        if (!isOpen(row, col)) {
            grid[row][col] = true;
            size++;
        }
        if (row == 0) {
            status.union(xyTo1D(row, col), top);
        }
        if (row == N - 1) {
            status.union(xyTo1D(row, col), bottom);
        }
        for (Integer[] neighbor : gerNeighbors(row, col)) {
            if (isOpen(neighbor[0], neighbor[1])) {
                status.union(xyTo1D(row, col), xyTo1D(neighbor[0], neighbor[1]));
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (!validate(row, col)) {
            throw new IndexOutOfBoundsException("Illegal coordinate for sites");
        }
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        if (!validate(row, col)) {
            throw new IndexOutOfBoundsException("Illegal coordinate for sites");
        }
        return status.connected(xyTo1D(row, col), top);
    }

    public int numberOfOpenSites() {
        return size;
    }

    public boolean percolates() {
        return status.connected(top, bottom);
    }

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats test = new PercolationStats(10, 10000, pf);
        System.out.println(test.mean());
        Percolation p = new Percolation(10);
        p.open(0, 5);
        p.open(1, 5);
        p.open(2, 5);
        p.open(3, 5);
        p.open(4, 5);
        p.open(5, 5);
        p.open(6, 5);
        p.open(7, 5);
        p.open(8, 5);
        p.open(9, 5);
        System.out.println(p.isOpen(5, 5));
        System.out.println(p.isFull(5, 5));
        System.out.println(p.percolates());
    }
}
