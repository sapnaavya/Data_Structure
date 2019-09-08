/**Reference: https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/ */
public class RatMazeProblem{
    boolean solveMaze(int[][] maze) {
        int n = maze.length;
        int sol[][] = new int[n][n];
        if(solveMazeUtil(maze, 0, 0, sol, n) == false) {
            System.out.println("solution does not exist");
            return false;
        }
        printSol(sol);
        return true;
    }

    public void printSol(int[][] sol) {
        int n = sol.length;
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    boolean isSafe(int[][] maze, int x, int y, int n) {
        if(x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1) {
            return true;
        }

        return false;
    }

    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol, int n) {
        // if x,y is goal return true
        if(x == n-1 && y == n-1) {
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(maze, x, y, n) == true) {

            // mark x, y as part of solution path 
            sol[x][y] = 1; 
            
            // move forward in x direction
            if(solveMazeUtil(maze, x+1, y, sol, n)) {
                return true;
            }

            // if moving forward in x direction does not give you a solution
            // then move down in y direction
            if(solveMazeUtil(maze, x, y+1, sol, n)) {
                return true;
            }

            // if none of the solution works, then 
            // backtrack: Unmark x, y as part of solution path
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    //main method
    public static void main(String args[]) {
        int maze[][] = { { 1, 0, 0, 0 }, 
						{ 1, 1, 0, 1 }, 
						{ 0, 1, 0, 0 }, 
                        { 1, 1, 1, 1 } }; 

        RatMazeProblem rat = new RatMazeProblem();
        rat.solveMaze(maze);
    }
}