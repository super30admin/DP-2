class Solution {
    public int minCost(int[][] costs) {
        //final top row elements
        int colorR = helper(costs,0, 0);
        int colorB = helper(costs,0, 1);
        int colorG = helper(costs,0, 2);
        return Math.min(colorR, Math.min(colorB, colorG));
    }
    private int helper(int[][] costs, int idx, int col){ //idx is for house, col is for which color
        //base
        if(idx == costs.length) return 0; //rows or if there are no houses

        //logic
        if(col == 0) return costs[idx][0] + Math.min(helper(costs, idx+1, 1), helper(costs, idx+1, 2));
        if(col == 1) return costs[idx][1] + Math.min(helper(costs, idx+1, 0), helper(costs, idx+1, 2));
        if(col == 2) return costs[idx][2] + Math.min(helper(costs, idx+1, 0), helper(costs, idx+1, 1));

        return 868789;
    }
}