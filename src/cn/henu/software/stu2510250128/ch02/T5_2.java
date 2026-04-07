package cn.henu.software.stu2510250128.ch02;

public class T5_2 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int rows = a.length;
        int cols = a[0].length;
        int[][] b = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[j][i] = a[i][j];
            }
        }
        System.out.println("--- 原二维数组 a ---");
        printMatrix(a);
        System.out.println("\n--- 转置后的二维数组 b ---");
        printMatrix(b);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}