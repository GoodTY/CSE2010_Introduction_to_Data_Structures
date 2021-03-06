package cse2010.homework4;
/*
 * CSE2010 Homework #4:
 * Problem 3: Maze
 *
 * Complete the code below.
 */

import java.util.Arrays;

public class Maze {
    private int numRows;
    private int numCols;

    private int[][] maze;
    private boolean[][] visited = null;

    private Location entry; // Entry Location
    private Location exit;  // Exit Location

    public Maze(int[][] maze, Location entry, Location exit) {

        this.maze = maze;
        numRows = maze.length;
        numCols = maze[0].length;
        visited = new boolean[numRows][numCols]; // initialized to false

        this.entry = entry;
        this.exit = exit;
    }

    public void printMaze() {

        System.out.println("Maze[" + numRows + "][" + numCols + "]");
        System.out.println("Entry index = (" + entry.row + ", " + entry.col + ")");
        System.out.println("Exit index = (" + exit.row + ", " + exit.col + ")" + "\n");

        for (int i = 0; i < numRows; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println();
    }

    public boolean findPath() {

        return moveTo(entry.row, entry.col);
    }

    private boolean moveTo(int row, int col) {
        visited[row][col] = true;
        if (row == exit.row && col == exit.col) {
            return true;
        } else {
            if (row >= 0 || row < numRows || col >= 0 || col < numCols) {
                if (row - 1 >= 0) {
                    boolean visitU = visited[row - 1][col];
                    int up = maze[row - 1][col];
                    if ((up == 0 && visitU == false) && row - 1 >= 0) {
                        if(moveTo(row-1, col )){return true;}
                    }
                }
                if (col + 1 < numCols) {
                    boolean visitR = visited[row][col + 1];
                    int right = maze[row][col + 1];
                    if ((right == 0 && visitR == false) && col + 1 < numCols) {
                        if(moveTo(row, col + 1)){return true;}
                    }
                }

                if (row + 1 < numRows) {
                    boolean visitD = visited[row + 1][col];
                    int down = maze[row + 1][col];
                    if ((down == 0 && visitD == false) && row + 1 < numCols) {
                        if(moveTo(row+1, col)){return true;}
                    }
                }
                if (col - 1 >= 0) {
                    boolean visitL = visited[row][col - 1];
                    int left = maze[row][col - 1];
                    if ((left == 0 && visitL == false) && col - 1 >= 0) {
                        if(moveTo(row, col - 1)){return true;}
                    }
                }

            }
        }return false;
    }
}