// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes- but for some cases it came time limit exceeded
// Any problem you faced while coding this :Yes - need to work on optimizing code 


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int costR = findMinCost(costs, 0, 0, 0);
        int costB = findMinCost(costs, 0, 1, 0);
        int costG = findMinCost(costs, 0, 2, 0);
        return Math.min(costR, Math.min(costB, costG));
    }
    
    public int findMinCost(int[][]costs, int houseIndex, int color, int minCost){
        if(costs.length==0){
            return 0;
        }
        if(houseIndex == costs.length){
            return minCost;
        }
        if(color==0){
            return Math.min(findMinCost(costs, houseIndex+1, 1, minCost+costs[houseIndex][0]),
                           findMinCost(costs, houseIndex+1, 2, minCost+costs[houseIndex][0]));
        }
        if(color==1){
            return Math.min(findMinCost(costs, houseIndex+1, 0, minCost+costs[houseIndex][1]),
                           findMinCost(costs, houseIndex+1, 2, minCost+costs[houseIndex][1]));
        }
        if(color==2){
            return Math.min(findMinCost(costs, houseIndex+1, 1, minCost+costs[houseIndex][2]),
                           findMinCost(costs, houseIndex+1, 0, minCost+costs[houseIndex][2]));
        }
        return -1;
    }
}