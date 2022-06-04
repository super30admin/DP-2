//Problem -1:Paint House
// Time Complexity :O(n)
// Space Complexity :1
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Intially thoughfor doing any number of give colours.


/* Your code here along with comments explaining your approach: Here the approach is not to choose the adjcent houses in
  the given 2d matrix.If we choose a colour for a house then we try to choose the other colours for the house.And we try
  to calculate the cost and we return the minimum if all the three(choosing each colour as first)*/
 // This solution works if there are more than three colours with some modifications
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs==null || costs.length==0) return 0;
        int minCost1=Integer.MAX_Value
        int minCost=0;
        int temp=0;
        int temp1=0;
        int colour =0;
        int houses=costs.length;
        for(int j=0;j<costs[0].length;j++){
            int colour=j;
            minCost=costs[0][colour];
            for(int i=0;i<houses-1;i++){
                if(colour==0){
                    minCost=Math.min(costs[i+1][colour+1],costs[i+1][colour+2])+minCost;
                    temp=Math.min(costs[i+1][colour+1],costs[i+1][colour+2]);
                    if(temp==costs[i+1][colour+1]) temp1=colour+1;
                    else temp1=colour+2;
                }
                if(colour==1){
                    minCost=Math.min(costs[i+1][colour-1],costs[i+1][colour+1])+minCost;
                    temp=Math.min(costs[i+1][colour-1],costs[i+1][colour+1]);
                    if(temp == costs[i+1][colour-1]) temp1=colour-1;
                    else temp1=colour+1;
                }
                if(colour==2){
                    minCost=Math.min(costs[i+1][colour-2],costs[i+1][colour-1])+minCost;
                    temp=Math.min(costs[i+1][colour-2],costs[i+1][colour-1]);
                    if(temp==costs[i+1][colour-2]) temp1=colour-2;
                    else temp1=colour-1;
                }
                colour=temp1;
            }
            minCost1=Math.min(minCost,minCost1);
        }
        return minCost1;
    }
}
//Alternate Solution for prolem-1
// write your code here
        if(costs==null || costs.length==0) return 0;
                n= costs.length;
                for(int i=n-2;i>0;i++){
                costs[i][0]= costs[i][0]+Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1]=costs[i][1]+Math.min(costs[i-1][0],costs[i-1][2]);
                costs[i][2]=costs[i][2]+Math.min(costs[i-1][0],costs[i-1][1]);
                }
                return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));

//Problem -2:Coin Change -2
// Time Complexity :O(mn)
// Space Complexity :mn
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

/* Your code here along with comments explaining your approach: Here for the given problem we have to return the number
 combinations that make upto the sum. For this we construct the dp array. For the dummy variable like making amount 0
 from the given coins is 1 combination with all the coins. For making amount 1 with coins 0 and 1 we take the sum
 of making amount 1 with coin 0 and making sum 0 with coin 1 and 0. We follow the same for all the places in the 2d array.
 the last element of the array gives us the total number of combinations.
 DP ARRAY
   0 1 2 3 4 5
0  1 0 0 0 0 0
1  1 1 1 1 1 1  //for amount 5 and given array [1,2,5]
2  1 1 2 2 3 3
5  1 1 2 2 3 4
 */

class Solution {
    public int change(int amount, int[] coins) {
        int row=coins.length;
        int column=amount;
        int [][] dp= new int[row+1][column+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[row][column];

    }
}