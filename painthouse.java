//Time complexity:O(n) n-> number of houses
//space complexity:O(1)
class Solution {
    public int minCost(int[][] costs) {
        for(int i=costs.length-2;i>=0;i--){
            for(int j=0;j<costs[0].length;j++){
                if(j==0){
                    costs[i][j]+=Math.min(costs[i+1][1],costs[i+1][2]);
                }
                if(j==1){
                    costs[i][j]+=Math.min(costs[i+1][0],costs[i+1][2]);
                }
                if(j==2){
                    costs[i][j]+=Math.min(costs[i+1][0],costs[i+1][1]);
                }
            }
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}