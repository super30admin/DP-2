
class Solution {
    //brute force
public int change(int amount, int[] coins) {
   

//null case     
  if (coins == null || coins.length == 0) {
       return 0;
   }
   
   
return helper(coins, amount, 0);
   
}

public int helper(int[] coins, int amount, int index){
   
if(amount == 0) { //valid path //edge case
       return 1;
   }           
   
if(index>=coins.length || amount<0) return 0; //invalid path //edge case
   
       //choose
   
   int min1= helper(coins, amount-coins[index], index);
       
       //or not choose
       int min2= helper(coins, amount, index+1);
   if(min1==0) return min2;
   else if(min2==0) return min1;

   
   else return min1+min2;
}
}