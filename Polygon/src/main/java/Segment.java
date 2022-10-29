import java.math.BigDecimal;

public class Segment {
	/**
	 * Determines whether the point being examined is on straight through two 
	 * corner points of the polygon.
	 * @param a corner point of the polygon
	 * @param b corner point of the polygon
	 * @param c point which location is examined
	 * @return  true, if straight equation is fulfilled
	 * 					false, otherwise
	 */
	public static boolean fulfillsStraightEquation(Point2D a, Point2D b, 
			Point2D c) {
		//Checking for division by zero error if the straight is vertical
		if ((a.getX()-b.getX()) == 0) {
			if (a.getX() == c.getX()){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			BigDecimal slope = BigDecimal.valueOf(((a.getY()-b.getY())/(a.getX()-b.
					getX())));
			BigDecimal constant = (BigDecimal.valueOf(a.getY()).subtract(slope.
					multiply(BigDecimal.valueOf(a.getX()))));
			
			if (BigDecimal.valueOf(c.getY()) == (slope.multiply(BigDecimal.valueOf
					(c.getX())).add(constant))) {
				return true;
			}
			else {
				return false;
			}	
		}	
	}
	
	/**
	 * Determines whether coordinates of the point being examined fall between 
	 * the corner points' coordinate values.
	 * @param a corner point of the polygon
	 * @param b corner point of the polygon
	 * @param c point which location is examined
	 * @return  true, if point is within corner points
	 * 	        false, otherwise
	 */
	public static boolean isWithin(Point2D a, Point2D b,Point2D c) {
		boolean within = false;
		int minX = Math.min(a.getX(),b.getX());
		int maxX = Math.max(a.getX(),b.getX());
		int minY = Math.min(a.getY(),b.getY());
		int maxY = Math.max(a.getY(),b.getY());
		
		if (minX <= c.getX() && c.getX() <= maxX) {
			if (minY <= c.getY() && c.getY() <= maxY){
				within = true;
			}	
		}
		
		return within;
	}
	
	/**
	 * Determines whether the point being examined is on a polygon segment.
	 * @param a corner point of the polygon
	 * @param b corner point of the polygon
	 * @param c point which location is examined
	 * @return  true, if point is on segment
	 *          false, otherwise
	 */
	public static boolean isOnLine(Point2D a, Point2D b,Point2D c) {
		boolean onLine = false;
		
		if (fulfillsStraightEquation(a,b,c)) {
			if (isWithin(a,b,c)) {
				onLine = true;
			}
		}
		
		return onLine;
	}
}
