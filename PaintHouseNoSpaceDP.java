class Solution {
    public int minCost(int[][] costs) {
        //using dp ( compute the cost in the same arr)
        //using dp (using 3 variable)
        //null check
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int lastRow = costs.length-1;
        int prevB = costs[lastRow][0];
        int prevG = costs[lastRow][1];
        int prevR = costs[lastRow][2];

       // choose blue, green , red house and then add cost of that house and min between other two adjacent houses
       for(int i = costs.length-2; i>=0 ;i--) {
           costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
           costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
           costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
       }
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
        int tempB = prevB;
        int tempG = prevG;
        prevB = costs[i][0] + Math.min(prevR,prevG);
        prevG = costs[i][1] + Math.min(tempB,prevR);
        prevR = costs[i][2] + Math.min(tempB,tempG);
     }return Math.min(prevB,Math.min(prevG,prevR));
}

}