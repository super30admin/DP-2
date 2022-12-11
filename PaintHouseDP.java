public class PaintHouseDP {
    public int minCost(int[][] costs){
        if (costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int valR = costs[m-1][0];
        int valB = costs[m-1][1];
        int valG = costs[m-1][2];

        for (int i=m-2;i>=0;i--){
            int tempR = valR;
            valR = costs[i][0] + Math.min(valB,valG);
            int tempB = valB;
            valB = costs[i][1] + Math.min(tempR,valG);
            valG = costs[i][2] + Math.min(tempR,tempB);
        }
        return Math.min(valR, Math.min(valG,valB));
    }

    public static void main(String[] args){
        int[][]  costs= {{17,2,17},
                        {16,16,5},
                        {14,3,19}};
        PaintHouseDP pp = new PaintHouseDP();
        System.out.println(pp.minCost(costs));
    }
}
