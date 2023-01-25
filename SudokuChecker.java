package sudoku;

import java.util.*;
import java.io.*;
public class SudokuChecker
{
    public static void main(String[] args) throws Exception
    {
        int[][] sud;
        sud = getPuzzle("puzzle1.txt");
        System.out.println(check(sud));
        sud = getPuzzle("puzzle2.txt");
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
                if (row[i] >= 1 && row[i] <= 9) {
                    for (int j = 0; j < checked.length; j++) {
                        if (row[i] == checked[j]) {
                            return false;
                        }
                    }
                    for (int k = 0; k < checked.length; k++) {
                        if (checked[k] == 0) {
                            checked[k] = row[i];
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                checked = new int[9];
                for (int j = 0; j < 3; j++) {
                    for (int k = 3*i; k < (3*i)+3; k++) {
                        if (sudoku[j][k] >= 1 && sudoku[j][k] <= 9) {
                            for (int a = 0; a < checked.length; a++) {
                                if (sudoku[j][k] == checked[a]) {
                                    return false;
                                }
                            }
                            for (int b = 0; b < checked.length; b++) {
                                if (checked[b] == 0) {
                                    checked[b] = sudoku[j][k];
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (i < 6) {
                checked = new int[9];
                for (int j = 3; j < 6; j++) {
                    for (int k = 3*(i-3); k < (3*(i-3))+3; k++) {
                        if (sudoku[j][k] >= 1 && sudoku[j][k] <= 9) {
                            for (int a = 0; a < checked.length; a++) {
                                if (sudoku[j][k] == checked[a]) {
                                    return false;
                                }
                            }
                            for (int b = 0; b < checked.length; b++) {
                                if (checked[b] == 0) {
                                    checked[b] = sudoku[j][k];
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                checked = new int[9];
                for (int j = 6; j < 9; j++) {
                    for (int k = (3*(i-6)); k < (3*(i-6))+3; k++) {
                        if (sudoku[j][k] >= 1 && sudoku[j][k] <= 9) {
                            for (int a = 0; a < checked.length; a++) {
                                if (sudoku[j][k] == checked[a]) {
                                    return false;
                                }
                            }
                            for (int b = 0; b < checked.length; b++) {
                                if (checked[b] == 0) {
                                    checked[b] = sudoku[j][k];
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
        
