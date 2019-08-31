
/* Problem Statement: 
Locked LeetCode Problem: Couldn't verify on that platform
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Follow Up: Optimize for Space

 * Best Solution : DYNAMIC PROGRAMMING (save space by overwriting the original array)
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define NUM_OF_COLORS 3 /* RED, GREEN , BLUE */
#define INT_MAX 99999
#define MAX_HOUSES 20000

#define RED_IDX   0
#define GREEN_IDX 1
#define BLUE_IDX  2

/* Macro for calculating max value among 2 numbers */
#ifndef max
    #define max(a,b) ((a) > (b) ? (a) : (b))
#endif

/* Macro for calculating min value among 2 numbers */
#ifndef min
    #define min(a,b) ((a) > (b) ? (b) : (a))
#endif

/* This function takes 2D array and its length as input and performs the following
 * tasks
 *1. Validations for invalid input
 *2. For each house in the list, check for each colored house , find the minimum cost of its colored house
  * with every other color combination of previous house.
  * for eg :    house 1 : [17,2,17]
  *             house 2 : [16,16,5] --> house2 [minimum (16 + 2, 16 + 17), minimum (16 + 17, 16 + 17), min
  *                                                      (5 + 17), (5 + 2)]
                house 3 : [14,3,19] --> similarly for house 3 calculate it
  * 
  * The final answer will be the minimum of all the painted color option in the last house.
  *
 */

int find_min_cost_of_paint(int *cost_arr[], int num_of_houses) {
    int idx = 1, idx2 = 0;
    int sum_1;
    int sum_2;
    int min_cost = INT_MAX;

    /*  Validations */
    if (!num_of_houses) {
        printf("Number of houses are 0\n");
        return 0;
    }
    if (cost_arr == NULL) {
        printf("The input array is NULL\n");
        return 0;
    }

    /* Start from the */
    for (idx = 1; idx < num_of_houses; idx++) {

        for (idx2 = 0; idx2 < NUM_OF_COLORS; idx2++) {
            if (idx2 == RED_IDX) {
                /* min_1 : Combination with green */
                /* min_2 : Combination with blue */
                sum_1 = cost_arr[idx][idx2] + cost_arr[idx - 1][GREEN_IDX];
                sum_2 = cost_arr[idx][idx2] + cost_arr[idx - 1][BLUE_IDX];
            } else if (idx2 == GREEN_IDX) {
                /* min_1 : Combination with red */
                /* min_2 : Combination with blue */
                sum_1 = cost_arr[idx][idx2] + cost_arr[idx - 1][RED_IDX];
                sum_2 = cost_arr[idx][idx2] + cost_arr[idx - 1][BLUE_IDX];    
            } else if (idx2 == BLUE_IDX) {
                /* min_1 : Combination with red */
                /* min_2 : Combination with green */
                sum_1 = cost_arr[idx][idx2] + cost_arr[idx - 1][RED_IDX];
                sum_2 = cost_arr[idx][idx2] + cost_arr[idx - 1][GREEN_IDX]; 
            }
            /* Find minimum of the two and update in the original array */
            cost_arr[idx][idx2] = min(sum_1, sum_2);

        } /* end of inner for loop */

    } /* end of outer for loop*/

    /* Find the final min cost by checking the last house values */
    min_cost = min(cost_arr[idx - 1][RED_IDX], cost_arr[idx - 1][GREEN_IDX]);
    min_cost = min(min_cost, cost_arr[idx - 1][BLUE_IDX]);

    return min_cost;
}

int main(int argc, char *argv[]) {
    int *cost_arr[MAX_HOUSES] = {NULL};

    int idx = 0;

    /* For testing input array is not taken from user input */
    for (idx = 0; idx < 3; idx++) { 
        cost_arr[idx] = (int *)malloc(3*sizeof(int));
        if (cost_arr[idx] == NULL) {
            printf("Memory allocation failed for idx : %d\n", idx);
            return -1;
        }
    }
    cost_arr[0][0] = 17;
    cost_arr[0][1] = 2;
    cost_arr[0][2] = 17;

    cost_arr[1][0] = 16;
    cost_arr[1][1] = 16;
    cost_arr[1][2] = 5;

    cost_arr[2][0] = 14;
    cost_arr[2][1] = 3;
    cost_arr[2][2] = 19;
    /* Execute the dynamic programming solution for best results */
    printf("Min cost of painting houses is : %d\n", find_min_cost_of_paint(cost_arr,3));
    /* Free memory  */
    for (idx = 0; idx < 3; idx++) { 
        free(cost_arr[idx]);
    }    
    return 0;
}
