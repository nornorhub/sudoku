package sudoku;

import java.util.*;
import java.io.*;
public class SudokuChecker
{
    public static void main(String[] args) throws Exception
    {
        int[][] sud;
        sud = getPuzzle("puzzle1.txt");
        for (int[] row: sud) {
            for (int i: row) {
                System.out.print(i);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(check(sud));
        sud = getPuzzle("puzzle2.txt");
        for (int[] row: sud) {
            for (int i: row) {
                System.out.print(i);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(check(sud));
        sud = getPuzzle("puzzle3.txt");
        System.out.println(check(sud));   
    }
    
    public static int[][] getPuzzle(String puzzle) throws IOException
    {
        int[][] arr = new int[9][9];
        Scanner fileScan = new Scanner (new FileReader(puzzle));
        for (int x = 0; x < 9; x++)
        {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner (line);
            lineScan.useDelimiter("\t");
            for (int y = 0; y < 9; y++)
            {
                String z = lineScan.next();
                arr[x][y] = Integer.parseInt(z);
            }
        }
        return arr;
    }
    
    public static boolean check(int[][] sudoku)
    {
        int[] checked = new int[9];
        for (int[] row: sudoku) {
            for (int i: row) {
                if (i >= 1 && i <= 9) {
                    for (int j = 0; j < checked.length; j++) {
                        if (i == checked[j]) {
                            return false;
                        }
                    }
                    for (int k = 0; k < checked.length; k++) {
                        if (checked[k] == 0) {
                            checked[k] = i;
                            break;
                        }
                    }
                }
                checked = new int[9];
            }
        }
        for (int i = 0; i < sudoku[0].length; i++) {
            checked = new int[9];
            for (int[] row: sudoku) {
                System.out.print(row[i]);
                System.out.println("");
                if (row[i] >= 1 && row[i] <= 9) {
                    for (int j = 0; j < checked.length; j++) {
                        System.out.print(checked[j]);
                        if (row[i] == checked[j]) {
                            return false;
                        }
                    }
                    System.out.println("");
                    for (int k = 0; k < checked.length; k++) {
                        if (checked[k] == 0) {
                            checked[k] = row[i];
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("");
        return true;
    }    
}
