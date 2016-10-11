package class_design;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
	
	Fraction frac = new Fraction(3,5);
	Fraction frac2 = new Fraction(3,4);

	@Test
	public void addTest() {
		Fraction test = frac.add(frac2);
		System.out.println(test.den);
		assertTrue("gcd", test.den == 20);
		assertTrue("final fraction", test == new Fraction(27,20));
	}
	
	@Test
	public void multTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void simplifyTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void recipTest() {
		fail("Not yet implemented");
	}

}
