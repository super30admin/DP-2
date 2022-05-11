// Time Complexity :O(n)
// Space Complexity :O(1)
class Paint {
    public int minCost(int[][] costs) {
        int[] previous = costs[costs.length -1];
        if (costs.length == 0) return 0;
        for (int n = costs.length - 2; n >= 0; n--) {
            int[] current = costs[n];
            current[0] += Math.min(previous[1], previous[2]);
            current[1] += Math.min(previous[0], previous[2]);
            current[2] += Math.min(previous[0], previous[1]);
            previous = current;
        }  
        return Math.min(Math.min(previous[0], previous[1]), previous[2]);
        
    }
}