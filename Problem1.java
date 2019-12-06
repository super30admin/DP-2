//Brute Force Solution
//Time Complexity - O(2^n)
//Space Complexity - O(2^n)
// This solution gave time limit exceeded error on Leetcode

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)  return 0;
        return(Math.min(helper(costs,0,0,0),
                    Math.min(helper(costs,0,1,0),helper(costs,0,2,0))));
        
        }
    
    private int helper(int[][] costs,int i,int j,int amount){
        //base case
        if(i==costs.length) return amount;
        //logic
        int case1=0, case2=0;
        if(j==0){
            case1 += helper(costs,i+1,1,amount+costs[i][1]);   
            case2 += helper(costs,i+1,2,amount+costs[i][2]);  
        }
        if(j==1){
            case1 += helper(costs,i+1,0,amount+costs[i][0]);   
            case2 += helper(costs,i+1,2,amount+costs[i][2]);  
        }
        if(j==2){
            case1 += helper(costs,i+1,0,amount+costs[i][0]);   
            case2 += helper(costs,i+1,1,amount+costs[i][1]);  
        }
        return Math.min(case1,case2);
    }
}


// Dynamic Programing using dp array
//Time Complexity - O(n)
//Space Complexity - O(n)
// This solution worked on LeetCode

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)  return 0;
        int[][] dp= costs;
        for(int i=1;i<costs.length;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+dp[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+dp[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+dp[i][2];
        }
        int n = costs.length;
        return Math.min(dp[n-1][0],Math.min(dp[n-1][2],dp[n-1][1]));
        }  
}

// Dynamic Programing using changing the costs array
//Time Complexity - O(n)
//Space Complexity - O(1)
// This solution worked on LeetCode
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)  return 0;
        for(int i=1;i<costs.length;i++){
            costs[i][0] = Math.min(costs[i-1][1],costs[i-1][2])+costs[i][0];
            costs[i][1] = Math.min(costs[i-1][0],costs[i-1][2])+costs[i][1];
            costs[i][2] = Math.min(costs[i-1][1],costs[i-1][0])+costs[i][2];
        }
        int n = costs.length;
        return Math.min(costs[n-1][0],Math.min(costs[n-1][2],costs[n-1][1]));
        }  
}
// Dynamic Programing using temp variables
//Time Complexity - O(n)
//Space Complexity - O(1)
// This solution also worked on LeetCode

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)  return 0;
        //initialize the temp variables with first row values
        int lastR = costs[0][0];
        int lastB = costs[0][1];
        int lastG = costs[0][2];
        int currR = lastR;
        int currB = lastB;
        int currG = lastG;
        for(int i=1;i<costs.length;i++){
            lastR = Math.min(currB,currG)+costs[i][0];  // use the curr temp variable values since the last variables will be replaced
            lastB = Math.min(currR,currG)+costs[i][1];
            lastG = Math.min(currB,currR)+costs[i][2];
            currR = lastR;
            currB = lastB;
            currG = lastG;
            
        }
        int n = costs.length;
        return Math.min(currR,Math.min(currB,currG)); //return minimum of all the three last calculated values 
        }  
}
