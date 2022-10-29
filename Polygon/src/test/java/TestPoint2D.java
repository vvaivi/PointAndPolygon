import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPoint2D {
	/**
	 * 
	 */
	@Test
	void testGetCoordinatesPositive() {
		Point2D point = new Point2D(2,7);
		int resX = point.getX();
		int resY = point.getY();
		
		assertEquals(2,resX);
		assertEquals(7,resY);
	}
	
	/**
	 * 
	 */
	@Test
	void testGetCoordinatesNegative() {
		Point2D point = new Point2D(-8,-7);
		int resX = point.getX();
		int resY = point.getY();
		
		assertEquals(-8,resX);
		assertEquals(-7,resY);
	}
}
