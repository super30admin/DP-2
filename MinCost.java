import java.util.*;

// time complexity -> o(3)
//space complexity -> 0(1)

class MinCost {
    public static int minCost(int arr[][]){
        if(arr==null || arr.length==0){
            return 0;
        }
      for(int i=1;i<arr.length;i++){
          arr[i][0]+=Math.min(arr[i-1][1],arr[i-1][2]);
          arr[i][1]+=Math.min(arr[i-1][0],arr[i-1][2]);
          arr[i][2]+=Math.min(arr[i-1][0],arr[i-1][1]);
      }
      
      return Math.min(Math.min(arr[arr.length-1][0],arr[arr.length-1][1]),arr[arr.length-1][2]);
    }
  
	public static void main (String[] args) {
	  int arr[][] = {{2,3,1},{3,5,3},{7,100,101},{3,400,500}};
		System.out.println(minCost(arr));
		
	}