// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


public class PaintHouses {

    int findMinCostToPaintHouses(int [][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return -1;
        }
        int n = matrix.length;

        // We are starting with the second last row and using bottom up approach
        for(int i = n-2; i>=0; i--) {

            // Find the min cost when we choose RED colour for ith house, from the (i+1)th house we can choose either blue or green
            matrix[i][0] = matrix[i][0] + Math.min(matrix[i+1][1], matrix[i+1][2]);

            // Find the min cost when we choose BLUE colour for ith house, from the (i+1)th house we can choose either red or green
            matrix[i][1] = matrix[i][1] + Math.min(matrix[i+1][0], matrix[i+1][2]);

            // Find the min cost when we choose GREEN colour for ith house, from the (i+1)th house we can choose either blue or red
            matrix[i][2] = matrix[i][2] + Math.min(matrix[i+1][0], matrix[i+1][1]);
        }

        // Our ans will lie in the 0th row, minimum of the three cols will be the total cost
        return Math.min(matrix[0][0], Math.min(matrix[0][1], matrix[0][2]));
    }
}
