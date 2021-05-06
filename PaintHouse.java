// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// At each and every house we try to maintain the minimum cost associated to the paint of certain color.
// We maintain this minimum by including the cost associated with the previous house as well.
// We repeat this process until we finish tracking all house.
// Finally we return the minimum cost associated in painting that house.


public class PaintHouse {
    public static int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int cR = costs[0][0]; 
        int cB = costs[0][1]; 
        int cG = costs[0][2];
        
        for(int i = 1; i < n; i++){
                int tempR = cR; 
                int tempB = cB;
                cR = costs[i][0] + Math.min(cB, cG);
                cB = costs[i][1] + Math.min(tempR,cG);
                cG = costs[i][2] + Math.min(tempR,tempB);
        }
        
        return Math.min(cR, Math.min(cB, cG));
    }
    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
        System.out.println(minCost(new int[][]{{7,6,2}}));
    }
}