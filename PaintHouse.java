//Time Complexity - O(n)
//Space Complexity - O(1) mutating existing matrix

// Implemented using Dynamic programming as there are repetative sub problems. Started from last but one row
// and added min value of next row and other two columns to the existing value.
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        for(int i = n-2; i>= 0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][1], costs[i+1][0]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }
}
