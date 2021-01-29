package S30.DP2;

/* Successfully executed on leetcode
 *  Time complexity: Since two for loops are used to iterate over cost matrix, TC will be O(n*m)
 *                     Where n is number if houses to paint, m is total colors
 *  Space Complexity: We are just changing given cost matrix so no extra space is used. O(1)
 *
 * Approach: start from second house and for every house, for every color
  *             calculate min using alternate colors possible to paint house before it.
  *             At every iteration we have minimum cost to paint houses
 * */

public class PaintHouse {
    public static void main(String args[]){
        int[][] costMatrix = {{7,6,2}};
        System.out.print(minCost(costMatrix));
    }

    public static int minCost(int[][] costMatrix) {
        if(costMatrix.length == 0)
            return 0;
        for(int i=1; i<costMatrix.length ; i++){
            for(int j=0; j<costMatrix[i].length; j++){
                if(j==0){
                    costMatrix[i][j] = costMatrix[i][j]+ Math.min(costMatrix[i-1][1],costMatrix[i-1][2]);
                }
                if(j==1){
                    costMatrix[i][j] = costMatrix[i][j]+ Math.min(costMatrix[i-1][0],costMatrix[i-1][2]);
                }
                if(j==2){
                    costMatrix[i][j] = costMatrix[i][j]+ Math.min(costMatrix[i-1][1],costMatrix[i-1][0]);
                }

            }
        }
        return Math.min(costMatrix[costMatrix.length-1][0], Math.min(costMatrix[costMatrix.length-1][1]
        , costMatrix[costMatrix.length-1][2]));
    }
}
