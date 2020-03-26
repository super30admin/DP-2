// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class PaintHouse {
    public static int minCost(int[][] costs) { 
        //edge case
        if(costs.length==0) return 0;
        int[] dp = new int[3];
        for(int x=0;x<3;x++)
        {
            dp[x]= costs[0][x];
        }
        for(int x=1;x<costs.length;x++)
        {
            //red
            int sol1=  Math.min(dp[1],dp[2]);
            
            //green
            int sol2 = Math.min(dp[0],dp[2]);
            
            //blue
            int sol3 = Math.min(dp[0],dp[1]);
                
            //update
            dp[0] = costs[x][0]+sol1;
            dp[1] = costs[x][1]+sol2;
            dp[2] = costs[x][2]+sol3;
        }
        return Math.min(Math.min(dp[0],dp[1]),dp[2]);
    }
    public static void main(String[] args)
    {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }

}