// Time Complexity : O(3.2^n), n -> number of house
// Space Complexity : O(3n), considering recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


//Recursive Solution

class Solution {
    int[][] costs;
    int min = Integer.MAX_VALUE;
    
    public int minCost(int[][] costs) {
        this.costs = costs;
        
        //when we choose 1st color to start
        int case1 = helper(0,0,0);
        //when we choose 2nd color to start
        int case2 = helper(0,1,0);
        //when we choose 3rd color to start
        int case3 = helper(0,2,0);
        return Math.min(case1, Math.min(case2, case3));
    }
    
    private int helper(int row, int color, int mincost){
        if(row==costs.length)
            return mincost;
        int case1, case2, case3; 
        case1 = case2 = case3 = Integer.MAX_VALUE;
        
        if(color == 0){
            case1 = Math.min(helper(row+1, 1, mincost+costs[row][1]), helper(row+1, 2, mincost+costs[row][2]));
        }
        if(color == 1){
            case2 = Math.min(helper(row+1, 0, mincost+costs[row][0]), helper(row+1, 2, mincost+costs[row][2]));
        }
        if(color == 2){
            case3 = Math.min(helper(row+1, 1, mincost+costs[row][1]), helper(row+1, 0, mincost+costs[row][0]));
        }
        return Math.min(case1, Math.min(case2, case3));
    }
}


// Time Complexity : O(3.2^n), n -> number of house
// Space Complexity : O(3n), considering recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// DP Solution

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;
        
        for(int i=1; i<costs.length; i++){
            for(int j=0; j<costs[i].length; j++){
                int min = Integer.MAX_VALUE;
                
                //fiding min of previous row
                for(int k=0; k<costs[i].length; k++){
                    if(k!=j)
                        min = Math.min(min, costs[i-1][k]);
                }
                costs[i][j] = costs[i][j] + min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int j=0; j<costs[0].length; j++){
            min =  Math.min(min, costs[costs.length-1][j]);    
        }
        
        return min;
    }
}