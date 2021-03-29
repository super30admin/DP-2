/**Leetcode Question - 256 - Paint House */
/**Algorithm - DP 
 * Find the sum value for selecting every house using the bottom top approach
 * Keep adding the minimum to the current sum for every single colour and then finally select the min out of all of them.
*/
/**TC- O(N)
 * SC - O(N)
 */
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length ==0){
            return 0;
        }
        int cr = costs[costs.length -1][0];
        int cg = costs[costs.length -1][1];
        int cb = costs[costs.length -1][2];
        for(int i =costs.length-2; i>=0; i--){
            int tempr = cr, tempg = cg;
            cr = costs[i][0] + Math.min(cb,cg);
            cg = costs[i][1] + Math.min(tempr,cb);
            cb = costs[i][2] + Math.min(tempr, tempg);
        }
        return Math.min(cr, Math.min(cb,cg));
    }
}