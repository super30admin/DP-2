//Time Complexity : O(mn)
//Space Complexity : O(mn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        //base case-if coins and its length is 0
        if(coins==null||coins.length==0)
            return 0;
        //a 2d array
        int[][] k=new int[coins.length+1][amount+1];
        //iterating over the rows ie., over the coins
        for(int i=0;i<coins.length+1;i++){
            //for all the rows filling the 1st column with 1
            k[i][0]=1;
        }
        //iterating over the coins and amount
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                //if the amount is less than coins[i-1]
                if(j<coins[i-1])
                    //get the 0case
                    k[i][j]=k[i-1][j];
                else
                    k[i][j]=k[i-1][j]+k[i][j-coins[i-1]];
            }
        }
        //return last row and column
        return k[coins.length][amount]; 
    }
}