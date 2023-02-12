//PAINT HOUSE
//Time complexity : O(n)
//Space : O(n)
//Did it run on leet code : Yes
//Did I face any problems : No
// Code is below
class Solution {
    public int minCost(int[][] costs) {
    
    if(costs.length==0||costs==null){
        return 0;
    }

    int n = costs.length;
    int[][] dp = new int[n][3];

    for(int j =0; j<3; j++){
        dp[n-1][j] = costs[n-1][j];
    }

    for(int i= n-2; i>=0; i--){
        dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);

    }

    return Math.min(dp[0][0] , Math.min(dp[0][1] , dp[0][2]));
}
}

//COIN CHANGE 2
//Time complexity : O(m*n)
//Space : O(m*n)
//Did it run on leet code : Yes
//Did I face any problems : No
// Code is below
class Solution {
    public int change(int amount, int[] coins) {

        if(coins.length==0||coins==null){
            return 0;
        }

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i = 1 ; i< dp.length ; i++){
            for(int j = 0; j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    //case1+case0
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}






