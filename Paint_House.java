//Time Complexity - O(n)
//Space Complexity - O(1)


class Solution {
    public int minCost(int[][] costs) {

        if(costs.length == 0) return 0;


        /** Count from second last row by comparing minimum between indexes in i+1 rows and add it to the cost*/
        for(int i = costs.length - 2; i >= 0; i--){

            costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);

        }

        /** return minimum from the first row itself */
        return Math.min(Math.min(costs[0][0],costs[0][1]),costs[0][2]);



    }
}