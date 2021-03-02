package hw4.puzzle;


import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.*;

public final class Solver {
    public static class Node implements Comparable<Node> {
        WorldState item;
        int moves;
        Node prev;

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
            return this.getItem().estimatedDistanceToGoal() + this.moves - o.getItem().estimatedDistanceToGoal() - o.moves;
        }
    }

    public MinPQ<Node> fringe;
    public Node destination;
    public Stack<WorldState> result;
    public Map<WorldState, Node> used;

    public Node[] getNeighbors(Iterable<WorldState> neighbors) {
        ArrayList<WorldState> mid = new ArrayList<>();
        Iterator<WorldState> iterator = neighbors.iterator();
        while (iterator.hasNext()) {
            mid.add(iterator.next());
        }
        int size = mid.size();
        Node[] res = new Node[size];
        for (int i = 0; i < size; i++) {
            res[i] = new Node(mid.get(i));
        }
        return res;
    }

    public Solver(WorldState initial) {
        fringe = new MinPQ<>();
        result = new Stack<>();
        used = new HashMap<>();
        fringe.insert(new Node(initial));
        used.put(initial, new Node(initial));
        while (!fringe.min().getItem().isGoal()) {
            Node temp = fringe.delMin();
            for (WorldState worldState : temp.getItem().neighbors()) {
                Node mid = new Node(worldState);
                if (used.containsKey(mid.getItem())) {
                    if (used.get(mid.getItem()).compareTo(temp) == 0) {
                        continue;
                    }
                }
                mid.prev = temp;
                mid.moves = mid.prev.moves +1;
                fringe.insert(mid);
                used.put(mid.getItem(), mid);
            }
        }
        destination = fringe.min();
        while(destination.prev != null) {
            result.push(destination.getItem());
            destination = destination.prev;
        }
        result.push(destination.getItem());
    }

    public int moves() {
        return result.size() - 1;
    }

    public Iterable<WorldState> solution() {
        return result;
    }
}
