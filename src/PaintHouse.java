//                           Top-Down               Bottom-Up
// Time Complexity:           O(c^n)                O((c^2)*n)
// Space Complexity:           O(n)                   O(1)
// where c is number of colors and n is number of houses
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

public class PaintHouse
{
    public static void main(String[] args) {
        // RED = 0
        // GREEN = 1
        // BLUE = 2
        int[][] ques = {{7,6,8},{15,10,7},{20,30,1}};
        Paint p = new Paint();
        System.out.println("Minimum cost: "+p.minCost(ques));
    }
}

class Paint
{
    public int minCost(int[][] costs)
    {

        int[] ans = new int[costs[0].length];
        for(int i=0; i<ans.length; i++)
        {
            ans[i] = costs[0][i] + minCost(costs, 1, i);          // Finding minimum cost for all recursive calls
        }
        int minVal = ans[0];                                            // Getting minimum amount at the end
        for(int i : ans)
            minVal = Math.min(i, minVal);

        return minVal;

// ***************************** Bottom-Up Approach *****************************
//        int[] prev = costs[0];
//        for(int i=1; i<costs.length; i++)
//        {
//            int[] cur = costs[i];
//            for(int j=0; j<costs[0].length; j++)
//            {
//                int min = Integer.MAX_VALUE;
//                for(int k=0; k<costs[0].length; k++)
//                {
//                    if(k != j)                                        // Not considering previous color for current house
//                    {
//                        min = Math.min(min,prev[k]);
//                    }
//                }
//                cur[j] = min + cur[j];                                // Finding minimum cost up to current house
//            }
//            prev = cur ;
//        }
//
//        int minVal = prev[0];                                         // Getting minimum amount at the end
//        for(int cost : prev)
//            minVal = Math.min(cost,minVal) ;
//
//        return minVal;
    }

    private int minCost(int[][] costs, int index, int prevColor)
    {
        if(index == costs.length)
            return 0;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<costs[0].length; i++)
        {
            if(i != prevColor)                                                                  // Not considering previous color for current house
                min = Math.min(min,costs[index][i] + minCost(costs, index+1, i));
        }
        return min;
    }
}