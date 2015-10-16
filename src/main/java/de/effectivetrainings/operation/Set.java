package de.effectivetrainings.operation;


public class Set implements Operation {

	public Set() {
	}
	
	@Override
	public Double perform(Double operandA, Double operandB) {
		return operandB;
	}

	@Override
	public String getOperationIdentifier() {
		return "set";
	}

}
