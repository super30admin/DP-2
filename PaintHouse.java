public class PaintHouse {

    /*
    * TC - O(n)
    * SC - O(1)
    * */

    public static void main(String[] args) {
        int[][] costs ={{17,2,17},{16,16,5},{1,3,19}};
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {

        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        for (int i = n-2; i >=0 ; i--) {
            costs[i][0] = costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
        }
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min =Math.min(costs[0][i],min);
        }
        return min;
    }


    /*
public static int minCost(int[][] costs){

    if(costs == null ||costs.length==0) return 0;
    int case1 = helper(costs,0,0,0);
    int case2 = helper(costs,0,1,0);
    int case3 = helper(costs,0,2,0);
    return Math.min(case1,Math.min(case2,case3));
}

    private static int helper(int[][] costs, int index, int color, int totalAmount) {
        //base
        if (index == costs.length) return totalAmount;

        //logic
        if (color == 0)
            return Math.min(helper(costs, index + 1, 1, totalAmount + costs[index][0]), helper(costs, index + 1, 2, totalAmount + costs[index][0]));
        else if (color==1) {
            return Math.min(helper(costs,index+1,0,totalAmount+costs[index][1]),helper(costs,index+1,2,totalAmount+costs[index][2]));

        }
        else return Math.min(helper(costs,index+1,0,totalAmount+costs[index][2]),helper(costs,index+1,1,totalAmount+costs[index][2]));

    }
*/

}
