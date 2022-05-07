// Time Complexity : O(2^N), N = #houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes with one exception Time  exceeded
// Any problem you faced while coding this : NO
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        return Math.min(helper(costs, 0, 0), Math.min(helper(costs, 1, 0), helper(costs,2, 0)));

    }

    private int helper(int[][] costs, int index, int house) {
        int totalCost = costs[house][index];

        //logic
        int dec1 = 0;
        int dec2 = 0;
        if (house == costs.length - 1) {

        }
        else if(index == 0) {
            //decision 1
            dec1 =helper(costs, 1, house+1);
            //decision 2
            dec2 =helper(costs, 2, house+1);
            //if  both decisions are correct
            totalCost +=  Math.min(dec1,dec2);
        }else if (index == 1)  {
            //decision 1
            dec1 =helper(costs, 0, house+1);
            //decision 2
            dec2 =helper(costs, 2, house+1);
            //if  both decisions are correct
            totalCost +=  Math.min(dec1,dec2);
        }else {
            //decision 1
            dec1 =helper(costs, 0, house+1);
            //decision 2
            dec2 =helper(costs, 1, house+1);
            //if  both decisions are correct
            totalCost +=  Math.min(dec1,dec2);
        }

        return totalCost;
    }
}
