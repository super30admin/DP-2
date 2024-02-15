// With Dp memoization
//Solution: Draw the tree structure, each house is independent of houses other than the next house(adjacent house), so the problem can be divided into  repeated sub problems with the state being house no. 'n' and 'color'. that can be memoized.
// TC: O(3*N) that is the max becuase each house can't have more than 3 choices and each choice is added to the hashMap once it is reached, the other time it is just called but not calculated.
// SC: O(3*N) - HashMap , every house has three entries in hashmap

class Solution {

    private int[][] costs;
    private Map<String,Integer> hashmap ;

    public int minCost(int[][] costs) {
        if(costs.length ==0) return 0;
        this.costs = costs;
        this.hashmap = new HashMap<>();
        return Math.min(helper(0,0),Math.min(helper(0,1),helper(0,2)));
    }
    private String getKey(int n , int color){
        return String.valueOf(n) + " " + String.valueOf(color);
    }
    private int helper(int n, int color){
        if(hashmap.containsKey(getKey(n,color))) return hashmap.get(getKey(n,color));
        int totalcost = costs[n][color];
        if(n == costs.length - 1) {

        }
        else if(color==0){
            totalcost += Math.min(helper(n+1,1),helper(n+1,2));
        }
        else if(color ==1)
        {
            totalcost += Math.min(helper(n+1,0),helper(n+1,2));
        }
        else if(color == 2)
        {
            totalcost += Math.min(helper(n+1,0),helper(n+1,1));

        }
        hashmap.put(getKey(n,color),totalcost);
        return totalcost;
    }
} 