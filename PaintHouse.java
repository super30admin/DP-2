// Time Complexity : O(N) where n is the number of rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

    When red is choosen, the minimum value between green and blue is added to current value.
    Similarily the same is done for Green and Blue
    The minimum of three values from first row is returned.

*/


public class PaintHouse
{
    public static int minCost(int[][] costs)
    {
        if(costs==null || costs.length==0)
        {
            return 0;
        }

        for(int i = costs.length-2;i>=0;i--)
        {
            costs[i][0]= costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]= costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]= costs[i][2] + Math.min(costs[i+1][1],costs[i+1][0]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }


    public static void main(String args[])
    {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }
}