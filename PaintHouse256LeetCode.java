//time complexity : O(n) n=number of houses
//space complexity ; O(1)
//I don't face any problems
//runs successfully on leetcode

class PaintHouse256LeetCode
{
    //Bottom Up Approach
    public int minCost(int[][] costs)
    {
        int[] prev= costs[0];

        for(int i=1; i<costs.length; i++){

            int[] current = new int[costs[0].length];
            for(int j=0; j<current.length; j++){

                int min = Integer.MAX_VALUE;
                for(int k=0; k<prev.length; k++){
                    if(k!=j){
                        min = Math.min(min, prev[k]);
                    }
                }
                current[j] = costs[i][j] + min;
            }
            prev = current;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }


    // Top Down Approach
//    public int minCost(int[][] costs)
//    {
//        int minRed = costs[0][0] + minCost(costs, 1, 0);
//        int minGreen = costs[0][1] + minCost(costs, 1, 1);
//        int minBlue = costs[0][2] + minCost(costs, 1, 2);
//
//        return Math.min(
//                minRed,
//                Math.min(
//                        minGreen,
//                        minBlue
//                )
//        );
//    }
//    // RED = 0
//    // GREEN = 1
//    // BLUE = 2
//    private int minCost(int[][] costs, int index, int prevColor)
//    {
//        if(index == costs.length)
//            return 0;
//
//        int min = Integer.MAX_VALUE;
//
//        for(int i=0; i<3; i++)
//        {
//            if(i != prevColor)
//            {
//                min = Math.min(min, costs[index][i] + minCost(costs, index+1, i) ) ;
//            }
//        }
//        return min;
//    }
}