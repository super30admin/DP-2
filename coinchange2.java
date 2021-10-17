//TC:O(mn)
//SC:O(mn)
//successfully ran on leetcode

class Solution
{
    public int change(int amount, int[] coins)
    {
        //number of rows
        int n=coins.length+1;
        //number of columns
        int m=amount+1;

        //dp matrix
        int[][] table=new int[n][m];

        //first row 0
        for(int i=1;i<m;i++)
        {
            table[0][i]=0;
        }

        //first column 1
        for(int i=0;i<n;i++)
        {
            table[i][0]=1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                //if amount less than coin value is 1
                if(j<coins[i-1])
                {
                    table[i][j]=table[i-1][j];
                }
                //dp function
                else
                {
                    table[i][j]=table[i][j-coins[i-1]]+table[i-1][j];
                }
            }
        }
        //answer
        return table[n-1][m-1];
    }
}
