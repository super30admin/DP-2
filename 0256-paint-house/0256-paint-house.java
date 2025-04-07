// /*
// *Approach:
// -We are given a 2D array 'costs' where costs[i][j] represents the cost of painting house 'i' with color 'j'.
// (j = 0 -> red, 1 -> green, 2 -> blue )
// -The constraint is that no two adjacent houses can have the same color.

// -This solution uses top-down recursion:
//     1. For each house, try painting it with each of the other colors.
//     2. Recursively compute the minimum cost of painting the remaining houses,
//         making sure the next house doesnt get the same color.
//     3. Return the minimum total cost from all three options starting at the first house.

// -

//  */

// /**
// Steps:
// 1. Store the input costs matrix as a class-level variable
// 2. Public method that starts the recursive process.
// 3. Edge case: If there are no houses, cost is 0.
// 4. Save the costs matrix for access in the recursive Function
// 5. Start from house 0, trying painting with red (0), green(1), and blue(2)
// 6. Start with Red.
// 7. Compare with green and Blue
// 8. Recursive helper function to compute min cost to paint from house 'n' using color 'color'
// 9. Base cost of painting current house with given Color
// 10. If its not the last house, we need to paint the next one with a different Color
// 11. if current is red, next can be green or blue 
// 12. if current is green, next can be red or blue 
// 13. if current is blue, next can be red or green
// 14. Return the total cost for this coloring choice.






//  */




// class Solution {

//     private int[][] costs;

//     public int minCost(int[][] costs) {
//         if (costs.length == 0){
//             return 0;
//         }

//         this.costs = costs;

//         return Math.min(paintCost(0,0), Math.min(paintCost(0,1), paintCost(0,2)));
//     }

//     private int paintCost(int n, int color){
//         int totalCost = costs[n][color];

//         if(n<costs.length - 1){
//             if (color == 0){
//                 totalCost += Math.min(paintCost(n+1,1), paintCost(n+1,2));
//             } else if (color == 1){ 
//                 totalCost += Math.min(paintCost(n+1,0), paintCost(n+1,2));
//             } else {
//                 totalCost += Math.min(paintCost(n+1,0), paintCost(n+1,1));
//             }

//         }
        

//         return totalCost;
//     }
        
    
// }

// /*
// *Time Complexity: O(3^n):
// -For each house, we make two recursive calls (excluding the color just used).
// -So the total number of calls is exponential - roughly 3* 2^(n-1), which simplifies to O(3^n)
// -No memoization is used, so subproblems are recomputed.

// Space Complexity: O(n):
// - The maximum depth of the recursion stack is equal to the number of houses (n).
// - No additional space is used apart from the recursion stack.

//  */

/*
Approach#2:
-This solution uses a top down dynamic programing with memoization to avoid recomputation.
- For each house, we choose one of the three colors and recursively calculate the minimum cost
of painting the remaining houses while respecting the color constraint.
-We store the result of each subproblem '(houseIndex, color)' in a HashMap to reuse later.

*/

/*
Steps:
1. Class-level variables to store cost matrix and momoization cache
2. Edge case: if there are no houses
3. Initialize class variables
4. Try all 3 color choices for the first house and return the minimum total cost
5. Start with Red or Green or Blue
6. Recursive function to compute the minimum cost of painting from house 'n' using color 'color'.
7. Step 1: Check memo to see if we have already solved this subproblem
8. Step2: Base cost of painting current house with chosen color
9. Step3: If not last house, recursively compute cost for next house using different colors
10. Step4: Cache the computed result for this (house, color) pair
11. Step5: Return the total cost
12. Utility function to generate a unique key for memoization.
*/

 class Solution{

    public int[][] costs;
    public Map<String, Integer> memo;

    public int minCost(int[][] costs){
        if (costs.length == 0){
            return 0;
        }

        this.costs = costs;
        this.memo = new HashMap<>();

        return Math.min(
            paintCost(0,0),
            Math.min(paintCost(0,1), paintCost(0,2))
        );

    }

    private int paintCost(int n, int color){
        String key = getKey(n, color);

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int totalCost = costs[n][color];


        if (n < costs.length - 1){
            if(color == 0){
                totalCost += Math.min(paintCost(n+1,1), paintCost(n+1,2));
            } else if (color == 1){
                totalCost += Math.min(paintCost(n+1,0), paintCost(n+1,2));
            } else{
                totalCost += Math.min(paintCost(n+1,0), paintCost(n+1,1));
            }
        }

        memo.put(key, totalCost);

        return totalCost;
    }

    private String getKey(int n, int color){
        return n + " " + color;
    }

 }

 /**
 Time Complexity: O(n)
 -For each house (n), we compute the resuklt for each of the 3 colors.
 -Since we memoize results, we only compute each (house, color) pair once -> 3*n = o(n)


 Space Complexity: O(n)
 -HashMap stores up to 3n entries(1 for each house/color combo)
 -Call stack depth is O(n) due to recursion (one level per house)
 
  */