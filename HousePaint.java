// Time Complexity : O(n) where n is no. of houses;
// Space Complexity :O(1); since we are altering the given input array.
// Did this code successfully run on Leetcode :yes
/*Bottom up Approach - if we are considering that if we are painting a house red and the next house
 would have been painted either green or blue, since here we have to make min cost to incur we will the
   cost for painting that current house in red + minimum cost of painting the next house with green/blue
   similarly we fill the whole matrix and our answer would lie in the top row, minimum among all the
   columns*/


class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;
        int m= costs.length;
        int n= costs[0].length;
        for(int j=m-2;j>=0;j--)
        {
            costs[j][0]= costs[j][0]+Math.min(costs[j+1][1],costs[j+1][2]);
            costs[j][1]= costs[j][1]+Math.min(costs[j+1][0],costs[j+1][2]);
            costs[j][2]= costs[j][2]+Math.min(costs[j+1][0],costs[j+1][1]);
        }

        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}