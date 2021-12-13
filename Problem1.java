//time - O(n)
//space O(n)
class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length+1][3];
        
        for(int i=1; i<=costs.length; i++) {
            dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i-1][2] + Math.min(dp[i-1][1],dp[i-1][0]);
            System.out.println( dp[i][0] + " " +  dp[i][1] + " " +  dp[i][2]);
        }
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
        
    }
}

//recursin
class Solution {
    public int minCost(int[][] costs) {
        int red = helper(costs,0,0);
        int blue = helper(costs,0,1);
        int green = helper(costs,0,2);
        return Math.min(red, Math.min(blue,green));
    }
    
    public int helper(int[][] costs, int index, int colorIndex) {
        if(index == costs.length-1)
            return costs[index][colorIndex];
        
        if(colorIndex == 0) {
            int blue=helper(costs,index+1,1);
            int green=helper(costs,index+1,2);
            return costs[index][0] + Math.min(blue,green);
        } else if(colorIndex == 1) {
            int red=helper(costs,index+1,0);
            int green=helper(costs,index+1,2);
             return costs[index][1] + Math.min(red,green);
        } else  {
            int red=helper(costs,index+1,0);
            int blue=helper(costs,index+1,1);
             return costs[index][2] + Math.min(blue,red);
        }
    }
}