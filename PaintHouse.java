// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : The logic here in tabulation approach is storing the minimum values at each level and for a current element we add the
// previous possible combination. At the end minimum of the three variables will give the result.

// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;
        int red = costs[n-1][0];//initializing with last row elements.
        int blue = costs[n-1][1];
        int green = costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int temp1 = red; // storing in temp as the value of red will be changed next.
            red = costs[i][0] + Math.min(blue, green); //current red + minimum of previous rows blue and green
            int temp2 = blue;// storing in temp as the value of blue will be changed next
            blue = costs[i][1] + Math.min(temp1, green);
            green = costs[i][2] + Math.min(temp1, temp2);
        }

        return Math.min(red,Math.min(blue,green));//final minimum

    }
}