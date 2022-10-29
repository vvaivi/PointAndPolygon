import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSegment {
	Point2D a = new Point2D(0,0);
	Point2D b = new Point2D(0,1);
	Point2D c = new Point2D(0,1);
	Point2D d = new Point2D(0,2);
	Point2D e = new Point2D(-1,-8);
	Point2D f = new Point2D(0,3);
	Point2D g = new Point2D(2,1);

	/**
	 * 
	 */
	@Test
	void testFulfillsStraightEquation() {
		boolean res1 = Segment.fulfillsStraightEquation(a, b, c);
		boolean res2 = Segment.fulfillsStraightEquation(a, b, d);
		boolean res3 = Segment.fulfillsStraightEquation(a, d, e);
		
		assertTrue(res1);
		assertTrue(res2);
		assertFalse(res3);
	}
	
	/**
	 * 
	 */
	@Test
	void testIsWihtin() {
		boolean res1 = Segment.isWithin(a, b, c);
		boolean res2 = Segment.isWithin(a, d, b);
		boolean res3 = Segment.isWithin(a, d, e);
		
		assertTrue(res1);
		assertTrue(res2);
		assertFalse(res3);
	}
	
	/**
	 * 
	 */
	@Test
	void testIsOnLine() {
		// isWithin & fulfillsStraigthEquation true
		boolean res1 = Segment.isOnLine(a, b, c);
		// isWithin false
		boolean res2 = Segment.isOnLine(a, b, d);
		// fulfillsStraigthEquation false
		boolean res3 = Segment.isOnLine(f, g, b);
		// isWithin & fulfillsStraigthEquation false
		boolean res4 = Segment.isOnLine(a, d, e);
		
		assertTrue(res1);
		assertFalse(res2);
		assertFalse(res3);
		assertFalse(res4);	
	}
}
