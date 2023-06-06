package DP2;

import java.util.Scanner;

//Paint house 
/**
 * 
 * We create a new matrix and store the minimum cost associated with selecting each element.
 * The min value in the last row will give us the  minimum cost for painting all houses.
 * 
 * Time Complexity :
 * O(n), where n is the number of rows in given matrix(ie no of houses)
 * 
 * Space Complexity :
 * O(1)
 * 
 * Did this code successfully run on Leetcode : No as it was a premium question, I could not execute
 * 
 * Any problem you faced while coding this : No
 */

public class Problem1 {
	
	private int paintHouse(int arr[][]) {
		
		int rows=arr.length;
        int [][]dp = new int[rows][3];
        
        int costR=arr[rows-1][0];
        int costB=arr[rows-1][1];
        int costG=arr[rows-1][2];
        
        for(int i=rows-2;i>=0;i--){
            int tempR=costR;
            costR= arr[i][0]+Math.min(costB, costG);
            int tempB=costB;
            costB= arr[i][1]+Math.min(tempR, costG);
            costG= arr[i][2]+Math.min(tempR, tempB);

       }
       
       return( Math.min(costR, Math.min(costB,costG)));

    }

	
	
    public static void main(String[] args) throws Exception {
        
        //taking input
        
        Scanner scn=new Scanner(System.in);
        
        int rows=scn.nextInt();
        
        int arr[][]= new int[rows][3];
        
        for(int i=0;i<rows;i++){
            arr[i][0]=scn.nextInt();
            arr[i][1]=scn.nextInt();
            arr[i][2]=scn.nextInt();

        }
        
        Problem1 p1=new Problem1();
        
        System.out.println(p1.paintHouse(arr));
    }
        
}
