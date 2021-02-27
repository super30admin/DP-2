class GeneralizedPaintHouse {

    // Time Complexity: O(nm)
    // Space Complexity: O(1)
    
    private static int paintHouse(int[][] costs){
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < costs[i].length; j++) {
                costs[i][j] += getMinCost(costs[i-1], j);
            }
        }
        return getMinCost(costs[n-1], -1);
    }

    private static int getMinCost(int[] arr, int index){
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(i != index)
                minVal = Math.min(minVal, arr[i]);
        }
        return minVal;
    }
}
