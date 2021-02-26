//Time complexity: O(n)
//Space Complexity: O(3)
//Runs on leetcode.
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0)return 0;
       
        //int[][] dp=new int[costs.length][3];
        int []dp = new int[3];
        for(int i=0;i<3;i++)
            dp[i] = costs[0][i];
        
        for(int i=1;i<costs.length;i++)
        {
            int []temp = new int[3];
            temp[0] = Math.min(costs[i][0]+dp[1], costs[i][0]+dp[2]);					//3 indices represent 3 colors. 
            temp[1] = Math.min(costs[i][1]+dp[0], costs[i][1]+dp[2]);					//As we cannot choose same color as previous we are choosing min of other 2 colors not in previous house
            temp[2] = Math.min(costs[i][2]+dp[0], costs[i][2]+dp[1]);
            //dp[i][0] = Math.min(costs[i][0]+dp[i-1][1], costs[i][0]+dp[i-1][2]);
            //dp[i][1] = Math.min(costs[i][1]+dp[i-1][0], costs[i][1]+dp[i-1][2]);
            //dp[i][2] = Math.min(costs[i][2]+dp[i-1][0], costs[i][2]+dp[i-1][1]);
            dp = temp;
        }  
        int min =Integer.MAX_VALUE;
        for(int i=0;i<3;i++)
            if(dp[i]<min)
                min = dp[i];
        return min;
    }
}