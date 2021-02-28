#Time Complexity :  O(n) where n is number of houses
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Paint_House {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        for(int i = 1; i< n; i++){

            // min for red
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);

            //min for green
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);

            //min for blue
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        //find min among red, green, blue in the last row
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
