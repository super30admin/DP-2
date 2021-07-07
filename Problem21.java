public class Solution{
     public  int lowestCost(int[][] matrix){
          return func(matrix,matrix.length-1,0,0,new int[matrix.length][3]);  
       }
       
       public  int func(int[][] matrix,int n, int k, int clr,int[][] map){
           if(map[k][clr]!=0) return map[k][clr]; //comment this for recursive solution
           if(n==0) return Math.min(Math.min(matrix[0][0],matrix[0][1]),matrix[0][2]);
           if(k==n) {
               map[k][clr]= matrix[k][clr];
               return matrix[k][clr];
           }
           int red=matrix[k][0] + Math.min(func(matrix,n,k+1,1,map),func(matrix,n,k+1,2,map));
           int blue=matrix[k][1] + Math.min(func(matrix,n,k+1,2,map),func(matrix,n,k+1,0,map));
           int green=matrix[k][2] + Math.min(func(matrix,n,k+1,1,map),func(matrix,n,k+1,0,map));
           map[k][0]= red;  //comment this for recursive solution
           map[k][1]= blue; //comment this for recursive solution
           map[k][2]= green; //comment this for recursive solution
           return Math.min(Math.min(red,blue),green);
       }
}
