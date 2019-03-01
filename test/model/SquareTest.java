package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {
	
	private Square s;
	
	public void setupScenary1() {
		s = new Square();
		s.setOrder(3);
		s.generate();
	}
	
	public void setupScenary2() {
		s = new Square();
		s.setOrder(4);
	}
	
	@Test
	public void testGenerate() {
		setupScenary1();
		
		assertNotNull("The matrix is different to null.", s);
	}

	@Test
	public void testFirstUpNO() {
		setupScenary1();
		s.fill(1, 1);
		
		int[][] generated = s.getS();
		int[][] manual = {{6,1,8},{7,5,3},{2,9,4}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testFirstUpNE() {
		setupScenary1();
		s.fill(1, 2);
		
		int[][] generated = s.getS();
		int[][] manual = {{8,1,6},{3,5,7},{4,9,2}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testFirstDownSO() {
		setupScenary1();
		s.fill(2, 3);
		
		int[][] generated = s.getS();
		int[][] manual = {{2,9,4},{7,5,3},{6,1,8}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testFirstDownSE() {
		setupScenary1();
		s.fill(2, 4);
		
		int[][] generated = s.getS();
		int[][] manual = {{4,9,2},{3,5,7},{8,1,6}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testCheck() {
		setupScenary2();
		assertFalse("The order of matrix is invalid.", s.check());
	}

}
