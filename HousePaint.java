// Time Complexity : O(mn)  m=number of rows n=number of columns
// Space Complexity :O(1)   i am taking array as input and altering the same array so no extra space used.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


public class HousePaint {
	public static int paint(int[][] arr)
	{
		int length=arr.length;
	if(length==0) {return -1;}	
		
	for(int i=arr[0].length-2;i>=0;i--)
	{
		arr[i][0]+=Math.min(arr[i+1][1],arr[i+1][2]);
		arr[i][1]+=Math.min(arr[i+1][2],arr[i+1][0]);
		arr[i][2]+=Math.min(arr[i+1][1],arr[i+1][0]);
	}
		
		return Math.min(arr[0][0], Math.min(arr[0][1], arr[0][2]));
		
	}
	
	public static void main(String args[])
	{
		int [][] arr= {{1,2,3},{4,5,6},{5,8,1}};
		
		System.out.print(paint(arr));
	}

}
