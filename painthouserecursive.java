//Time complexity : 3^n
//Space complexity: O(1)

//First we take initial 3 cases for recursion, fixing the First house, we take the 3 colors - red blue green
// and call the minimum of the 3 (recursion takes place with next house in each level)

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        return Math.min(helper(costs,0,0),Math.min(helper(costs,0,1),helper(costs,0,2)));
    }
    
    public int helper(int[][]costs, int index1,int index2){
        //base case
        int mincost=costs[index1][index2];
        if(index1==costs.length-1) {
            //Don't do anything, Return mincost;
        }
        //logic
        //red
        else if(index2==0) {
            mincost+=Math.min( helper(costs,index1+1,1),helper(costs,index1+1,2));
        }
        //blue
        else if(index2==1)  {
            mincost += Math.min(helper(costs,index1+1,0),helper(costs,index1+1,2));
        }
        //green
        else if(index2==2) {
            mincost += Math.min(helper(costs,index1+1,0),helper(costs,index1+1,1));
        }
        return mincost;
    }
}