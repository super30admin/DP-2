// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes


class coinChange2 {
        public int change(int amount, int[] coins) {
         if(coins==null||coins.length==0){
            return 0;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
    coinChange2 rs = new coinChange2();
    int[]arr = {1,2,5} ;
    int[] arr2 = {2};
    int[] arr3= {10};
    System.out.println(rs.change(5,arr));  // ans = 4
    System.out.println(rs.change(3,arr2));  // ans = 0
    System.out.println(rs.change(10,arr3));  // ans = 1
}

}