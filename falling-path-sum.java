//Time complexity O(N*N)
//Space complexity O(1)
//Ran the code in Leetcode and was accepted
class Solution {
    public int minFallingPathSum(int[][] a) {
        for(int i=a.length-2;i>=0;i--)
        {
            for (int j=0;j<a[0].length;j++)
            {
                //find min for that index
                int min = a[i+1][j];
                if(j>0)
                {
                    min = Math.min(min,a[i+1][j-1]);
                }
                if(j<a[0].length-1) min =Math.min(min,a[i+1][j+1]);
                a[i][j] = a[i][j]+min;
            }
        }
        int min = a[0][0];
        for(int i=0;i<a[0].length;i++)
        {
            if(a[0][i]<min) min =a[0][i];
        }
        return min;
    }
}

