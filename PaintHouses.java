class Solution {
    public int minCost(int[][] costs) {
        int houses= costs.length;
        int cost= costs[0].length;
        
        int[][] dp= new int[houses][cost];
        dp[0]= costs[0];
        
        
        for(int i=1; i<houses; i++){
            for (int j=0; j<cost; j++){
                int min= Integer.MAX_VALUE;
                for(int k=0; k< cost; k++){
                    if(k==j) continue;
                    min= Math.min(dp[i-1][k], min);
                }
                dp[i][j]= min +costs[i][j];
            }
        }
        int min= Integer.MAX_VALUE;
        for(int i=0; i< dp[0].length; i++){
           min= Math.min(min, dp[dp.length-1][i]);
        }
        return min;
    }
}

//time complexity- O(n) since k=3 constant
// space complexity- 0(n*3)