class Solution {
    public int minCost(int[][] A) {
    if( A.length==0)
        return 0;
    for(int i=A.length-2; i>=0; i--){
            for(int j=0; j<A[0].length; j++){
                System.out.println(i+" "+j);
                    A[i][j] = Math.min(A[i+1][(j+2)%A[0].length], A[i+1][(j+1)%A[0].length])+A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A[0].length;i++){
            if(min>A[0][i])
                min = A[0][i];
        }
        return min;
    }
}

//Time complexity : O(m*n) m-number of rows and n is number of columns in input
//Space complexity : O(1)
