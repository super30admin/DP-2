package s30.dp.dp2;



public class PaintHouse {


    private int[][] costs;
    private int[][] dp;


    //DP soln
    //TC: O(n)
    //SC: O(1)
    public int minCostDP(int[][] costs) {

        int n = costs.length;

        for(int i=1; i < n; i++ ){

            for(int j=0; j < 3; j++){
                costs[i][j] += Math.min(costs[i-1][(j+1) % 3]  , costs[i-1][(j+2) % 3]);
            }
        }

        return Math.min(costs[n-1][0],
                Math.min(costs[n-1][1], costs[n-1][2])
        );

    }


    //Memoization
    //TC: O(n)
    //SC: O(n)
    public int minCost(int[][] costs) {

        this.dp = new int[costs.length][costs[0].length];
        this.costs = costs;

        return Math.min(minCost(0, 0),
                Math.min(minCost(0,1),minCost(0,2))
        );

    }

    private int minCost(int index , int cIndex){

        //base
        if(index == costs.length) return 0;


        //recurse

        int min = Integer.MAX_VALUE;

        if(dp[index][cIndex] == 0){


            for(int i=0; i < 3; i++){

                if(cIndex!= i){

                    int sum = costs[index][i] + minCost(index+1, i);
                    min= Math.min(min, sum);
                }

            }


            dp[index][cIndex] = min;
        }



        return dp[index][cIndex];
    }




    public static void main(String[] args) {

    }
}
