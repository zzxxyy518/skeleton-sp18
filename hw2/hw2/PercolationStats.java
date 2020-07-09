package hw2;


import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private Percolation[] percolations;
    private int[] fractions;
    private int N;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Wrong input N and T");
        }
        percolations = new Percolation[T];
        fractions = new int[T];
        this.N = N;
        for (int i = 0; i < T; i++) {
            percolations[i] = pf.make(N);
        }
        for (int i = 0; i < T; i++) {
            while (!percolations[i].percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                percolations[i].open(row, col);
            }
            fractions[i] = percolations[i].numberOfOpenSites();
        }
    }

    public double mean() {
        return StdStats.mean(fractions) / (N * N);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLow() {
        return this.mean() - (1.96 * this.stddev()) / Math.sqrt(percolations.length);
    }

    public double confidenceHigh() {
        return this.mean() + (1.96 * this.stddev()) / Math.sqrt(percolations.length);
    }
}
