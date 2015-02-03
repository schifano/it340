/**
 * Name: Rachel A Schifano
 * ULID: raschif
 * Course: IT 340
 * Assignment: Program 1 Part 1
 * Description: Eight tile puzzle problem
 * Farmer needs to cross the river, can only take one thing with him.
 * Wolf eats goat. Goat eats cabbage.
 */
public class EightTile implements SolvePuzzle {
	// Constant array to store state
	public final int[][] puzzle = new int[3][3];
	public int[][] goalState = { {1,2,3},
															 {4,5,6},
															 {7,8,0} };

	/**
	 * A function to take in any needed info and create the intial state.
	 * @param s1 State 1 of tile (0,0)
	 * @param s2 State 2 of tile (0,1)
	 * @param s3 State 3 of tile (0,2)
	 * @param s4 State 4 of tile (1,0)
	 * @param s5 State 5 of tile (1,1)
	 * @param s6 State 6 of tile (1,2)
	 * @param s7 State 7 of tile (2,0)
	 * @param s8 State 8 of tile (2,1)
	 * @param s9 State 9 of tile (2,2)
	 */
	public void intializeState(int s1, int s2, int s3, int s4, int s5, 
														 int s6, int s7, int s8, int s9) {
		puzzle[0][0] = s1;
		puzzle[0][1] = s2;
		puzzle[0][2] = s3;
		puzzle[1][0] = s4;
		puzzle[1][1] = s5;
		puzzle[1][2] = s6;
		puzzle[2][0] = s7;
		puzzle[2][1] = s8;
		puzzle[2][2] = s9;
	}
	
	/** 
	 * A function to test for the goal state
	 * @return true If the current state is equal to the goal state
	 * @return false If the current state is not equal to the goal state
	 */
	@Override
	public boolean testForGoalState() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (puzzle[i][j] != goalState[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * A function that can produce the valid successors of a given state (comes after)
	 */
	@Override
	public void produceSuccessorState() {
		// Row 1
		if (puzzle[0][0] == 0) { System.out.println("Moves: down, right"); }
		if (puzzle[0][1] == 0) { System.out.println("Moves: right, down, left "); }
		if (puzzle[0][2] == 0) { System.out.println("Moves: down, left"); }

		// Row 2 
		if (puzzle[1][0] == 0) { System.out.println("Moves: up, right, down"); }
		if (puzzle[1][1] == 0) { System.out.println("Moves: up, right, down, left"); }
		if (puzzle[1][2] == 0) { System.out.println("Moves: up, down, left"); }

		// Row 3
		if (puzzle[2][0] == 0) { System.out.println("Moves: up, right"); }
		if (puzzle[2][1] == 0) { System.out.println("Moves: up, right, left"); }
		if (puzzle[2][2] == 0) { System.out.println("Moves: up, left"); }
	}

	/**
	 * A way to express and report the cost of operators
	 * @return 1 Each state change has a cost of 1
	 */
	@Override
	public int cost() {
		return 1;
	}
	
	/**
	 * A way to print a state in a compact but clear form
	 */
	@Override
	public void printState() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.print('\n');
		}
	}

	// Main method
	public static void main(String[] args) {
		// TEST
		EightTile test = new EightTile();
		test.intializeState(1,2,3,4,5,6,7,8,0);
		test.printState();
		System.out.println(test.testForGoalState());
		test.produceSuccessorState();
	}
}