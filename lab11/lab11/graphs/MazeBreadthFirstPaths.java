package lab11.graphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /**
     * Conducts a breadth first search of the maze starting at the source.
     */
    private void bfs(int v) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        Queue<Integer> fringe = new Queue<>();
        fringe.enqueue(v);
        marked[v] = true;
        announce();
        while (!fringe.isEmpty()) {
            int temp = fringe.dequeue();
            for(int adj : maze.adj(temp)) {
                if (!marked[adj]) {
                    marked[adj] = true;
                    edgeTo[adj] = temp;
                    distTo[adj] = distTo[temp] + 1;
                    announce();
                    if (adj == t) {
                        return;
                    }
                    fringe.enqueue(adj);
                }
            }
        }
    }


    @Override
    public void solve() {
         bfs(s);
    }
}

