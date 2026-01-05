//way1
//Let's try to explore all the flows. And identify the minimum possible route
//Tc: m*(2^n)
class Solution {
    public int minCost(int[][] costs) {
        int case1=helper(costs,0,0);

        int case2=helper(costs,0,1);

        int case3=helper(costs,0,2);

        return Math.min(case1,Math.min(case2,case3));
        
    }

    private int helper(int[][] costs, int i, int j){
        //base case
        if(i==costs.length) return 0;

       
        //logic
        if(j==0){
            return costs[i][j] + Math.min(helper(costs, i+1, 1), 
                            helper(costs,i+1,2));
        }else if(j==1){
            return Math.min(costs[i][j]+helper(costs,i+1,0),
                            costs[i][j]+helper(costs,i+1,2));
        }else{
            return Math.min(costs[i][j]+helper(costs,i+1,0),
                            costs[i][j]+helper(costs,i+1,1));
        }
    }
}

//way2
//Let's try to explore all the flows. And identify the minimum possible route -- causing time limit exceeded
//So, doing memoization. Trying to remember prev results
//Tc: m*n; SC: m*n
class Solution {
    public int minCost(int[][] costs) {

        int[][] memo=new int[costs.length][3];
        int case1=helper(costs,0,0,memo);

        int case2=helper(costs,0,1,memo);

        int case3=helper(costs,0,2,memo);

        return Math.min(case1,Math.min(case2,case3));
        
    }

    private int helper(int[][] costs, int i, int j,int[][] memo){
        //base case
        if(i==costs.length) return 0;

        if(memo[i][j]!=0) return memo[i][j];

       
        //logic
        if(j==0){
            memo[i][j]= costs[i][j] + Math.min(helper(costs, i+1, 1,memo), 
                            helper(costs,i+1,2,memo));
            return memo[i][j];
        }else if(j==1){
            memo[i][j] = Math.min(costs[i][j]+helper(costs,i+1,0,memo),
                            costs[i][j]+helper(costs,i+1,2,memo));
                            return memo[i][j];
        }else{
           memo[i][j] = Math.min(costs[i][j]+helper(costs,i+1,0,memo),
                            costs[i][j]+helper(costs,i+1,1,memo));
                            return memo[i][j];
        }
    }
}

//way3:
//Tabulation
//Tracking all the flows and identifying the min at every step
//Returning min at last row
//TC: O(m*n); SC: O(m*n)

class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;

        int[][] dp=new int[n][3];
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    dp[i][j]=costs[i][j]+Math.min(dp[i-1][1],dp[i-1][2]);
                }else if(j==1){
                    dp[i][j]=costs[i][j]+Math.min(dp[i-1][0],dp[i-1][2]);
                }else{
                    dp[i][j]=costs[i][j]+Math.min(dp[i-1][0],dp[i-1][1]);
                }
            }
        }

        return Math.min(dp[n-1][0],Math.min(dp[n-1][2],dp[n-1][1]));
        
    }
}
