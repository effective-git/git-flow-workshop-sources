package de.effectivetrainings.operation;

/**
 * Definition of a Calculator Operation.
 * @author martindilger
 */
public interface Operation {

	/**
	 * performs the Operation with the given operands.
	 * @param operandA
	 * @param operandB
	 */
	public Double perform(Double operandA, Double operandB);
	
	/**
	 * @return the identifier for this operation, for example '+' for a simple Add Operation.
	 */
	public String getOperationIdentifier();
}
