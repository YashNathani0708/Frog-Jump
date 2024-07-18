# Dynamic Programming - Frog Jump Problems

This repository contains three Java programs that solve variations of the "Frog Jump" problem using dynamic programming. Each program tackles a different approach to finding the minimum energy required for a frog to jump across a series of rocks with varying heights.

## Programs Overview

1. **FrogA.java**: Solves the problem using a recursive approach with memoization.
2. **FrogB.java**: Uses an iterative approach to solve the problem.
3. **stack.java**: Implements the solution using a stack-based approach.

## FrogA.java

### Description

The `FrogA` program uses a recursive approach with memoization to find the minimum energy required for the frog to jump from the first rock to the last rock. The program reads input from the user, calculates the minimum energy, and prints the energy along with the jump types.

### How to Run

1. Compile the program:
   ```sh
   javac FrogA.java
   ```

2. Run the program:
   ```sh
   java FrogA
   ```

### Main Functions

- `main(String[] args)`: Reads input, initializes arrays, and calls the `findpath` function.
- `findpath(int index, int[] H, int[] S)`: Recursively calculates the minimum energy and tracks jump types.

## FrogB.java

### Description

The `FrogB` program uses an iterative approach to solve the frog jump problem. It calculates the minimum energy required for the frog to jump across the rocks and prints the results.

### How to Run

1. Compile the program:
   ```sh
   javac FrogB.java
   ```

2. Run the program:
   ```sh
   java FrogB
   ```

### Main Functions

- `main(String[] args)`: Reads input, initializes arrays, and calls the `findpath` function.
- `findpath(int[] S, int[] H)`: Iteratively calculates the minimum energy and tracks jump types.

## stack.java

### Description

The `stack` program uses a stack-based approach to solve the frog jump problem. It calculates the minimum energy required for the frog to jump from the first rock to the last rock and prints the energy along with the jump types.

### How to Run

1. Compile the program:
   ```sh
   javac stack.java
   ```

2. Run the program:
   ```sh
   java stack
   ```

### Main Functions

- `main(String[] args)`: Reads input, initializes arrays, and calls the `findPath` function.
- `findPath(int[] S, int[] H, int currentRock, int energySum)`: Uses a stack to calculate the minimum energy and tracks jump types.

## Example Input and Output

### Input

```
5
10 30 40 50 20
```

### Output

For `FrogA.java`:
```
30 1 0 1 1 0
```

For `FrogB.java`:
```
30 0 0 1 0 1
```

For `stack.java`:
```
30 1 0 0 1 0
```

## Notes

- Ensure the input is provided in the correct format: the first line should be the number of rocks, followed by the heights of the rocks.
- Modify the programs as needed to handle different input sizes or formats.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to modify any sections to better fit your project's specifics!
