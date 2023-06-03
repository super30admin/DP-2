//Time Complexity=O(n)
//Space Complexity=O(n)
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs ==null || costs.length == 0)
            return 0;

        int n = costs.length;


        for(int i = n-2; i >=0; i--){

            costs[i][0] =  costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] =  costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] =  costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }


        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {
        PaintHouse paintHouse=new PaintHouse();
        System.out.println(paintHouse.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
