// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


//Problem 1 Approach 1: Recursive

class Solution {
    
    //Time Complexity = O(2^n) 
    // Space Complexity= O(1)
    public int minCost(int[][] costs) {
        
        int case1= helper(costs,0,0,0); //choose the first color red
        int case2=helper(costs,0,1,0); //choose the second color blue
        int case3=helper(costs,0,2,0); //choose the third color green
        
        return Math.min(case1 , Math.min(case2, case3)); // return the minimum of all 
        
    }
    
    private int helper(int[][] costs, int row, int color, int result){
        
        //base
        if(row == costs.length) return result;   //if my row is the last row, then return the result       
        //logic
        
        if(color==0)
        {
            return Math.min((helper(costs,row+1, 1, result+ costs[row][0])), helper(costs, row+1, 2, result+ costs[row][0])); 
            //if color is red, calculate the min from 2nd and 3rd row skipping color red in the second row
        }
        
        if(color==1)
        {
            return Math.min((helper(costs, row+1, 0, result+ costs[row][1])), helper(costs, row+1, 2, result + costs[row][1]));
            //if color is blue, calculate the min from 2nd and 3rd row skipping color blue in the second row
        }
        
        if(color==2)
        {
            return Math.min((helper(costs, row+1, 0, result+ costs[row][2])), helper(costs, row+1,1, result + costs[row][2]));
            //if color is green, calculate the min from 2nd and 3rd row skipping color green in the second row
        }
        
        return 394; //return random 
        
    }
}

//Problem 1 Approach 2: DP

class Solution3 {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length==0) return 0; //return 0 if null case
        
        for(int i=costs.length -2; i>=0; i--) //iterate from second last row to 0th row
        {
            costs[i][0]= costs[i][0]+ Math.min(costs[i+1][1], costs[i+1][2]); //calculate the 0th column value by adding the min of the next row
            costs[i][1] =costs[i][1]+Math.min(costs[i+1][0], costs[i+1][2]); //calculate the 1st column value by adding the min of the next row
            costs[i][2]= costs[i][2]+Math.min(costs[i+1][0], costs[i+1][1]); //calculate the 2nd column value by adding the min of the next row
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2])); //return the min of the first row
    }
}


// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

//Problem 2 Approach 1: DP

class Solution1 {
    public int change(int amount, int[] coins) {
        
        if(coins==null || coins.length==0) return -1; 
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        //set first row all columns to 0 
        for(int j=0;j< dp[0].length;j++)
        {
            dp[0][j]= 0; 
        }
        
        //set the first column to 1 since the valid number of path is 1 by not choosing the coin 
        for(int i=1;i<dp.length; i++)
        {
            dp[i][0]= 1; 
        }
        
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]= dp[i-1][j]; //copy the above 0th case
                }
                else
                {
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]]; //else add the total number of valid path
                }
            }
        }
        int result= dp[dp.length-1][dp[0].length-1]; 
        return result; 
        
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

//Problem 2 Approach 2: Recursive approach 

class Solution2 {
    public int change(int amount, int[] coins) {
        
        if(coins==null || coins.length == 0) return 0; 
        return helper(amount, coins,0); 
    }
    
    private int helper(int amount, int[] coins, int index)
    {
        if(amount==0) return 1; 
        
        if(index==coins.length || amount < 0) return 0;
        
        //choose
        int case1 = helper(amount-coins[index], coins, index); 
        
        //not choose
        int case2 = helper(amount, coins, index+1); 
        
        return case1+case2; 
    }
}

