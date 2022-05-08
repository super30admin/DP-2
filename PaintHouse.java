// Time Complexity : O(N) where n is the number of houses
// Space Complexity : O(N) ignoring 3(colors) as they are constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        // taking all the colors for the last house
        int costsR = costs[n-1][0];
        int costsB = costs[n-1][1];
        int costsG = costs[n-1][2];
        
        for(int i=n-2; i>=0; i--){
            int tempR = costsR;
            int tempB = costsB;
            
            costsR = costs[i][0] + Math.min(tempB, costsG); // take red for the current house and minimum for the previous sum of blue or green
            costsB = costs[i][1] + Math.min(tempR, costsG); // take blue for the current house and minimum for the previous sum of green or red
            costsG = costs[i][2] + Math.min(tempR, tempB); // take green for the current house and minimum for the previous sum of blue or red
        }
        
        return Math.min(costsR, Math.min(costsB, costsG)); // take the minimum of all 3
    }
}
