import java.util.ArrayList;

class TestPolygonWithFile extends AbstractPolygonTest {
	private String tempFilePath = HandleFiles.createTempFile();

	/**
	 * 
	 */
	@Override
	public  ArrayList<Point2D> getPoints (ArrayList<Point2D> points) {
		ArrayList<String> lines = new ArrayList<>();
		
		//Changing data type to string
		for (Point2D point : points) {
			lines.add(point.getX() + " " + point.getY());
		}
		
		HandleFiles.writeFile(tempFilePath, lines);
		
		return HandleFiles.constructPoints(HandleFiles.readFile(tempFilePath));
	}
	
	/**
	 * 
	 */
	@Override
	public ArrayList<Point2D> getPolygonCorners(ArrayList<Point2D> corners) {
		ArrayList<String> lines = new ArrayList<>();
		
		//Changing data type to string
		for (Point2D corner : corners) {
			lines.add(corner.getX() + " " + corner.getY());
		}

		HandleFiles.writeFile(tempFilePath, lines);
		
		return HandleFiles.constructPoints(HandleFiles.readFile(tempFilePath));
	}
	
	/**
	 *
	 */
	@Override
	public  String getResult(ArrayList<Polygon> polygons) {
		String fileContents = "";
		
		HandleFiles.writeFile(tempFilePath, HandleFiles.createAnswers(polygons));
		
		for (String line : HandleFiles.readFile(tempFilePath)) {
			fileContents += line + System.lineSeparator();
		}		
		
		//Removing the last line feed
		return fileContents.substring(0, fileContents.length()-2);
	}	
}
