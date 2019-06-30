/**
 * This problem finds all possible solution to place n queens in a chess so that those queens do not kill themselves
 * Remember, queens can kill each other when they are in same row, same column and diagonally
 * Time complexity - exponential due to backtracking and space complexity
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 * Refer this link for more details: https://www.youtube.com/watch?time_continue=2&v=xouin83ebxE
 * 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NQueenProblemAllSolution {
    //Position class
    static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<String>> nQueenPos(int n) {
        Position[] positions = new Position[n];
        List<List<String>> result = new ArrayList<>();
        nQueenSolutionUtil(n, 0, positions, result);
        return result;
    }
    
    public static void nQueenSolutionUtil(int n, int row, Position[] position, List<List<String>> result) {

        //means all queens have placed themselves in a position that they are not killing each other
        if(n == row) {
            StringBuilder sb = new StringBuilder();
            List<String> oneResult = new ArrayList<>();
            for(Position p: position) {
                for(int i = 0; i < n; i++) {
                    if(p.col == i) {
                        sb.append("Q ");
                    } else {
                        sb.append(". ");
                    }
                }

                oneResult.add(sb.toString());
                //reset sb to 0
                sb.setLength(0);
            }
            result.add(oneResult);
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
                nQueenSolutionUtil(n, row + 1, position, result);
            }
        }
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> lists = nQueenPos(n);
        for(List<String> list:lists) {
            System.out.print("\n");
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        sc.close();
    }
}