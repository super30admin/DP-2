// Time Complexity : O(n) where n is the length of coins and m is the amount
// Space Complexity : O(1) , manipulated input array, no extra space
// Did this code successfully run on Leetcode : It is Premium quest
// Any problem you faced while coding this : Nothing specific

//looping over the input array, from the 2nd row, as we do not have anything for the 1st row to compare with.
//we only have 3 colors, so number of columns is fixed. we can calculate minimum from the above row for the possible colors and add it to the current row
//In the end, return the minimum of the values in the final row.

class PaintHouses{
    public int paint(int[][] cost){
        if(cost==null||cost.length==0) return 0;

        for(int i=1;i<cost.length;i++){
            cost[i][0]+=Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1]+=Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2]+=Math.min(cost[i-1][1],cost[i-1][0]);
        }
        return Math.min(cost[cost.length-1][0],Math.min(cost[cost.length-1][1],cost[cost.length-1][2]));
    }
}