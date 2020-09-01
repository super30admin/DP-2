//Coin Change 2
// Time Complexity :0(m*n)
// Space Complexity :0(m*n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp= new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
        {
            dp[i][0]=1;
        }
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}


//paint house
// Time Complexity :0(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :no,this question is locked
// Any problem you faced while coding this : still not getting the correct output, don't lnow where I went wrong.
class Solution {
    public static int change( int[][] cost) {

        if(cost.length==0)
        {
            return 0;
        }
        for(int i=1;i<cost.length;i++)
        {
            cost[i][0]=Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1]=Math.min(cost[i-1][2],cost[i-1][0]);
            cost[i][2]=Math.min(cost[i-1][0],cost[i-1][1]);


        }
        return Math.min(cost[cost.length-1][0],Math.min(cost[cost.length-1][1],cost[cost.length-1][2]));
    }

    public static void main(String[] args)
    {
        int[][] cost = {
                {17, 2, 1}, {16, 16, 1}, {14, 3, 19}, {3, 1, 8}
        };
        int minCost = change(cost);
        System.out.println(minCost);

    }
}
