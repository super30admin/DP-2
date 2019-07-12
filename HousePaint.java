package day8;

//Time Complexity : O(n) where n is the length of house array
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : can't try because the question was locked
//Any problem you faced while coding this : This solution is understandable but it is returning hash value


//Your code here along with comments explaining your approach

public class HousePaint {
	public static int minCost(int[][] costs) {
	    if(costs==null||costs.length==0)
	        return 0;
	    // this can be considered as a brute force solution where we are taking a house, 
	    // painting it with a color, and adding its cost to the minimum cost among painting previous
	    // house with either of the two remaining colors.
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
	    }
	 
	    int m = costs.length-1;
	    // finally we will get the minimum costs of painting all the houses combined 
	    // by taking one color first at a time 
	    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}
	
	public static void main(String[] args) {
		int arr[][] = new int[3][4];
		System.out.println(arr);
	}
}
