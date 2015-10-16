package de.effectivetrainings.operation;

import de.effectivetrainings.Calculator;


/**
 * @author Martin Dilger
 * @since: 06.07.14
 */
public class List implements Operation
{

	private Calculator calculator;

	public List(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public Double perform(Double operandA, Double operandB)
	{
		for(Operation operation : calculator.operations()) {
			System.out.println(operation.getOperationIdentifier());
		}
		return null;
	}

	@Override
	public String getOperationIdentifier()
	{
		return "list";
	}
}
