import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FloodFill {
    private static int[][] value; // Input value
    private static boolean[][] visited; // To keep track of visited cells

    public static int[][] readMatrixFromFile(String filePath) {
        int[][] matrix = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int rows = 0;
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                rows++;
                String[] elements = line.split("\\s+");

                if (cols <= elements.length) {
                    cols = elements.length;
                }
            }

            matrix = new int[rows][cols];

            reader.close();
            reader = new BufferedReader(new FileReader(filePath));

            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split("\\s+");
                for (int col = 0; col < elements.length; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
                row++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    private static int floodFill(int row, int col) {
        if (row < 0 || row >= value.length || col < 0 || col >= value[0].length || visited[row][col]
                || value[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        int regionSize = 1;

        // Recursively flood fill adjacent cells
        regionSize += floodFill(row - 1, col); // Up
        regionSize += floodFill(row + 1, col); // Down
        regionSize += floodFill(row, col - 1); // Left
        regionSize += floodFill(row, col + 1); // Right

        return regionSize;
    }

    public static int findLargestRegion(int[][] inputValue) {
        value = inputValue;
        visited = new boolean[value.length][value[0].length];
        int maxRegionSize = 0;

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (!visited[i][j] && value[i][j] != 0) {
                    int regionSize = floodFill(i, j);
                    maxRegionSize = Math.max(maxRegionSize, regionSize);
                }
            }
        }

        return maxRegionSize;
    }

    public static void main(String[] args) {
        int[][] matrix = readMatrixFromFile("C:/Users/admin/Documents/Zalo Received Files/binarymatrix.txt");
        int result = findLargestRegion(matrix);
        System.out.print(result);
    }
}