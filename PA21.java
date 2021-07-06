//Leetcode 256. Paint House
//Time Complexity : O(n) //n is no of houses
//Space Compplexity : O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs== null || costs.length==0 ){
            return 0;
        }
        int bl=costs[0][0];
        int r=costs[0][1];
        int g=costs[0][2];
        int tbl=0;
        int tr=0;
        int tg=0;
        for (int i=1; i<costs.length;i++){
          
                tbl=bl;
                tr=r;
                tg=g;
                bl= Math.min(tr,tg)+costs[i][0];
                r= Math.min(tbl,tg)+costs[i][1];
                g= Math.min(tr,tbl)+costs[i][2];
            
        }
        return Math.min(Math.min(r,g),bl);
    }
}