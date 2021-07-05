// Time Complexity : amount * 2^n
// Space Complexity : O(n) stack space
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time Limit Exceeded due to recursion


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
      
        return helper(coins, amount, 0); // calling the helper function considering the first coin
    }
    
    private int helper(int[] coins, int amount, int index)
    {
        //base
        if(amount == 0) // when amount becomes 0 i.e we have a valid branch
            return 1; // when a branch terminates
        if(amount<0 || index>coins.length-1) // amount goes negative or we cross the index of coins array
            return 0; //invalid path
        
        //logic
        //not choose
        int case0 = helper(coins, amount, index+1); // only index increased i.e we go to next coin and amount remain same
        
        //choose
        int case1 = helper(coins, amount - coins[index], index); // on choosing a coin, amount decreases and index remain same as we can choose the coin again
         
        return case0+case1; // when decision has to made between two cases as we go up we add the ways that both cases return
       
        
        
    }
}

// Time Complexity : O(n * m)
// Space Complexity : O(n * m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        int dp[][] = new int[coins.length+1][amount+1]; 
        // no need to fill dummy row as alraedy initialized with 0
        for(int i=0;i<dp.length;i++) // one way of getting amount 0 so fill first column with 1
        {
            dp[i][0] = 1;
        }
        int n=dp.length;
        int m=dp[0].length;
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(j<coins[i-1]) // till the amount doesnt reach the coin denomination, we can't consider the coin so take the value from above that is considering only the previous coins denominations to get the amount
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    // we add the zero and one case i.e the ways in which we can get the amount without conidering current coin + the number of ways we can get considering the coin
                    // we can get the one case by going to the amount where amount = curramount- currcoin value  as on considering the cuurent coin the number of ways remain same although the coins increase 
            }
        }
        
        return dp[n-1][m-1]; // last value of dp array
        
    }
}


// Time Complexity : 3 * 2^n as 3 recursions 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time Limit Exceeded


// Your code here along with comments explaining your approach



class Solution {
    public int minCost(int[][] costs) {
        
        int caseR = helper(costs, 0, 0, 0); // when consiering the column0 from row0 as initial cost
        int caseB = helper(costs, 0, 1, 0); // when consiering the column1 from row0 as initial cost
        int caseG = helper(costs, 0, 2, 0); // when consiering the column2 from row0 as initial cost
        
        return Math.min(caseR, Math.min(caseB,caseG));// when the three cases return the values, need to compare and return min 
    }
    
    private int helper(int[][] costs, int row,int column, int min)
    {
        //base
        if(row>costs.length-1) // when we finish the costs array rows
            return min; // return min cost
        //logic
        int case0 = Integer.MAX_VALUE; // to compare the cases initially as when case0 considered, case1 and case2 havent been called
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        
        if(column == 0) // conidering first column value
        {
         case0 = Math.min(helper(costs, row+1, 1, min+costs[row][0]),
                        helper(costs, row+1, 2, min+costs[row][0])); // calling for the next row with corresponding columns and getting the min value from the two calls when costs[i][0] is considered as start
        }
        if(column == 1){
          case1= Math.min(helper(costs, row+1, 0, min+costs[row][1]),
                        helper(costs, row+1, 2, min+costs[row][1]));
        }
        if(column == 2) {
          case2= Math.min(helper(costs, row+1, 0, min+costs[row][2]),
                        helper(costs, row+1, 1, min+costs[row][2]));
        }
        
        return Math.min(case0, Math.min(case1,case2)); // getting min from the three cases
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length==0)
            return 0;
        int n = costs.length;
        for(int i=1; i<n;i++) // going top-down consiering the 2nd row
        {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]); //  updating the cost by adding the min cost out of the two remaining houses to the cost each time
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2])); // returning the min cost from the last row
        
    }
}