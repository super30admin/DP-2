//Time complexity : 3^n
//Space complexity: O(1)

//First we take initial 3 cases for recursion, fixing the First house, we take the 3 colors - red blue green
// and call the minimum of the 3 (recursion takes place with next house in each level)

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        return Math.min(helper(costs,0,0,0),Math.min(helper(costs,0,1,0),helper(costs,0,2,0)));
    }
    private int helper(int[][] costs, int row,int color,int price){
        //base
        if(row == costs.length){
            return price;
        }
        
        int case1=9999;
        int case2=9999;
        int case3=9999;
        
        //logic
        if(color==0){
            case1 = Math.min(helper(costs,row+1,1,price+costs[row][1]),helper(costs,row+1,2,price+costs[row][2]));
        }
        if(color==1){
           case2= Math.min(helper(costs,row+1,0,price+costs[row][0]),helper(costs,row+1,2,price+costs[row][2]));
        }
        if(color==2){
            case3= Math.min(helper(costs,row+1,0,price+costs[row][0]),helper(costs,row+1,1,price+costs[row][1]));
        }
            return Math.min(case1,Math.min(case2,case3));
    }

        
}