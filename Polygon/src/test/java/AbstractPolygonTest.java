import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class AbstractPolygonTest {
	/**
	 * 
	 */
	public  ArrayList<Point2D> getPoints(ArrayList<Point2D> testPoints) {
		return testPoints;	
	}
	
	/**
	 * 
	 */
	public ArrayList<Point2D> getPolygonCorners(ArrayList<Point2D> cornerPoints){
		return cornerPoints;
	}
	
	/**
	 * 
	 */
	public String getResult(ArrayList<Polygon> polygons) {
		return "";
	}
	
	/**
	 * 
	 */
	public  ArrayList<Polygon> getPolygons (ArrayList<Point2D> testPoints,
			ArrayList<Point2D> corners) {
		ArrayList<Polygon> polygonsToBeTested = new ArrayList<>();
		
		for (Point2D point : getPoints(testPoints)) {
			Polygon polygon = new Polygon(point, getPolygonCorners(corners));
			polygonsToBeTested.add(polygon);
		}
		
		return polygonsToBeTested;
	}
	
	/**
	 * 
	 */
	@Test
	void testTriangle() {
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new
				Point2D(0,0), new Point2D(-1,2), new Point2D(20,20),new Point2D(2,1), 
				new Point2D(1,1)));
		ArrayList<Point2D> testTriangle = new ArrayList<>(Arrays.asList(new 
				Point2D(3,-1), new Point2D(-2,-1), new Point2D(-2,4)));
		String answerString = "Piste (0,0) on monikulmion sisällä." + System.
				lineSeparator() + "Piste (-1,2) on monikulmion sisällä." +System.
				lineSeparator()+ "Piste (20,20) on monikulmion ulkopuolella."+ System.
				lineSeparator() + "Piste (2,1) on monikulmion ulkopuolella." + System.
				lineSeparator() + "Piste (1,1) on monikulmion viivalla.";
		
		//If test is performed in class TestPolygonWithFile, an answer string
		//is returned and it is tested as well
		if (getResult(getPolygons(testPoints,testTriangle)) != "") {
			assertEquals(answerString,getResult(getPolygons(testPoints, testTriangle))
					);
		}
		assertTrue(getPolygons(testPoints, testTriangle).get(0).isInside());
		assertTrue(getPolygons(testPoints, testTriangle).get(1).isInside());
		assertFalse(getPolygons(testPoints, testTriangle).get(2).isInside());
		assertFalse(getPolygons(testPoints, testTriangle).get(3).isInside());
		assertTrue(getPolygons(testPoints, testTriangle).get(4).isOnAnyLine());
	}

	/**
	 * 
	 */
	@Test
	void testSquareWithRepeatingCornerPoint() {
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new
				Point2D(0,0), new Point2D(-1,2), new Point2D(20,20),new Point2D(2,1), 
				new Point2D(1,1)));
		ArrayList<Point2D> testSquare = new ArrayList<>(Arrays.asList(new 
				Point2D(1,-1), new Point2D(1,3), new Point2D(-3,3),new Point2D(-3,-1),
				new Point2D(-3,-1)));
		String answerString = "Piste (0,0) on monikulmion sisällä." + System.
				lineSeparator() + "Piste (-1,2) on monikulmion sisällä." +System.
				lineSeparator()+ "Piste (20,20) on monikulmion ulkopuolella."+ System.
				lineSeparator() + "Piste (2,1) on monikulmion ulkopuolella." + System.
				lineSeparator() + "Piste (1,1) on monikulmion viivalla.";

		if (getResult(getPolygons(testPoints,testSquare)) != "") {
			assertEquals(answerString,getResult(getPolygons(testPoints, 
					testSquare)));
		}	
		assertTrue(getPolygons(testPoints, testSquare).get(0).isInside());
		assertTrue(getPolygons(testPoints, testSquare).get(1).isInside());
		assertFalse(getPolygons(testPoints, testSquare).get(2).isInside());
		assertFalse(getPolygons(testPoints, testSquare).get(3).isInside());
		assertTrue(getPolygons(testPoints, testSquare).get(4).isOnAnyLine());
	}
	
	/**
	 * 
	 */
	@Test
	void testNShape() {
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new
				Point2D(0,0), new Point2D(-1,2), new Point2D(20,20),new Point2D(2,1), 
				new Point2D(1,1)));
		ArrayList<Point2D> testNShape = new ArrayList<>(Arrays.asList(new 
				Point2D(2,-1), new Point2D(1,1), new Point2D(3,3),new Point2D(-3,2),new 
				Point2D(-4,1)));
		String answerString = "Piste (0,0) on monikulmion sisällä." + System.
				lineSeparator() + "Piste (-1,2) on monikulmion sisällä." +System.
				lineSeparator()+ "Piste (20,20) on monikulmion ulkopuolella."+ System.
				lineSeparator() + "Piste (2,1) on monikulmion ulkopuolella." + System.
				lineSeparator() + "Piste (1,1) on monikulmion viivalla.";

		
		if (getResult(getPolygons(testPoints,testNShape)) != "") {
			assertEquals(answerString,getResult(getPolygons(testPoints, 
					testNShape)));
		}
		assertTrue(getPolygons(testPoints, testNShape).get(0).isInside());
		assertTrue(getPolygons(testPoints, testNShape).get(1).isInside());
		assertFalse(getPolygons(testPoints, testNShape).get(2).isInside());
		assertFalse(getPolygons(testPoints, testNShape).get(3).isInside());
		assertTrue(getPolygons(testPoints, testNShape).get(4).isOnAnyLine());
	}
	
	/**
	 * 
	 */
	@Test
	void testWhenPolygonsLinesIntersect() {
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new
				Point2D(0,0), new Point2D(-1,2), new Point2D(20,20),new Point2D(2,1), 
				new Point2D(1,1)));
		ArrayList<Point2D> testIntersectingSegments = new ArrayList<>(Arrays.asList
				(new Point2D(1,1), new Point2D(1,-1), new Point2D(-1,-1), new 
				 Point2D(0,3),new Point2D(-3,1)));
		String answerString = "Piste (0,0) on monikulmion sisällä." + System.
				lineSeparator() + "Piste (-1,2) on monikulmion sisällä." +System.
				lineSeparator()+ "Piste (20,20) on monikulmion ulkopuolella."+ System.
				lineSeparator() + "Piste (2,1) on monikulmion ulkopuolella." + System.
				lineSeparator() + "Piste (1,1) on monikulmion viivalla.";

		
		if (getResult(getPolygons(testPoints,testIntersectingSegments)) != "") {
			assertEquals(answerString,getResult(getPolygons(testPoints, 
					testIntersectingSegments)));
		}
		assertTrue(getPolygons(testPoints, testIntersectingSegments).get(0).isInside
				());
		assertTrue(getPolygons(testPoints, testIntersectingSegments).get(1).isInside
				());
		assertFalse(getPolygons(testPoints, testIntersectingSegments).get(2).
				isInside());
		assertFalse(getPolygons(testPoints, testIntersectingSegments).get(3).
				isInside());
		assertTrue(getPolygons(testPoints, testIntersectingSegments).get(4).
				isOnAnyLine());
	}
	
	/**
	 * 
	 */
	@Test
	void testShapeSurroundingOutsidePoint() {
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new
				Point2D(0,0), new Point2D(-1,2), new Point2D(20,20),new Point2D(2,1), 
				new Point2D(1,1)));
		ArrayList<Point2D> testShapeSurroundingPoint = new ArrayList<>(Arrays.asList
				(new Point2D(1,-1), new Point2D(-2,-1), new Point2D(-2,3),new 
				Point2D(4,3),new Point2D(4,-1), new Point2D(3,-1), new Point2D(3,2),new 
				Point2D(1,2)));
		String answerString = "Piste (0,0) on monikulmion sisällä." + System.
				lineSeparator() + "Piste (-1,2) on monikulmion sisällä." +System.
				lineSeparator()+ "Piste (20,20) on monikulmion ulkopuolella."+ System.
				lineSeparator() + "Piste (2,1) on monikulmion ulkopuolella." + System.
				lineSeparator() + "Piste (1,1) on monikulmion viivalla.";

		if (getResult(getPolygons(testPoints,testShapeSurroundingPoint)) != ""){
			assertEquals(answerString,getResult(getPolygons(testPoints, 
					testShapeSurroundingPoint)));
		}
		assertTrue(getPolygons(testPoints, testShapeSurroundingPoint).get(0).
				isInside());
		assertTrue(getPolygons(testPoints, testShapeSurroundingPoint).get(1).
				isInside());
		assertFalse(getPolygons(testPoints, testShapeSurroundingPoint).get(2).
				isInside());
		assertFalse(getPolygons(testPoints, testShapeSurroundingPoint).get(3).
				isInside());
		assertTrue(getPolygons(testPoints, testShapeSurroundingPoint).get(4).
				isOnAnyLine());
	}	
}
