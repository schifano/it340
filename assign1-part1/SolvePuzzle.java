/**
 * Name: Rachel A Schifano
 * ULID: raschif
 * Course: IT 340
 * Assignment: Program 1 Part 1
 * Description: SolvePuzzle Interface
 * Interface used to implement the FWGC and 8 tile puzzle problems.
 */
public interface SolvePuzzle {

	// A function to take in any needed info and create the intial state
	// void initializeState();
	// Originally had it in interface, realized it needed to be unique instead for each puzzle
	
	/**
	 * A function to test for the goal state
	 */
	boolean testForGoalState();

	/** 
	 * A function that can produce the valid successors of a given state (comes after)
	 */
	void produceSuccessorState();

	/** 
		* A way to express and report the cost of operators
		*/
	int cost();

	/**
		* A way to print a state in a compact but clear form
		*/
	void printState();
}