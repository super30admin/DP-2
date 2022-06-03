class Solution {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int minCost(int[][] costs) {
        int n=costs.length;
        int colorR=costs[n-1][0];
        int colorB=costs[n-1][1];
        int colorG=costs[n-1][2];
        for(int i=n-2;i>=0;i--){
            int tempR=colorR,tempB=colorB;
            colorR=costs[i][0]+Math.min(colorB,colorG);
            colorB=costs[i][1]+Math.min(tempR,colorG);
            colorG=costs[i][2]+Math.min(tempR,tempB);
        }
        return Math.min(colorR,Math.min(colorG,colorB));
    }
}