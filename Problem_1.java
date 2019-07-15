/*
Time Complexity :O(mn)
Space Complexity : O(n)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Implemented as explained in class.
*/

class paintHouse{
    static int minCost(int[][] costs){
        if(costs==null || costs.length==0)
        {
            return 0;
        }

        for(int i=1; i<costs.length; i++)
        {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        int m = costs.length - 1;
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }

    public static void main(String[] args)
    {
        int[][] arr = new int[][]{{2,3,1},{3,5,3},{7,100,101},{3,400,500}};
        System.out.print(minCost(arr));
    }
}