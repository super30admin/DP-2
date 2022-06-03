/* Time Complexity: O(n), n is no of houses - Actually it is O(m*n), where m is colors,
 * since m= 3, it is O(3*n) = o(n).
 * Space Complexity:O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public int minCost(int[][] costs) {
       //null
        if(costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int [][] dp = new int[n][3]; 
        int colorR = costs[n-1][0]; //n-1 is last row
        int colorB = costs[n-1][1];
        int colorG = costs[n-1][2];
        for(int i = n-2; i>=0; i--){ // n-2, from 1 row above last row
            int tempR = colorR;
            int tempB = colorB;
            colorR = costs[i][0] + Math.min(colorB, colorG); //colorR is being  overwritten here
            colorB = costs[i][1] + Math.min(tempR, colorG); //colorB is being  overwritten here 
            colorG = costs[i][2] + Math.min(tempR, tempB); //colorG is being  overwritten here 
        }
        //find minCost in top row
        return Math.min(colorR, Math.min(colorB, colorG));
    }
}
