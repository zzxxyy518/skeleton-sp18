package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;

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
        for (int i = -1; i < 2; i += 2) {
            for (int j = -1; j < 2; j += 2) {
                if (validate(row + i, col + j)) {
                    results.add(new Integer[]{row + i, col + j});
                }
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
}
