// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// if you choose one paint then calculate min for other paints for neighbour.
// calculate min for all the paints.


//Top down
public int minCost(int[][] costs) {
    if(costs.length==0) return 0;
    return  helper(costs,-1,costs.length-1,new int[costs.length][3]);
}

private int helper(int[][] costs, int except, int i,int memo[][]){
    if(i == -1) return 0;
    if(except >=0 && memo[i][except] >0)  return memo[i][except];
    int result = Math.min(Math.min(except != 0 ? helper(costs,0,i-1,memo) + costs[i][0] :Integer.MAX_VALUE,  except != 1 ? helper(costs,1,i-1,memo) + costs[i][1] : Integer.MAX_VALUE) ,except != 2 ? helper(costs,2,i-1,memo) + costs[i][2] : Integer.MAX_VALUE);
    if(except >=0) memo[i][except] = result;
    return result;
}

//Bottom up
public int minCost(int[][] costs) {
    int n = costs.length;
    if(n == 0) return 0;
    int[][] dp = new int[n][3];
    dp[0] = costs[0];
    for(int i = 1;i< costs.length;i++){
        dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
        dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
        dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
    }
    return Math.min(dp[n-1][0], Math.min(dp[n-1][1],dp[n-1][2]));
}