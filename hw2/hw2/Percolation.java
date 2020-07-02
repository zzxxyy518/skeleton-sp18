package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] mapStatus;


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
    }

    public boolean isOpen(int row, int col){
        if(row >= mapStatus.length || row < 0 || col >= mapStatus.length || col < 0){
            throw new IndexOutOfBoundsException("Illegal coordinate for sites");
        }
        return mapStatus[row][col];
    }


}
