package de.effectivetrainings;

import de.effectivetrainings.operation.Operation;
import de.effectivetrainings.operation.Set;

import java.util.List;


public class Calculator {

	private OperationRegistry registry = new OperationRegistry();

	private Double lastResult = 0d;

	public Calculator() {
		registry.set(new Set());
		registry.set(new de.effectivetrainings.operation.List(this));
	}
	
	public Double calculate(String operationIdentifier, Double a, Double b) {
		Operation operation = findOperation(operationIdentifier);
		a = a == null ? lastResult : a;
		Double operationResult = operation.perform(a, b);
		if(operationResult != null) {
			lastResult = operationResult;
		}
		return lastResult;
	}

	public void set(Double number) {
		this.lastResult = number;
	}
	
	public void reset() {
		set(0d);
	}

	public Double get() {
		return lastResult;
	}

	public void registerOperation(Operation operation) {
		registry.set(operation);
	}

	private Operation findOperation(String operationIdentifier) {
		Operation operation = registry.get(operationIdentifier);
		if (operation == null) {
			throw new IllegalStateException(
					"No Operation available for Identifier "
							+ operationIdentifier);
		}
		return operation;
	}

	public List<Operation> operations() {
		return registry.operations();
	}
}
