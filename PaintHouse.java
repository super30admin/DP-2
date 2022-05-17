//time complexity: O(mn)
//space complexity:O(1)
public class PaintHouse {
    public int min(int[][] costs){
        if(costs == null && costs.length==0) return 0;
        int n = costs.length;

        int costR =costs[n-1][0];
        int costB=costs[n-1][1];
        int costG=costs[n-1][2];
        for(int i=n-2;i>=0;i--){
            int tempR = costR;
            int tempB = costB;
            costR = costs[i][0]+Math.min(costG, costB);
            costB = costs[i][1]+Math.min(tempR, costG);
            costG = costs[i][2]+Math.min(tempR, tempB);

        }
    return Math.min(costR, Math.min(costB,costG));
    }

    public static void main(String args[]){
        PaintHouse obj = new PaintHouse();
        System.out.println(obj.min(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
