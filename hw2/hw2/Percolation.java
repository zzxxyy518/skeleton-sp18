package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] mapStatus;
    private WeightedQuickUnionUF mapSets;
    private int openSize;
    private int N;

    public Percolation(int N){
        if(N <= 0) {
            throw new IllegalArgumentException("Illegal N value");
        }
        mapStatus = new boolean[N][N];
        for(int i = 0;i < N;i ++){
            for(int j = 0;j < N;j ++){
                mapStatus[i][j] = false;
            }
        }
        openSize = 0;
        this.N = N;
    }

    public boolean isOpen(int row, int col){
        if(row >= N || row < 0 || col >= N || col < 0){
            throw new IndexOutOfBoundsException("Illegal coordinate for sites");
        }
        return mapStatus[row][col];
    }

    public boolean isFull(int row, int col){
        int setId = row * N + col;
        return mapSets.find(setId) < N;
    }

    public int numberOfOpenSites(){
        return openSize;
    }

    public boolean percolates(){
        for(int i = 0; i < N; i ++){
            if(isFull(N - 1, i)){
                return true;
            }
        }
        return false;
    }
}
