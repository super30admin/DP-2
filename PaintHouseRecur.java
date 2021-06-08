/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp2;

/**
 *
 * @author shilpa
 */
public class PaintHouseRecur {
    public int rob(int[][] costs) {
        
        if(costs.length == 0 || costs == null) return 0;
        int case1 = recursiveApproach(costs, 0, 0, 0);
        int case2 = recursiveApproach(costs, 0, 1, 0);
        int case3 = recursiveApproach(costs, 0, 2, 0);
         return Math.min(case1, Math.min(case2, case3));
        
    }
    public int recursiveApproach(int [][] costs, int row, int color, int totalCost){
        if(row == costs.length) return totalCost;
        //base case
        if(color == 0){
            return Math.min(recursiveApproach(costs, row+1, 1, totalCost + costs[row][0]), 
                    recursiveApproach(costs, row+1, 2, totalCost + costs[row][0]));
        }
        if(color == 1){
            return Math.min(recursiveApproach(costs, row+1, 0, totalCost + costs[row][1]), 
                    recursiveApproach(costs, row+1, 2, totalCost + costs[row][1]));
        }
        if(color == 2){
            return Math.min(recursiveApproach(costs, row+1, 0, totalCost + costs[row][2]), 
                    recursiveApproach(costs, row+1, 1, totalCost + costs[row][2]));
        }
        return 0;
    }    
}
