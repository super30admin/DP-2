public class CoinChangeII {
    // Time Complexity : O(mn) m is length of coins array, n is amount
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


    public int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;
        int [][] arr = new int[m+1][n+1];
        arr[0][0] = 1;
        for(int i=1;i<=n;i++) {
            arr[0][i] = 0;
        }
        for(int i=1;i<=m; i++) {
            for(int j=0;j<=n;j++) {
                if(j < coins[i-1]) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-coins[i-1]];
                }
            }
        }
        return arr[m][n];
    }
}
