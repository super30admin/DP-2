


//Time complexity of this function: O(n)
//Space Complexity of this function: O(1) 

//Did this code successfully run on Leetcode : no
//Any problem you faced while coding this: yes currently this solution giving arrayidex out of bound exception
 class PaintHouseFunction{
	
	public static int minCost(int[][] costs) {
		 if(costs==null||costs.length==0)
		        return 0;
		 
		    for(int i=1; i<=costs.length-1; i++){
		        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
		        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
		        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		    }
		 
		    int m = costs.length-1;
		    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }
}
public class PaintHouse {	
	// Driver Function to test above function 
    public static void main(String args[]) 
    { 
    	int arr[][]={{1,2,3},{2,4,5},{4,4,5}}; 
       int result= PaintHouseFunction.minCost(arr);
        System.out.println("min cost require to paint house is="+result); 
    }

}
