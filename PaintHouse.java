// Time Complexity :O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


public class PaintHouse {

    public static int getMinimumPrice(int[][] cost) {
        int price = 0;
        int a=0;
        for (int i = 1; i < cost.length; i++) {
            for(int j=0;j<3;j++){
                a = Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                     
                    if(k!=j){
                        if(cost[i-1][k]<a)
                            a = cost[i-1][k];
                    
                    }
                } cost[i][j] += a;
               
            }
             System.out.println(cost[i][0]+" "+cost[i][1]+" "+cost[i][2]+"\n");
        }

        price = Math.min(Math.min(cost[cost.length - 1][0], cost[cost.length - 1][1]), cost[cost.length - 1][2]);
        return price;
    }

    public static void main(String args[]) {
        int[][] cost = {
                {17, 32, 1}, {16, 2, 31}, {3, 33, 19}, {3, 1, 8}
        };
        int minCost = getMinimumPrice(cost);
        System.out.println(minCost);


    }
}