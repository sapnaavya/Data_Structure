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

    //Position class to hold rows and columns of queens places
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

        //As we need to place queens in each of the column.. we will start from column
        int col;
        for(col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check rows and columns are not under attack for previous queen
            //if row -> 1 means till now 1 queen is placed .. if row is 2 that mean till now 2 queens are placed
            //first time, queen will be 0 and row will be 0 so we dont need to go in this for loop and we can place queen on 0,0 position
            
            for(int queen = 0 ; queen < row; queen++) {
                if(position[queen].col == col || position[queen].row - position[queen].col == row - col
                    || position[queen].row + position[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }

            //if foundsafe is true that mean this position is safe to place queen. Thus, assign those coordination to position
            if(foundSafe) {
                position[row] = new Position(row, col); //DO NOT FORGET TO SAVE THOSE COORDINATES
                if(nQueenSolutionUtil(n, row + 1, position)) {
                    return true;
                }
            }
        }

        //COULD NOT FIND POSITION TO PLACE QUEEN IN ALL COLUMNS, THUS RETURN FALSE TO CALL STACK
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
        sc.close();
    }
}