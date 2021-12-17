//House Robber
//Space Complexity : O(m+n)
//Time Complexity : O(n)
public class Problem1 {

    public int minCost(int[][] costs) {
        if(costs.length==0){return 0;}
        //if mutating the matrix is allowded then add in same array
        int[][] dp = new int[costs.length][3];
        for(int i=costs.length-1;i==costs.length-1;i--){
            dp[i][0]=costs[i][0];
            dp[i][1]=costs[i][1];
            dp[i][2]=costs[i][2];
        }

        for(int i = costs.length-2 ; i>=0;i--){
            dp[i][0]=costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
             dp[i][1]=costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
             dp[i][2]=costs[i][2]+Math.min(dp[i+1][1],dp[i+1][0]);
        }
        
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }

}
