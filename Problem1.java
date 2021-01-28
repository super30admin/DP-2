    //The approach to this question is finding the minimum in each row.
    //if the minimum does collide with same column of previous minimum we add second minimum else we add the same minimum.
    //This will not run for many cases but I could not come up with any other solution.
    class Housepaint
    {
        public int mincost(int [][] matrix)
        {
            int sum=0;
            int prev_index=-1;
            for(int i=0;i<matrix.length;i++)
            {
                int[] index=min(matrix[i]);
                if(index[0]== prev_index){
                    sum+=matrix[i][index[1]];
                    prev_index=index[1];
                }
                else{
                    sum+=matrix[i][index[0]];
                    prev_index=index[0];
                }
                System.out.println("previos index is:"+prev_index);
            }
            return sum;
        }
    public int[] min(int[] arr)
    {
        int min=arr[0];
        int index1=0;
        int index2=0;
        int min2=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min2=min;
                min=arr[i];
                index1=i;
                break;
            }
                if(min2>arr[i]){
                    min2=arr[i];
                    index2=i;
                }
               
        }
        
        int[] ans= new int[]{index1,index2};
        return ans;
    }
    public static void main(String args[])
    {
            int[][] matrix= new int[][]{{17,2,17},{16,5,16},{14,3,19}};
            Housepaint obj= new Housepaint();
            System.out.println("cost is :"+ obj.mincost(matrix));
            
    }
    }