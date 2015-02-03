/**
 * Name: Rachel A Schifano
 * ULID: raschif
 * Course: IT 340
 * Assignment: Program 1 Part 1
 * Description: Farmer, Wolf, Goat, and Cabbage
 * Farmer needs to cross the river, can only take one thing with him.
 * Wolf eats goat. Goat eats cabbage.
 */
import java.util.Arrays;

public class Farmer implements SolvePuzzle {
	// Constant array to store state
	public final char[] FWGC = new char[4];
	// Valid states
	public char[] initialState = {'w','w','w','w'};
	public char[] goalState = {'e','e','e','e'};
	public char[] valid1 = {'e','w','e','w'};
	public char[] valid2 = {'w','w','e','w'};
	public char[] valid3 = {'e','e','e','w'};
	public char[] valid4 = {'w','e','w','e'};

	/**
	 * A function to take in any needed info and create the intial state.
	 * State must be passed as either char w or char e to indiciate the current
	 * state position as the west or east side of the river bank.
	 * @param farmer Initial state of the farmer
	 * @param wolf Initial state of the wolf
	 * @param goat Initial state of the goat
	 * @param cabbage Initial state of the cabbage
	 */
	public void intializeState(char farmer, char wolf, char goat, char cabbage) {
		// Start on west side of river
		FWGC[0] = farmer;
		FWGC[1] = wolf;
		FWGC[2] = goat;
		FWGC[3] = cabbage;
	}
	
	/** 
	 * A function to test for the goal state
	 * @return true If the current state is equal to the goal state
	 * @return false If the current state is not equal to the goal state
	 */
	@Override
	public boolean testForGoalState() {
		for (int i = 0; i < FWGC.length; i++) {
			if (FWGC[i] != goalState[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * A function that can produce the valid successors of a given state (comes after)
	 */
	@Override
	public void produceSuccessorState() {
		// Check current state to determine successor state
		if (Arrays.equals(FWGC, initialState)) {
			for (int i = 0; i < valid1.length; i++) {
				System.out.println("Successor state: " + valid1[i]);
			}
		}

		if (Arrays.equals(FWGC, valid1)) {
			for (int i = 0; i < valid2.length; i++) {
				System.out.println("Successor state: " + valid2[i]);
			}
		}

		if (Arrays.equals(FWGC, valid2)) {
			for (int i = 0; i < valid3.length; i++) {
				System.out.println("Successor state: " + valid3[i]);
			}
		}

		if (Arrays.equals(FWGC, valid3)) {
			for (int i = 0; i < valid4.length; i++) {
				System.out.println("Successor state: " + valid4[i]);
			}
		}
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
		System.out.println("Farmer: " + FWGC[0]);
		System.out.println("Wolf: " + FWGC[1]);
		System.out.println("Goat: " + FWGC[2]);
		System.out.println("Cabbage: " + FWGC[3]);
	}

	// Main method
	public static void main(String[] args) {
		// TEST
		Farmer test = new Farmer();
		test.intializeState('w','w','w','w');
		test.printState();
		test.produceSuccessorState();
		System.out.println(test.testForGoalState());
	}
}