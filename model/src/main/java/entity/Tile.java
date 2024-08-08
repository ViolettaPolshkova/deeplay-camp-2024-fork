package entity;

/**
 * Represents a tile on the game board.
 * <p>
 * This class holds the coordinates of a tile and provides methods to get these coordinates.
 * </p>
 */
public class Tile {
    private int x;
    private int y;

    /**
     * Initializes a new Tile with the specified coordinates.
     *
     * @param x The x-coordinate of the tile.
     * @param y The y-coordinate of the tile.
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the tile.
     *
     * @return The x-coordinate of the tile.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the tile.
     *
     * @return The y-coordinate of the tile.
     */
    public int getY() {
        return y;
    }
}