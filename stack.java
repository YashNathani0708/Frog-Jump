package stack;

import java.util.*;

public class stack {
    // read two integers separated by space and output their product
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int N = scan.nextInt();
            int[] H = new int[N];
            int[] S = new int[N];

            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }

            stack F = new stack();
            int e = F.findPath(S, H, 0, 0);

            System.out.print(e + " ");
            for (int i = 0; i < N; ++i) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(S[i]);
            }
            System.out.println();
        }

        scan.close();
    }

    public int findPath(int[] S, int[] H, int currentRock, int energySum) {
        int N = H.length;

        if(N == 0) return 0; //if the array has no elements, return 0
        else if(N == 1) { //if the array has only one element, set the 0th index to 1, and return 0(no jump was made)
            S[0] = 1;
            return 0;
        } else if(N == 2) { //if the array has two elements, set the 0th and 1st indices to 1, return the energy jump from 0 to 1
            S[0] = S[1] = 1;
            return Math.abs(H[0] - H[1]);
        }

        //use a stack to keep track of the total energy
        Stack<Integer> energyStack = new Stack<>();
        energyStack.push(0);

        //set the first and last rocks to 1
        S[0] = S[N - 1] = 1;

        //handle the base cases
        if(currentRock == N - 1) { //the last rock is reached
            return 0;
        } else if(currentRock == N - 2) { //the second to last rock is reached
            return Math.abs(H[currentRock] - H[currentRock + 1]) + findPath(S, H, currentRock + 1, energySum);
        }

        //calculate the energy required for one-rock and two-rock jumps
        int oneRockHeightDiff = Math.abs(H[currentRock] - H[currentRock + 1]) + findPath(S, H, currentRock + 1, energySum);
        int twoRocksHeightDiff = Math.abs(H[currentRock] - H[currentRock + 2]) + findPath(S, H, currentRock + 2, energySum);

        //determine the next jump, update S accordingly
        S[currentRock] = 1; //applies to both one-rock and two-rock jumps
        if(oneRockHeightDiff < twoRocksHeightDiff) {
            S[currentRock + 1] = 1;
            energyStack.push(oneRockHeightDiff + energySum);
        } else {
            S[currentRock + 1] = 0;
            S[currentRock + 2] = 1;
            energyStack.push(twoRocksHeightDiff + energySum);
        }

        //calculate the total minimal energy stored in the stack
        while(!energyStack.isEmpty()) {
            energySum += energyStack.pop();
        }
        return energySum;
    }
}














//import java.util.Arrays;
//
//import java.util.Scanner;
//
//public class FrogA {
//	// read two integers separated by space and output their product
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//
//		do {
//
//			// Reading the input
//			int N = scan.nextInt();
//
//			int[] H = new int[N];
//			int[] S = new int[N];
//
//			for (int i = 0; i < N; ++i) {
//				H[i] = scan.nextInt();
//			}
//			Arrays.fill(S, -1);
//			// Calling the function that solves the problem
////			FrogA F = new FrogA();
//			int e = finSath(H.length-1,H,S);
//			
//			// writing the output
//			System.out.print(e + " ");
//			for (int i = 0; i < N; ++i) {
//				if (i > 0)
//					System.out.print(" ");
//				System.out.print(S[i]);
//			}
//			System.out.println();
//
//		} while (!scan.hasNext());
//		scan.close();
//
//	}
//
//	/*
//	 * Need to implement your solution in the finSath function as specified in the
//	 * problem specifications.
//	 * 
//	 * In this file you are allowed to:
//	 * 
//	 * change the body of the finSath function (i.e. the implementation) the
//	 * signature of the function change the signature of the finSath function in
//	 * any way you want You are allowed to minimally change the main function - only
//	 * the lilne where the function call to finSath is done in order for the
//	 * program to compile You can add any variable to the class of any size, but not
//	 * new methods.
//	 * 
//	 * 
//	 */
//		static int finSath(int index, int[] H, int[] S) {
//			if (index == 0)
//		        return 0;
//		    if (S[index] != -1)
//		        return S[index];
//		    int jumpTwo = Integer.MAX_VALUE;
//		    int jumpOne = finSath(index - 1, H, S) + Math.abs(H[index] - H[index - 1]);
//		    if (index > 1)
//		        jumpTwo = finSath(index - 2, H, S) + Math.abs(H[index] - H[index - 2]);
//
//		    // Track the jumps made
//		    int jump = (jumpOne <= jumpTwo) ? 1 : 2;
//
//		    S[index] = Math.min(jumpOne, jumpTwo);
//
//		    // Print the jump made (skip the initial 0)
//		    int max =-1;
//		    if(S.length-1 == index) {
//		    	for(int i=1;i<S.length;i++)
//		    	{
//		    		if(S[i]>max) {
//						max = S[i];
//					}
//		    	}
//		    	S[0] = 1;
//		    	for(int i=1;i<S.length;i++)
//		    	{
//		    		if(S[i]%max==0) {
//		    			S[i] = 1;
//		    		}
//		    		else {
//		    			S[i] =0;
//		    		}
//		    	}
//		    }
//		    return Math.min(jumpOne, jumpTwo);
//		}
//
//}
