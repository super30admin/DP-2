// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    //Approach 2  TC:O(n*3) SC: O(1)
    public int minCost(int[][] costs) {
        //Approach 2
        if(costs == null || costs.length == 0)return 0;
        for(int i = costs.length-2;i>=0;i--){
            costs[i][0]+= Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]+= Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]+= Math.min(costs[i+1][0],costs[i+1][1]);
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
    
    
    //Approach1 -TLE
//     public int minCost(int[][] costs) {
//         if(costs == null || costs.length == 0) return 0;
        
        
//         int caseR = helper(costs,0,0,0); // cost Red
//         int caseG = helper(costs,0,1,0);// cost Green
//         int caseB = helper(costs,0,2,0); // cost Blue
        
//         return Math.min(caseR,Math.min(caseG,caseB));
//     }
    
//     private int helper(int[][] costs, int index, int color, int min ){ // index- which house, color-which color choosen
//         //base
//         if( index==costs.length){// if all houses are done
//             return min;
//         }
//         //logic
//         //ChooseRed
//         if(color == 0){//color1,2
//             return Math.min(helper(costs,index+1,1, min+costs[index][0]),//earlier cost+ costs associated to that index house w.r.t red color)
//                            helper(costs,index+1,2, min+costs[index][0]));
//         }
//         //Choose
//         if(color == 1){//color1,2
//             return Math.min(helper(costs,index+1,0, min+costs[index][1]),
//                            helper(costs,index+1,2, min+costs[index][1]));
//         }
//         //color1,2
//             return Math.min(helper(costs,index+1,0, min+costs[index][2]),
//                            helper(costs,index+1,1, min+costs[index][2]));
//     }
} 