// Time Complexity :O(n*3) ~= O(n)
// Space Complexity :O(1), only storing  cost of prev and cur colors
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
   //comming up with right dp approch

// Your code here along with comments explaining your approach
  /*
    bottom - top approch.
    lets assume cost of coloring house soo far is 0 for red blue and green.
    so prev red = 0, prev blue = 0, prev green = 0.
    now for house[i] min cost of painting soo far will be.
    costs[i][red] + min(prevblue, prev green) // since we can not have same
    //color for adjcent houses.
    simillarly for green and blue:
    costs[i][green] + min(prev red, prev blue)
    costs[i][blue] + min(prev red, prev green)

    we do this for all houses,
    and last houses min cost for paint is what we want.
  */

class Solution {
    public int minCost(int[][] costs) {
        int prevR = 0;
        int prevB = 0;
        int prevG = 0;

        for( int i= 0; i < costs.length; i++){
            int curR = Math.min(prevB, prevG) + costs[i][0];
            int curB = Math.min(prevR, prevG) + costs[i][1];
            int curG = Math.min(prevR, prevB) + costs[i][2];
            prevR = curR;
            prevB = curB;
            prevG = curG;
        }
        return Math.min(prevR, Math.min(prevG,prevB));
    }
}
