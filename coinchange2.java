//space and time: O(n*m)
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] arr = new int[m + 1][n + 1];
        
       for (int i = 0; i <= m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - coins[i - 1]];
                }
            }
        }
        
        return arr[m][n];
    }
}
