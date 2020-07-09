package hw2;


import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private Percolation[] percolations;
    private int[] fractions;
    private int N;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        percolations = new Percolation[T];
        fractions = new int[T];
        this.N = N;
        for (int i = 0; i < T; i++) {
            percolations[i] = pf.make(N);
        }
        for (int i = 0; i < T; i++) {
            int count = 0;
            while (!percolations[i].percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                percolations[i].open(row, col);
                count++;
            }
            fractions[i] = count;
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
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
