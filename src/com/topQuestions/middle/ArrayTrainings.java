package com.topQuestions.middle;

public class ArrayTrainings {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(countIslandsNumber(grid));
    }

    private static int countIslandsNumber(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandsNumber = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandsNumber++;
                    findIsland(grid, i, j);
                }
            }
        }

        return islandsNumber;
    }

    private static void findIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        findIsland(grid, i - 1, j);
        findIsland(grid, i + 1, j);
        findIsland(grid, i , j - 1);
        findIsland(grid, i , j + 1);
    }
}
