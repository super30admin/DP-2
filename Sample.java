//Paint House
//Time Complexity : O(N)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        //If the costs matrix is empty return 0
        if(costs==null || costs.length==0) return 0;
        int n = costs.length;
        //store last row values in red 0th column,blue 1st column & last column green
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        for(int i = n-2; i >= 0; i--){
            //store the initial values of red and blue in temp so that when                       //manipulated we will have old values
            int tempR = costR;
            int tempB = costB;
            //add the values of next row  + with minimum between other two colors of pervious row 
            costR = costs[i][0]+Math.min(costG,costB);
            costB = costs[i][1]+Math.min(tempR,costG);
            costG = costs[i][2]+Math.min(tempR,tempB);
        }
        //finally all values will be in first row 
        //return min between first row elements
        return Math.min(costR,Math.min(costB,costG));
    }
}


//Coin Change
//Time Complexity : O(N)
//Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution2 {
    public int change(int amount, int[] coins) {
        //if coins array is empty return 0
        if(coins==null || coins.length==0) return 0;
        int[] dp = new int [amount+1];
        for(int i=1; i<=coins.length; i++){
            //fill first element 0 because only 1 way to may 0 i.e, by not choosing it
            dp[0]=1;
            for(int j=1; j<=amount; j++){
                //amount greater than coin denomination
                if(j >= coins[i-1]){
                  dp[j]=dp[j]+dp[j-coins[i-1]];
                }
               
            }
        }
        //return last element
        return dp[amount];
    }
}
