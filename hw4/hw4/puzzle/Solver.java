package hw4.puzzle;


import edu.princeton.cs.algs4.MinPQ;

public class Solver {
    public static class Node implements Comparable<Node> {
        WorldState item;
        int moves;
        Node prev;

        public Node(WorldState state, int move, Node pre) {
            item = state;
            moves = move;
            prev = pre;
        }

        public Node(WorldState a) {
            item = a;
            moves = 0;
            prev = null;
        }

        public WorldState getItem() {
            return item;
        }

        @Override
        public int compareTo(Node o) {
            return this.moves - o.moves;
        }
    }

    public MinPQ<Node> res;

    public Solver(WorldState initial) {
        res = new MinPQ<>();
        res.insert(new Node(initial));
    }

    public int moves() {
        Node mid = res.delMin();
        int a =
    }
}
