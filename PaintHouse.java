class PaintHouse {
    public int minCost(int[][] costs) {
        
        if(costs.length == 0){
            return 0;
        }
        
        /*
        Method 1: recurisve approach with exponential time
        
        int case1 = helper(costs,0,0,0);
        int case2 = helper(costs,0,1,0);
        int case3 = helper(costs,0,2,0);
        
        return Math.min(case1, Math.min(case2,case3));
        
    }
    
    private int helper(int[][] costs, int row,int color, int minAmount){
        if(row == costs.length){
            return minAmount;
        }
        
       if(color == 0){
          return Math.min(helper(costs,row+1,1,minAmount+costs[row][0]), 
                          helper(costs,row+1,2,minAmount+costs[row][0]));
       }
        if(color == 1){
          return Math.min(helper(costs,row+1,0,minAmount+costs[row][1]),
                          helper(costs,row+1,2,minAmount+costs[row][1]));
       }
        
          return Math.min(helper(costs,row+1,0,minAmount+costs[row][2]),
                          helper(costs,row+1,1,minAmount+costs[row][2]));
       
        
    } */
        
        //Method 2:
        //dp approach 
        //time complexit: O(n^2)
        //space complexity: O(1)
        //// Did this code successfully run on Leetcode :yes
    // Any problem you faced while coding this :no
        
        int n = costs.length;
        
//         for(int i = n-2; i>=0; i--){
            
//             costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
//             costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
//             costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
            
//         }
        
//         return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
        
//     }
    
    /*
    method 3:
    instead of modifying the matrix or keeping another matrix for dp, we see that at each step we are using only 3 variables 
    */
    int red = costs[costs.length-1][0];
    int green = costs[costs.length-1][1];
    int blue = costs[costs.length-1][2];
        
        for(int i = n-2;i>=0; i--){
            int temp1 = red;
            int temp2 = green;
            
            red = costs[i][0] + Math.min(green,blue);
            green = costs[i][1] + Math.min(temp1,blue);
            blue = costs[i][2] + Math.min(temp1,temp2);
        }
    
    return Math.min(red,Math.min(blue,green));
    }
}
