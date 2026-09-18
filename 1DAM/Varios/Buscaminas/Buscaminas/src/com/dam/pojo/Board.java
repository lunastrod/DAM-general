package com.dam.pojo;

import java.util.Random;

public class Board {
    private int rows;
    private int cols;
    private int mines;
    private byte[][] grid;
    private static final byte MINE = 9;
    // bytes from 0 to 8 indicate number of adjacent mines
    private static final byte REVEALED = 10; // add to cell value to indicate it's revealed
    // for example, a cell with 2 adjacent mines that is revealed will have value 12
    private static final byte FLAGGED = 20; // add to cell value to indicate it's flagged

    public static final int BEGINNER=0;
    public static final int INTERMEDIATE=1;
    public static final int EXPERT=2;

    private static final int BEGINNER_MINES=5;
    private static final int INTERMEDIATE_MINES=40;
    private static final int EXPERT_MINES=99;
    private static final int BEGINNER_ROWS=8;
    private static final int BEGINNER_COLS=8;
    private static final int INTERMEDIATE_ROWS=16;
    private static final int INTERMEDIATE_COLS=16;
    private static final int EXPERT_ROWS=16;
    private static final int EXPERT_COLS=30;



    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.grid = new byte[rows][cols];
        initializeGrid();
    }

    public Board(int level) {
        switch(level) {
            case BEGINNER:
                this.rows = BEGINNER_ROWS;
                this.cols = BEGINNER_COLS;
                this.mines = BEGINNER_MINES;
                break;
            case INTERMEDIATE:
                this.rows = INTERMEDIATE_ROWS;
                this.cols = INTERMEDIATE_COLS;
                this.mines = INTERMEDIATE_MINES;
                break;
            case EXPERT:
                this.rows = EXPERT_ROWS;
                this.cols = EXPERT_COLS;
                this.mines = EXPERT_MINES;
                break;
            default:
                throw new IllegalArgumentException("Invalid level: " + level);
        }
        this.grid = new byte[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        int minesLeft=mines;
        Random rd = new Random();
        while (minesLeft > 0) {
            int r = rd.nextInt(rows);
            int c = rd.nextInt(cols);
            if (grid[r][c] != MINE) {
                grid[r][c] = MINE;
                minesLeft--;
                // update adjacent cells
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nr = r + i;
                        int nc = c + j;
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != MINE) {
                            grid[nr][nc]++;
                        }
                    }
                }
            }
        }
    }

    public boolean reveal(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            throw new IndexOutOfBoundsException("Invalid cell coordinates: (" + r + ", " + c + ")");
        }
        if (grid[r][c] == MINE) {
            return true; // hit a mine
        }
        grid[r][c] += REVEALED;
        // if the cell has 0 adjacent mines, reveal its neighbors
        if (grid[r][c] - REVEALED == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = r + i;
                    int nc = c + j;
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && (grid[nr][nc] < REVEALED)) {
                        reveal(nr, nc);// should never hit a mine here, ignore return value
                    }
                }
            }
        }
        return false;
    }

    public String toStringNoFog() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append(String.format("%2d ", grid[r][c]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //first row with column numbers
        sb.append("   ");
        for (int c = 0; c < cols; c++) {
            sb.append(String.format("%2d ", c));
        }
        sb.append("\n");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(c==0) {
                    sb.append(String.format("%2d ", r));
                }
                byte cell = grid[r][c];
                if (cell >= FLAGGED) {
                    sb.append(" F ");
                } else if (cell >= REVEALED) {
                    byte value = (byte)(cell - REVEALED);
                    sb.append(String.format("%2d ", value));
                } else {
                    sb.append(" . ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
