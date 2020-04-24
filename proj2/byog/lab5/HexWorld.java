package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private final static int WIDTH = 50;
    private final static int HEIGHT = 50;
    private static TERenderer TER;
    private static TETile[][] WORLD = new TETile[WIDTH][HEIGHT];

    private static void initializtion(){
        TER.initialize(WIDTH,HEIGHT);
        for(int x = 0; x< WIDTH; x++){
            for(int y=0; y < HEIGHT; y++){
                WORLD[x][y] = Tileset.NOTHING;
            }
        }
    }

    private static void addHexagon(int size,int x,int y){

    }

    public static void main(String[] args) {
        initializtion();

    }
}
