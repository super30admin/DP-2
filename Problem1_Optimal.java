 
/**
LeetCode Submitted : NA (Not from Leetcode)
Space Complexity : O(1)
Time Complexity : O(N)
 
At each level of decision tree three choices need to be made either paint house RED,GREEN or BLUE. Thus, accordingly select next set of houses with different colors. Repeat this for all the houses. Now instead of recursively calling each overlapping sub-problems we store these values in a 3 variables storing max cost if painted house with that color
**/
 
class Main {
 public static void main(String[] args) {
   int size = 3;
   int[][] hcost = new int[size][3];
  
 for(int i =0;i<size;i++){
     hcost[i][0] = (int) (Math.random()*9) + 1;
     hcost[i][1] = (int) (Math.random()*9) + 1;
     hcost[i][2] = (int) (Math.random()*9) + 1;
 }
 
 /*hcost[0][0] = 1;
 hcost[0][1] = 2;
 hcost[0][2] = 3;
 
 hcost[1][0] = 3;
 hcost[1][1] = 5;
 hcost[1][2] = 2;
 
 hcost[2][0] = 2;
 hcost[2][1] = 4;
 hcost[2][2] = 9;*/
 
  for(int i=0; i< size; i++){
    System.out.println(hcost[i][0]);
    System.out.println(hcost[i][1]);
    System.out.println(hcost[i][2]);
  }
 
 System.out.println("----------------------");
 /*int[][] cost_matrix = new int[size][3];
 cost_matrix[0][0] = hcost[0][0];  //color red cost at house 0
 cost_matrix[0][1] = hcost[0][1]; //color green cost at house 0
 cost_matrix[0][2] = hcost[0][2];  //color blue cost at house 0*/
 
 int red = hcost[0][0];
 int green = hcost[0][1];
 int blue = hcost[0][2];
 for(int i = 1; i< size; i++){    
     int temp = red;
     red = hcost[i][0] + Math.max(green,blue);
     //cost_matrix[i][0] = hcost[i][0] + Math.max(cost_matrix[i-1][1],cost_matrix[i-1][2]); //choosing RED color
     //cost_matrix[i][1] = hcost[i][1] + Math.max(cost_matrix[i-1][0],cost_matrix[i-1][2]); //choosing GREEN color
     int temp1 = green;
     green = hcost[i][1] + Math.max(temp,blue);
     //cost_matrix[i][2] = hcost[i][2] + Math.max(cost_matrix[i-1][0],cost_matrix[i-1][1]); //choosing BLUE color
    
     blue = hcost[i][2] + Math.max(temp,temp1);
 
 }
  //int max =  Math.max(cost_matrix[size-1][0],Math.max(cost_matrix[size-1][1],cost_matrix[size-1][2]));
 
 int max = Math.max(red,Math.max(green,blue));
 System.out.println("Maximum cost of Painting the houses = " + max);
 
 
 
 
 
 }
}
