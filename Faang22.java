// Time Complexity : O(n)
// Space Complexity : O(1)

package leetcode;

public class Faang22{
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int lastRow = costs.length - 1;
        int prevB = costs[lastRow][0];
        int prevG = costs[lastRow][1];
        int prevR = costs[lastRow][2];
        for (int i = costs.length - 2; i >= 0; i--) {
                int tempB=prevB;
                int tempG=prevG;
                prevB = costs[i][0]+Math.min(prevG,prevR);
                prevG = costs[i][1]+Math.min(prevR,tempB);
                prevR = costs[i][2]+Math.min(tempB,tempG);

            }
        return Math.min(prevG,Math.min(prevB,prevR));
    }


    public static void main(String[] args) {
        int[][] costs ={{17,2,11}, {34,5,19},{6,3,13}};
        Faang22 obj=new Faang22();
        System.out.println(obj.minCost(costs));
    }
}
