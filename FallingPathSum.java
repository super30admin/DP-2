/**
 * Given a square array of integers A, we want the minimum sum of a falling path
 * through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row. The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * Space Complexity: O(n^2), n is the size of square's side
 * Time Complexity: O(n^2)
 * 
 * The Space Complexity can be reduced to linear O(n), as we just need to look
 * one row above the current one.
 * 
 * Leetcode Result: Runtime: 3 ms, faster than 88.71% of Java online submissions
 * for Minimum Falling Path Sum. Memory Usage: 37.4 MB, less than 100.00% of
 * Java online submissions for Minimum Falling Path Sum.
 */
public class FallingPathSum {
    /**
     * Idea is to keep track of the best path so far.
     * the best path so far for row 0 is the value itself.
     * the recurrence relation is:
     *      dp[i][j] = A[i][j] + min(A[i-1][j-1], A[i-1][j], A[i-1][j+1]);
     * of course we need to verfiy bounds before accessing j - 1 and j + 1.
     * 
     * @param A input square array
     * @return minimum sum of falling path
     */
    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];

        // row 0, best so far is the original value itself
        for (int j = 0; j < n; j++) {
            dp[0][j] = A[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = A[i][j]; // self
                int min = dp[i - 1][j]; // value directly above
                if (j > 0) { // top left
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j < n - 1) { // top right
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] += min;
            }
        }
        int minSum = dp[m - 1][0];
        for (int j = 1; j < n; j++) {
            minSum = Math.min(minSum, dp[m - 1][j]);
        }
        return minSum;
    }
}