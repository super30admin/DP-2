//Brute force way
class BruteForcePaintingThreeHouses {
    public int minCost(int[][] costs) {
        int case1 = helper(costs,0,0,0); 
        int case2 = helper(costs,0,0,1);
        int case3 = helper(costs,0,0,2);
        return Math.min(case1,Math.min(case2,case3));
    }
    
    //things to take care
    private int helper(int costs[][],int min,int houseRow,int lastColrChoosen){
        //base 
        if(houseRow == costs.length ) return min; //terminate recursion 
        
        //logic
        int case1 =Integer.MAX_VALUE;
        int case2 =Integer.MAX_VALUE;
        int case3 =Integer.MAX_VALUE;
        
        if(lastColrChoosen == 0){
            case1 = Math.min( 
            helper(costs,min + costs[houseRow][1],houseRow+1,1),
            helper(costs,min + costs[houseRow][2],houseRow+1,2));
        }
        if(lastColrChoosen == 1){
             case2 = Math.min(
            helper(costs,min + costs[houseRow][0],houseRow + 1,0),
            helper(costs,min + costs[houseRow][2],houseRow + 1,2)    
            );           
        }
         if(lastColrChoosen == 2){
             case3 = Math.min(
            helper(costs,min + costs[houseRow][0],houseRow + 1,0),
            helper(costs,min +costs[houseRow][1],houseRow + 1,1)    
            );           
        }
        return Math.min(case1,Math.min(case2,case3));    
    }
        
}

/*
TimeComplexity O(m x pow(2,n))  here m is no of colors and n is no of houses ie O(3 x pow(2,n)) 
SpaceCompexity O(m x n) recusrive stack space used ie O(3n)
*/