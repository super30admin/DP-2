//Time Complexity: O(n)
//Space Complexity: O(n*3)
//Did it run on leetcode: Yes
//Problems faced any?: No

class Problem21 {
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;

        int[][] minCost = new int[costs.length][3];

        for(int i=0; i<minCost.length; i++){
            if(i==0){
                minCost[i][0] = costs[i][0];
                minCost[i][1] = costs[i][1];
                minCost[i][2] = costs[i][2];
            }else{
                minCost[i][0] = costs[i][0] + Math.min(minCost[i-1][1], minCost[i-1][2]);
                minCost[i][1] = costs[i][1] + Math.min(minCost[i-1][0], minCost[i-1][2]);
                minCost[i][2] = costs[i][2] + Math.min(minCost[i-1][0], minCost[i-1][1]);
            }

        }

        return Math.min(minCost[minCost.length-1][0], Math.min(minCost[minCost.length-1][1],minCost[minCost.length-1][2]));
    }
}