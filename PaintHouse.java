//Time Complexity : exponential
//Space Complexity : exponential

//Did it run on leet code: Time limit exceeded

// recursive Solution


class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0)
            return 0;
      int case1 = helper(costs,0,0,0);
      int case2 = helper(costs,0,0,1);
      int case3 = helper(costs,0,0,2);
        
       return Math.min(case1,Math.min(case2,case3));
    }
    
    private int helper(int costs[][] ,int min ,int row , int lastColor){
        
        
        if(row >= costs.length)
            return min;
        
        //choose 1st color
         int case1 = Integer.MAX_VALUE;
         int case2 = Integer.MAX_VALUE;
         int case3 = Integer.MAX_VALUE;
        
        if(lastColor == 0){
            case1 = Math.min( helper(costs,min+costs[row][1], row + 1 ,1)
             ,helper(costs,min+costs[row][2] ,row +1 ,2));
        }
        
                //chosse second color

        if(lastColor == 1)
        {
             case2 = Math.min(helper(costs, min+costs[row][0], row +1 ,0)
            ,helper(costs, min+costs[row][2], row +1 , 2));
            
        }
         //choosee third color
    
        if(lastColor == 2){
           case3 = Math.min(helper(costs , min+costs[row][0],row +1 ,0),
            helper(costs ,min+costs[row][1],row + 1,1));
        }
                 
      
        return Math.min(case1,Math.min(case2,case3));
        
        
       
        
        
    }
}

//Time Complexity : O(n)
//Space Complexity : Since in the case the original array is mutated so the complexity is O(1)
//otherwise it would be O(n)

//Did it run on leet code: yes


//Dp Solution

class Solution {
     public int minCost(int[][] costs) {
       //base case 
        if(costs == null || costs.length == 0)
            return 0;
     
        
        for(int i = 1; i< costs.length;i++){
            //getting minimunm value from above row 
              costs[i][0] += Math.min(costs[i-1][1] ,costs[i-1][2]);
              costs[i][1] += Math.min(costs[i-1][0] ,costs[i-1][2]);
              costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
            }
            
           //return minimum of the last row.
           return Math.min(costs[costs.length-1][0],
		   Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
        }
        
      
    }
    
   
