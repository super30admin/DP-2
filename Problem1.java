    //Approach of this question is to start adding the subsequent min values of above roe to the current row. In the end find the min of last row.
    //Time- O(n*m)- space complexity-O(1)
    class Housepaint
    {
        public int mincost(int [][] matrix)
        {
            int n= matrix.length-1;
            
            for(int i=1;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                 {
                     matrix[i][j]+= arraymin(matrix[i-1],j);
                 }
            }
            return arraymin(matrix[n], -1);
        }

        public int arraymin(int [] arr, int j)
        {   int min=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++)
                {
                    if(i!=j && min>arr[i])
                        min=arr[i];
                }
            return min;
        }   
    public static void main(String args[])
             {
            int[][] matrix= new int[][]{{17,2,17,4},{16,3,1,17},{90,90,1,2}};
            Housepaint obj= new Housepaint();
            System.out.println("cost is :"+ obj.mincost(matrix));
            
             }
    }