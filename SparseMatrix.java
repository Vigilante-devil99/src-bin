 
/*
 * Sparse Matrix implementation using Triplet (3-column) representation.
 * Supports: convert from normal matrix -> sparse, display, transpose, addition.
 */
public class SparseMatrix {
 
    // ---------- 1. Convert a normal 2D matrix into sparse (triplet) form ----------
    static int[][] toSparse(int[][] matrix, int rows, int cols) {
        int nonZeroCount = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
        
                if (matrix[i][j] != 0)
                    nonZeroCount++;
 
        // +1 row for the header: (rows, cols, nonZeroCount)
        int[][] sparse = new int[nonZeroCount + 1][3];
        sparse[0][0] = rows;
        sparse[0][1] = cols;
        sparse[0][2] = nonZeroCount;
 
        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    sparse[k][0] = i;
                    sparse[k][1] = j;
                    sparse[k][2] = matrix[i][j];
                    k++;
                }
            }
        }
        return sparse;
    }
 
    // ---------- 2. Display sparse matrix (triplet form) ----------
    static void displaySparse(int[][] sparse) {
        System.out.println("Row\tCol\tValue");
        for (int[] triple : sparse) {
            System.out.println(triple[0] + "\t" + triple[1] + "\t" + triple[2]);
        }
    }
 
    // ---------- 3. Reconstruct the original matrix from sparse form ----------
    static void displayAsMatrix(int[][] sparse) {
        int rows = sparse[0][0];
        int cols = sparse[0][1];
        int[][] matrix = new int[rows][cols];
 
        for (int k = 1; k < sparse.length; k++) {
            int r = sparse[k][0];
            int c = sparse[k][1];
            int v = sparse[k][2];
            matrix[r][c] = v;
        }
 
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
 
    // ---------- 4. Transpose of a sparse matrix ----------
    // Fast transpose: builds result directly in row-major order of the transpose,
    // avoiding the O(cols * nonZero) cost of the naive approach.
    static int[][] transpose(int[][] sparse) {
        int rows = sparse[0][0];
        int cols = sparse[0][1];
        int nonZero = sparse[0][2];
 
        int[][] result = new int[nonZero + 1][3];
        result[0][0] = cols;
        result[0][1] = rows;
        result[0][2] = nonZero;
 
        if (nonZero == 0) return result;
 
        int[] colCount = new int[cols];
        int[] colIndex = new int[cols];
 
        for (int i = 1; i <= nonZero; i++)
            colCount[sparse[i][1]]++;
 
        colIndex[0] = 1;
        for (int i = 1; i < cols; i++)
            colIndex[i] = colIndex[i - 1] + colCount[i - 1];
 
        for (int i = 1; i <= nonZero; i++) {
            int col = sparse[i][1];
            int pos = colIndex[col];
            result[pos][0] = sparse[i][1];   // new row = old col
            result[pos][1] = sparse[i][0];   // new col = old row
            result[pos][2] = sparse[i][2];
            colIndex[col]++;
        }
        return result;
    }
 
    // ---------- 5. Addition of two sparse matrices ----------
    static int[][] add(int[][] a, int[][] b) {
        if (a[0][0] != b[0][0] || a[0][1] != b[0][1]) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
 
        int rows = a[0][0], cols = a[0][1];
        int[][] full = new int[rows][cols]; // temp dense buffer to combine values
 
        for (int i = 1; i < a.length; i++)
            full[a[i][0]][a[i][1]] += a[i][2];
        for (int i = 1; i < b.length; i++)
            full[b[i][0]][b[i][1]] += b[i][2];
 
        return toSparse(full, rows, cols);
    }
 
    // ---------- Demo ----------
    public static void main(String[] args) {
        int[][] matrixA = {
            {0, 0, 3, 0},
            {0, 0, 0, 0},
            {0, 4, 0, 0},
            {5, 0, 0, 6}
        };
 
        int[][] matrixB = {
            {0, 1, 0, 0},
            {0, 0, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 7, 0}
        };
 
        System.out.println("Original Matrix A:");
        for (int[] row : matrixA) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
 
        int[][] sparseA = toSparse(matrixA, 4, 4);
        System.out.println("\nSparse representation of A:");
        displaySparse(sparseA);
 
        System.out.println("\nReconstructed matrix from sparse A:");
        displayAsMatrix(sparseA);
 
        System.out.println("\nTranspose of A (sparse form):");
        int[][] transposedA = transpose(sparseA);
        displaySparse(transposedA);
 
        int[][] sparseB = toSparse(matrixB, 4, 4);
        System.out.println("\nSum of A and B (sparse form):");
        int[][] sum = add(sparseA, sparseB);
        displaySparse(sum);
 
        System.out.println("\nSum reconstructed as matrix:");
        displayAsMatrix(sum);
    }
}
