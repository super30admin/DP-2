// Time Complexity : O(N)
// Space Complexity : O(N)

//It's tree in process so time and space will be in O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*

Using Bottom-Up Approach,

For each colors, we add the min of costs of other 2 colors. 

At last, min of 3 costs from first row will be min cost of painting all the houses.

*/

class Solution {
    public int minCost(int[][] costs) {
       if(costs == null || costs.length == 0){
           return 0;
       }
       
        for(int i = costs.length - 2; i >= 0; i--){
            //Red - Color = 0
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);

            //Blue - Color = 1
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);             
            //Green - Color = 2
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
           
        return Math.min(costs[0][0], Math.min( costs[0][1], costs[0][2] ) );
    }
} 


/*
//Brute-Froce Solution


public int minCost(int[][] costs) {
       if(costs == null || costs.length == 0){
           return 0;
       }
       
       int red = calculate(costs,0, 0, 0); //Color = 0
       int blue = calculate(costs, 0, 1, 0); // Color = 1
       int green = calculate(costs, 0, 2, 0); // Color = 2
       
       return Math.min(red, Math.min(blue, green));
   }
   
   public int calculate(int[][] costs, int index, int color, int min){ 
       if(index == costs.length){
           return min;
       }
           
       if(color == 0){
           return Math.min( calculate(costs, index + 1, 1, min + costs[index][0]), 
                            calculate(costs, index + 1, 2, min + costs[index][0]) );
       }
       else if(color == 1){
           return Math.min( calculate(costs, index + 1, 0, min + costs[index][1]), 
                            calculate(costs, index + 1, 2, min + costs[index][1]) );
       }
       else{
           return Math.min( calculate(costs, index + 1, 0, min + costs[index][2]), 
                            calculate(costs, index + 1, 1, min + costs[index][2]) );  
       }
       
   }


*/


