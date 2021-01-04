//Problem - PaintHouse
// Time Complexity :  O(n) where n stands for number of houses. Here columns are fixed, they will be considered as constants and won't be included in calculating complexity
// Space Complexity : O(1), because constants are used for storing the values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Note 
 *  Either start from 1st element or last element.
 * 
 * 
*/


class Solution22 {
    
    public int minCost(int[][] costs) {
       
        if(costs==null || costs.length==0){
            return 0;
        }
        
        /* if existing data source is modified/mutated//SC-> O(1)-> because data source not modified
        for(int i=costs.length-2;i>=0;i--){
            
            costs[i][0] = costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
            
        }
        
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
        */
        
        // if existing data source cannot be modified/mutated
        int caseRed=costs[costs.length-1][0],caseBlue=costs[costs.length-1][1],caseGreen=costs[costs.length-1][2];
        
        for(int i=costs.length-2;i>=0;i--){
               
            int tempRed,tempBlue,tempGreen;
            
            tempRed   = costs[i][0]+Math.min(caseBlue,caseGreen);
            tempBlue  = costs[i][1]+Math.min(caseRed,caseGreen);
            tempGreen = costs[i][2]+Math.min(caseRed,caseBlue);
            
            caseRed   = tempRed;
            caseBlue  = tempBlue;
            caseGreen = tempGreen;
        }
        
        return Math.min(caseRed,Math.min(caseBlue,caseGreen));
        
    }
}  


/*
//TC -> O(n) where n stands for number of houses. Here columns are fixed, they will be considered as constants and won't be included in calculating complexity
SC -> O(n), where n stands for number of houses, because columns(colors) are fixed means they are constant
class SolutionTopDown {
       
    private Integer[][] dp;
    public int minCost(int[][] costs) {
       
        if(costs==null || costs.length==0){
            return 0;
        }
        
        dp = new Integer[costs.length+1][costs[0].length+1];
        
        int case1Green = calcMinCost(costs,costs.length-1,2);
        int case2Blue = calcMinCost(costs,costs.length-1,1);
        int case3Red = calcMinCost(costs,costs.length-1,0);
        
        
        return Math.min(case1Green,Math.min(case2Blue,case3Red));
    }
    
    
    private int calcMinCost(int[][] costs, int row, int colorIndex){
        
        //base
        
        if(row<=0){
            return costs[row][colorIndex];
        }
        
        if(dp[row][colorIndex]!=null){
            return dp[row][colorIndex];
        }
        
        //logic
        if(colorIndex==0){
            return dp[row][colorIndex] = costs[row][colorIndex] + Math.min(calcMinCost(costs,row-1,1),calcMinCost(costs,row-1,2));
        }else if(colorIndex==1){
            return dp[row][colorIndex] = costs[row][colorIndex] + Math.min(calcMinCost(costs,row-1,0),calcMinCost(costs,row-1,2));
        }else{//for color 2
            return dp[row][colorIndex] = costs[row][colorIndex] + Math.min(calcMinCost(costs,row-1,0),calcMinCost(costs,row-1,1));
        }
        
        
    }
}

*/