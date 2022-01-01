//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int minCost(int[][] costs) {
        int dp[][]=new int[costs.length][3];
    
        for(int i=0;i<3;i++)
        {
            dp[0][i]=costs[0][i];
        }
       
        for(int i=1;i<costs.length;i++)
        {
            
                dp[i][0]=costs[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1]=costs[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2]=costs[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
                
                
            
        }
        int arr[]=new int[3];int m=dp.length-1;
       for(int j=0;j<3;j++)
       {
           arr[j]=dp[m][j];
       }
        
        return arr[0];
    }
}