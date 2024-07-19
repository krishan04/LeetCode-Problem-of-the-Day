public class Lucky_Numbers_in_a_Matrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Initialize the row and column arrays
        int[] r = new int[row];
        int[] c = new int[col];

        // Set initial values for row and column arrays
        for(int i = 0; i < row; i++){
            r[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < col; i++){
            c[i] = Integer.MIN_VALUE;
        }

        // Find the minimum values in each row
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                r[i] = Math.min(r[i], matrix[i][j]);
            }
        }

        // Find the maximum values in each column
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                c[i] = Math.max(c[i], matrix[j][i]);
            }
        }

        // Find the lucky numbers
        List<Integer> luckyNumbers = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == r[i] && matrix[i][j] == c[j]){
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}
