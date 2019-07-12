package com;

//Time complexity of this function: O(n)
//Space Complexity of this function: O(1) 

//Did this code successfully run on Leetcode : no
//Any problem you faced while coding this: yes currently this solution giving arrayidex out of bound exception--solved by correcting syntax of input array
 class PaintHouseFunction{
	
	public static int minCost(int[][] costs) {
		 if(costs==null||costs.length==0)
		        return 0;
		 //here i as houses from 1 to costs.length and columns are 3 refer to three different  colours e.g 0= red, 1= blue and 2 = green
		    for(int i=1; i<=costs.length-1; i++){
		        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]); // choose red colour for house i and select minimum value between green and blue from privious house (i-1) 
		        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]); // choose blue colour for house i and select minimum value between red and green from privious house (i-1) 
		        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]); // choose green colour for house i and select minimum value between red and blue from privious house (i-1)
		    }
		 
		    int m = costs.length-1; // select last house or row
		    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]); //select minimum column value from last row  
    }
}
public class PaintHouse {	
	// Driver Function to test above function 
    public static void main(String args[]) 
    { 
    	int arr[][]=new int[][]{{1,2,3},{2,4,5},{4,4,5}}; 
       int result= PaintHouseFunction.minCost(arr);
        System.out.println("min cost require to paint house is="+result); 
    }

}
