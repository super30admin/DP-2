//TC: O(M*N)
//SC: O(1)

class Solution
{
    public int minCost(int [][] costs)
    {
        int[] prev = costs[0];
        for (int i =1 ; i< costs.length; ++i)
        {
            int[] curr = new int[3];
            //RED
            curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);

            //GREEN
            curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);


            //BLUE
            curr[2] = costs[i][2] + Math.min(prev[0], prev[2]);

            prev = curr;
        }

        return Math.min(
                prev[0],
                Math.min(prev[1], prev[2])
        );
    }
}