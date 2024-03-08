//tc = o(3n) where n is number of houses and 3 is the number of colors => 0(n)
//sc = o(3n) where n is number of houses and 3 is the number of colors => 0(n)

//use result array while calculating min not cost array
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] result = new int[len][3];
        result[0][0] = costs[0][0];
        result[0][1] = costs[0][1];
        result[0][2] = costs[0][2];
        for(int i=1;i<len;i++){
            result[i][0] = costs[i][0] + Math.min(result[i-1][1],result[i-1][2]);
            result[i][1] = costs[i][1] + Math.min(result[i-1][0],result[i-1][2]);
            result[i][2] = costs[i][2] + Math.min(result[i-1][0],result[i-1][1]);
        }
        return Math.min(result[len-1][0],Math.min(result[len-1][1],result[len-1][2]));
    }
}