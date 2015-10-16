package de.effectivetrainings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

import de.effectivetrainings.InputMatcher;

public class InputMatcherTest {

	@Test
	public void matchSimpleInput() {
		
		InputMatcher matcher = new InputMatcher("1+2");
		assertEquals(new Double(1), matcher.getOperandA());
		assertEquals(new Double(2), matcher.getOperandB());
		assertEquals("+", matcher.getOperation());
	}
	
	@Test
	public void matchSimpleInput_withWhitespace() {
		
		InputMatcher matcher = new InputMatcher(" 1 + 2 ");
		assertEquals(new Double(1), matcher.getOperandA());
		assertEquals(new Double(2), matcher.getOperandB());
		assertEquals("+", matcher.getOperation());
	}
	
	@Test
	public void matchSimpleInput_withMissingOperandA() {
		
		InputMatcher matcher = new InputMatcher("  + 2 ");
		assertNull(matcher.getOperandA());
		assertEquals(new Double(2), matcher.getOperandB());
		assertEquals("+", matcher.getOperation());
	}
	
	@Test
	public void matchInputWithLongerNumbers() {
		InputMatcher matcher = new InputMatcher(" 10598 * 20344 ");
		assertEquals(new Double(10598), matcher.getOperandA());
		assertEquals(new Double(20344), matcher.getOperandB());
		assertEquals("*", matcher.getOperation());
	}
	
	@Test
	public void matchInput_withCustomOperation() {
		InputMatcher matcher = new InputMatcher(" 2 dup 3 ");
		assertEquals(new Double(2), matcher.getOperandA());
		assertEquals(new Double(3), matcher.getOperandB());
		assertEquals("dup", matcher.getOperation());
	}
	
	@Test
	public void matchInput_withSpaceInTheMiddle() {
		InputMatcher matcher = new InputMatcher(" 12 ^2 ");
		assertEquals(new Double(12), matcher.getOperandA());
		assertEquals(new Double(2), matcher.getOperandB());
		assertEquals("^", matcher.getOperation());
	}
	
	@Test
	public void matchInput_wordWithSpaces() {
		InputMatcher matcher = new InputMatcher("12 halbsovielwie  6");
		assertEquals(new Double(12), matcher.getOperandA());
		assertEquals(new Double(6), matcher.getOperandB());
		assertEquals("halbsovielwie", matcher.getOperation());
	}
	
	@Ignore(value = "enable when double precision is activated")
	@Test
	public void matchInput_withDoublePrecision() {
		InputMatcher matcher = new InputMatcher("12.5 *  6.5");
		assertEquals(new Double(12.5), matcher.getOperandA());
		assertEquals(new Double(6.5), matcher.getOperandB());
		assertEquals("*", matcher.getOperation());
	}
}
