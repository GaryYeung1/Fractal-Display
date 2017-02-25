package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class newTest {
	Sets test = new Sets();
	
	
	@Test
	public void Mandelbrot(){
		assertEquals(255,test.mandelbrotSet(0.3207031250000001, -0.07109374999999386));
		assertEquals(1,test.mandelbrotSet(0.5946289062500001, 1.2949218750000122));
		assertEquals(512, test.Mandelbrot_set().length);
		assertEquals(512, test.Mandelbrot_set()[0].length);
	}
	
	@Test
	public void Julia(){
		assertEquals(255,test.juliaSet(1.0492187499999897, -0.234375));
		assertEquals(1,test.juliaSet(1.6933593749999853, 0.9765625));
		assertEquals(512, test.Julia_set().length);
		assertEquals(512, test.Julia_set()[0].length);
		
	}
	
	@Test
	public void Multibrot(){
		assertEquals(255,test.mandelbrotSet(0.5859375, 0.24375000000000108));
		assertEquals(1,test.mandelbrotSet(0.9921875, 1.05625));
		assertEquals(512, test.Mandelbrot_set().length);
		assertEquals(512, test.Mandelbrot_set()[0].length);

	}
}
