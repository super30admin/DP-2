// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Recursion with memonization
class Solution {
    HashMap<String,Integer> map;
    public int minCost(int[][] costs) {
        if(costs.length==0)
            return 0;

        map = new HashMap<>();

        return Math.min(paintHouse(costs,0,0,0),Math.min(paintHouse(costs,1,0,0),paintHouse(costs,2,0,0)));
    }

    public int paintHouse(int[][] costs, int color, int house, int totalSum){
        if(house>=costs.length)
            return 0;

        if(map.containsKey(String.valueOf(color)+String.valueOf(house)))
            return map.get(String.valueOf(color)+String.valueOf(house));

        totalSum = costs[house][color];

        if(color==0)
            totalSum += Math.min(paintHouse(costs,color+1,house+1,totalSum),paintHouse(costs,color+2,house+1,totalSum));
        else if(color==1)
            totalSum += Math.min(paintHouse(costs,color-1,house+1,totalSum),paintHouse(costs,color+1,house+1,totalSum));
        else
            totalSum += Math.min(paintHouse(costs,color-1,house+1,totalSum),paintHouse(costs,color-2,house+1,totalSum));

        map.put(String.valueOf(color)+String.valueOf(house),totalSum);

        return totalSum;
    }
}

////Bottom-Up approach
//T:O(N)
//S:O(N)

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;

        for(int i=costs.length-2;i>=0;i--){

            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
        }

        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}