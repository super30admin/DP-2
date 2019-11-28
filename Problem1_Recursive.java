 
/**
LeetCode Submitted : NA (Not from Leetcode)
Space Complexity : O(2^N)
Time Complexity : O(2^N)

At each level of decision tree three choices need to be made either paint house RED,GREEN or BLUE. Thus, accordingly select next set of houses with different colors. Repeat this for all the houses
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
  int[] col = {1,2,3};
 
  int hmax = 0;
  int out1 = decision(hcost,0,col,hmax,0);
  int out2 = decision(hcost,0,col,hmax,1);
  int out3 = decision(hcost,0,col,hmax,2);
  System.out.println("Max Painted House Cost = ");
  System.out.println(Math.max(out1,Math.max(out2,out3)));

  //Math.min(decision(hcost,0,col[0],hmax,0),Math.min(
  //decision(hcost,0,col[1],hmax,1),
  //decision(hcost,0,col[2],hmax,2)));

}
public static int decision(int[][] hcost,int hnum, int[] col,int hmax,int colpick){
   int first = 0;
   int second = 0;
   int third = 0;

  if(hnum>= hcost.length)
      return hmax;
   if(colpick == 0){
    second = decision(hcost,hnum + 1,col,hmax+hcost[hnum][0],1);
    third = decision(hcost,hnum + 1,col,hmax+hcost[hnum][0],2);
  }else if(colpick == 1){
    third = decision(hcost,hnum + 1,col,hmax+hcost[hnum][1],2);
    first = decision(hcost,hnum + 1,col,hmax+hcost[hnum][1],0);
  }else if(colpick == 2){
    first = decision(hcost,hnum + 1,col,hmax+hcost[hnum][2],0);
    second = decision(hcost,hnum + 1,col,hmax+hcost[hnum][2],1);
  }
  /*else{
    first = decision(hcost,hnum,col,hmax,0);
  }*/

  return Math.max(first,Math.max(second,third)); 


}
}
 
 
