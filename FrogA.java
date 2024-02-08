
import java.util.Arrays;
import java.util.Scanner;

public class FrogA {
    // read two integers separated by space and output their product
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Start a loop that reads and processes input until there's no more input
        do {
            // Reading the number of elements (N)
            int N = scan.nextInt();

            // Create two arrays to store jump heights (H) and jump types (S)
            int[] H = new int[N];
            int[] S = new int[N]; 

            // Read N jump heights and store them in the H array
            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }

            // Initialize the S array with -1 to track the jump types
            Arrays.fill(S, -1);

            // Call the function that solves the problem and store the result in 'e'
            int e = findpath(H.length - 1, H, S);

            // Print the result 'e' and the jump types in the 'S' array
            System.out.print(e + " ");
            for (int i = 0; i < N; ++i) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(S[i]);
            }
            System.out.println();

        } while (!scan.hasNext()); // Continue the loop as long as there's more input

        // Close the Scanner to release system resources
        scan.close();
    }

    // The 'findpath' function is a recursive helper function to solve the problem
    static int findpath(int index, int[] H, int[] S) {
        if (index == 0)
            return 0;
        if (S[index] != -1)
            return S[index];

        // Calculate the cost of jumping one step and two steps
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = findpath(index - 1, H, S) + Math.abs(H[index] - H[index - 1]);
        if (index > 1)
            jumpTwo = findpath(index - 2, H, S) + Math.abs(H[index] - H[index - 2]);

        // Track the type of jump (1 or 2)
        int jump = (jumpOne <= jumpTwo) ? 1 : 2;

        // Store the minimum cost in the 'S' array
        S[index] = Math.min(jumpOne, jumpTwo);

        // Print the jump types, modifying the initial 0 if it's the last element
        int max = -1;
        if (S.length - 1 == index) {
            for (int i = 1; i < S.length; i++) {
                if (S[i] > max) {
                    max = S[i];
                }
            }
            S[0] = 1;
            //S array is filled with the optimal energy for each index and we have done module to check whether we can go to that new index or not 
            for (int i = 1; i < S.length; i++) {
            	//If we can go to that index then we put 1 other wise 0
            	if (S[i] % max == 0) {
                    S[i] = 1;
                } else {
                    S[i] = 0;
                }
            }
        }

        // Return the minimum cost
        return Math.min(jumpOne, jumpTwo);
    }
}
 
