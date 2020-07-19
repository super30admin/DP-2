// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP technique


// Your code here along with comments explaining your approach

class PaintHouse
{
    public static void main(String args[]) {
        
        int[][] input =  {{17,2,17},
                        {16,16,5},
                        {14,3,19}} ;

            System.out.println(minCost(input));
    }

    private static int minCost(int[][] input)
    {
        if(input==null || input.length==0)
            return 0;

            int n=input.length-1;

            /*

            {{17,2,17},
            {16,16,5},
            {14,3,19}} 
            
            */

            for(int i=1;i<input.length;i++)
            {
                input[i][0]+=Math.min(input[i-1][1],input[i-1][2]);
                input[i][1]+=Math.min(input[i-1][0],input[i-1][2]); 
                input[i][2]+=Math.min(input[i-1][1],input[i-1][0]); 
            }

            return Math.min(Math.min(input[n][0], input[n][1]), input[n][2]);
    }

}