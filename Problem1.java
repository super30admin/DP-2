// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :- No
class Problem1 {
    public int paint(int[][] matrix) {
        int m = matrix.length;
        int case1,case2,ans = Integer.MAX_VALUE;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0)
                    matrix[i][j] += Math.min(matrix[i-1][j+1],matrix[i-1][j+1]); 
                else if(j==1)
                    matrix[i][j] += Math.min(matrix[i-1][j+1],matrix[i-1][j-1]);
                else
                    matrix[i][j] += Math.min(matrix[i-1][j-1],matrix[i-1][j-2]);
                    }
        }
        for(int j = 0; j < 3; j++)
            ans = Math.min(ans,matrix[m-1][j]);
        return ans;

    }
    public static void main(String[] args){
        Problem1 ob1 = new Problem1();
        int[][] arr = {{17,2,17},{16,6,5},{14,3,19}};
        int ans = ob1.paint(arr);
        System.out.println("Answer is"+ans);
    }
}