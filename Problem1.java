class Solution {
    public int minCost(int[][] costs) {
        for(int i=1;i<costs.length;i++){
            for(int j=0;j<costs[0].length;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<costs[0].length;k++){
                    if(k!=j)
                        min = Math.min(min, costs[i-1][k]+costs[i][j]);
                }
                costs[i][j] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int k=0;k<costs[0].length;k++){
            min = Math.min(min, costs[costs.length-1][k]);
        }
        return min;

    }
}