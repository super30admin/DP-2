public class PaintHouseRecursive {
    public int minCost(int[][]costs){
        if(costs == null) return 0;
        int rCost =  helper(costs, 0, 0, 0);
        int bCost = helper(costs, 0, 1, 0);
        int gCost = helper(costs, 0, 2, 0);
        return Math.min(rCost, Math.min(bCost, gCost));
    }
    private int helper(int[][]costs,  int idx, int color, int costTillNow){
        //base
        if(idx == costs.length) return costTillNow;

        //logic
        if(color == 0){
            int bCost = helper(costs,idx+1, 1, costTillNow+costs[idx][0]);
            int gCost = helper(costs,idx+1, 2, costTillNow+costs[idx][0]);
            return Math.min(bCost, gCost);
        }
        if(color ==1){
            int rCost = helper(costs,idx+1, 0, costTillNow+costs[idx][1]);
            int gCost = helper(costs,idx+1, 2, costTillNow+costs[idx][1]);
            return Math.min(rCost, gCost);
        }
        if(color == 2){
            int rCost = helper(costs,idx+1, 0, costTillNow+costs[idx][2]);
            int bCost = helper(costs,idx+1, 1, costTillNow+costs[idx][2]);
            return Math.min(rCost, bCost);
        }
        return 9999;
    }
}
