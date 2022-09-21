// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        int[][] testCase1={{14,20,11},{11,14,5},{14,3,10}};
        
        System.out.println(minCost(testCase1));
        
        int[][] testCase2={{1,2,3},{1,4,6}};
        
        System.out.println(minCost(testCase2));
        
        int[][] testCase3={{1,2,3}};
        
        System.out.println(minCost(testCase3));
        
    }
    
    public static int minCost(int[][] costs) {
        // write your code here
        
        int n=costs.length;
        
        int[][] dp=new int[n][3];
        
        for(int i=0;i<3;i++)
            dp[0][i]=costs[0][i];
        
        for(int i=1;i<n;i++)
        {
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
        }
        
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no - premium problem
// Any problem you faced while coding this : no
