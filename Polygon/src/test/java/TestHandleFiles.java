import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TestHandleFiles {
	private String tempFilePath = HandleFiles.createTempFile();

	/**
	 * 
	 */
	@Test
	void testReadFileAndWriteFile() {
		ArrayList<String> testLines = new ArrayList<>(Arrays.asList("   1 2"
				,"3 4    ", "   "));

		HandleFiles.writeFile(tempFilePath, testLines);
		ArrayList<String> content = HandleFiles.readFile(tempFilePath);
		
		 assertEquals("1 2", content.get(0));
		 assertEquals("3 4", content.get(1));
		 //Also empty lines are read
		 assertEquals("", content.get(2));
	}
	
	/**
	 * 
	 */
	@Test
	void testCreateAnswers() {
		ArrayList<Point2D> testCorners = new ArrayList<>(Arrays.asList(new 
				Point2D(1,1), new Point2D(1,-1), new Point2D(-1,-1),new Point2D(-1,1)));
		ArrayList<Point2D> testPoints = new ArrayList<>(Arrays.asList(new 
				Point2D(0,0), new Point2D(2,2), new Point2D(1,1)));
		ArrayList<Polygon> testPolygons = new ArrayList<>();
		
		for (Point2D point: testPoints) {
			Polygon polygon = new Polygon(point, testCorners);
			testPolygons.add(polygon);
		}
						
		assertEquals("Piste (0,0) on monikulmion sisällä.", HandleFiles.
				createAnswers(testPolygons).get(0));
		assertEquals("Piste (2,2) on monikulmion ulkopuolella.", HandleFiles.
				createAnswers(testPolygons).get(1));
		assertEquals("Piste (1,1) on monikulmion viivalla.", HandleFiles.
				createAnswers(testPolygons).get(2));
	}
}
