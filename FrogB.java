import java.util.Scanner;

public class FrogB {
	// read two integers separated by space and output their product
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		do {

			// Reading the input
			int N = scan.nextInt(); //Number of steps

			int[] H = new int[N]; // H array will store the heights
			int[] S = new int[N + 1];  // S array will store the output (steps jumped + minimal energy required)

			for (int i = 0; i < N; ++i) {
				H[i] = scan.nextInt();
			}

			// Calling the function that solves the problem
			int[] e = findpath(S, H);

			System.out.print(e[N] + " ");
			for (int x = 0; x < N; x++) {
				System.out.print(e[x] + " ");
			}
			System.out.println();

		} while (!scan.hasNext());
		scan.close();

	}

	public static int[] findpath(int[] S, int[] H) {
		int N = H.length;

		int[] optimal_energy = new int[N];

		optimal_energy[0] = 0;

		if (N==1) {
			S[0] = 1;
			optimal_energy[0] = H[0];
		}
		
		if (N == 2) {
			S[0] = 1;
			S[1] = 1;
			optimal_energy[1] = Math.abs(H[1] - H[0]);
			
		}

		for (int i = 1; i < N; i++) {
			optimal_energy[i] = Integer.MAX_VALUE;

			// Check if jumping from the previous rock (i-1) is possible
			if (i - 1 >= 0) {
				int energy1 = optimal_energy[i - 1] + Math.abs(H[i] - H[i - 1]);
				if (energy1 < optimal_energy[i]) {
					optimal_energy[i] = energy1;
					S[i] = 1; // Jumped from i-1
				}
			}

			// Check if jumping from the rock before the previous rock (i-2) is possible
			if (i - 2 >= 0) {
				int energy2 = optimal_energy[i - 2] + Math.abs(H[i] - H[i - 2]);
				if (energy2 <= optimal_energy[i]) {		// If the program goes in this if, then it has found a better solution
					optimal_energy[i] = energy2;		// than the previous one, so we will update optimal energy array and step array.
					S[i] = 1; // Jumped from i-2
					S[i-1] = 0;
					S[i-2] = 1;
				}
			}
//			if (S[i] == 2) {
//				S[i - 2] = 1;
//				S[i - 1] = 0;
//				S[i] = 1;
//			}
		}

		S[N] = optimal_energy[N - 1];
		return S;
	}
}
