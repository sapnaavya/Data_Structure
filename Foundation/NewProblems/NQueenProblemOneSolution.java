/**
 * This problem finds the solution to place n queens in a chess so that those queens do not kill themselves
 * Notes: This problem finds the first solution as soon as it finds the solution.. it will come out with boolean value as true
 * Remember, queens can kill each other when they are in same row, same column and diagonally
 * Time complexity - exponential due to backtracking and space complexity
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 * Refer this link for more details: https://www.youtube.com/watch?time_continue=2&v=xouin83ebxE
 * 
*/
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class NQueenProblemOneSolution {
    static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static Position[] nQueenPos(int n) {
        Position[] positions = new Position[n];
        boolean isSolution = nQueenSolutionUtil(n, 0, positions);
        if(isSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }
    
    public static boolean nQueenSolutionUtil(int n, int row, Position[] position) {

        //means all queens have placed themselves in a position that they are not killing each other
        if(n == row) {
            return true;
        }

        int col;
        for(col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check rows and columns are not under attch for previous queen
            for(int queen = 0 ; queen < row; queen++) {
                if(position[queen].col == col || position[queen].row - position[queen].col == row - col
                    || position[queen].row + position[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            
            }

            if(foundSafe) {
                position[row] = new Position(row, col);
                if(nQueenSolutionUtil(n, row + 1, position)) {
                    return true;
                }
            }
        }
        return false;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Position[] position =  nQueenPos(n);
        System.out.println("rows and columns:");
        for(int i = 0; i < position.length; i++) {
            int col = position[i].col;
            System.out.println(i + " " + col);
        }
        //Arrays.stream(pos).forEach(position -> System.out.println(position.row + " " + position.col));
        sc.close();
    }
}