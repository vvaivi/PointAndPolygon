import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class HandleFiles{
	/**
	 * 
	 */
	public static String createTempFile() {
		String path = "";
		File directoryPath = new File(System.setProperty("java.io.tmpdir",System.
				getProperty("java.io.tmpdir")));
		
		try {
			File tempFile = File.createTempFile("testfile",".txt",directoryPath);
			path =  tempFile.getAbsolutePath();
			tempFile.deleteOnExit();
		}
		catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		return path;
	}
	
	/**
	 * 
	 */
	public static void checkThatParametersAreNumbers(String[] line) {
		try {
			for (String item : line) {
				Integer.parseInt(item);
			}
		}
		catch (NumberFormatException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 
	 */
	public static void checkNumberOfParameters(String[] line) {
		try {
			var x = line[1];
		}
		catch (IndexOutOfBoundsException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 *
	 */
	public static void writeFile (String fileName, ArrayList<String> lines) {
		try {
			var output = new PrintStream(fileName);
			
			for (String line : lines) {
				output.println(line);
			}
			output.close();
		}
		catch (FileNotFoundException ex){
			throw new RuntimeException(ex);
		}		
	}
	
	/**
	 * 
	 */
	public static ArrayList<String> readFile (String fileName) {
		ArrayList<String> lines = new ArrayList<>();
		
		try (var input = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while ((line = input.readLine()) != null) { 
				line = line.strip();
				lines.add(line);
			}
		}
		catch (IOException ex){
			throw new RuntimeException(ex);
		}
		
		return lines;
	}
	
	/**
	 *
	 */
	public static ArrayList<Point2D> constructPoints (ArrayList<String> lines) {
		ArrayList<Point2D> points = new ArrayList<>();
		
		for (String line : lines) {
			if (!line.isEmpty()) {
				String[] parameters = line.split(" ");
				
				checkThatParametersAreNumbers(parameters);
				checkNumberOfParameters(parameters);
				 
				int x,y;
				x = Integer.parseInt(parameters[0]);
				y = Integer.parseInt(parameters[1]);
				 
				Point2D point = new Point2D(x,y); 
				points.add(point);
			}
	 }
		
		return points;
	}
	
	/**
	 * 
	 */
	public static ArrayList<String> createAnswers (ArrayList<Polygon> polygons){
		ArrayList<String> answers = new ArrayList<>();
		
		for (Polygon polygon : polygons) {
			if (polygon.isOnAnyLine()) {
				answers.add(("Piste ("+ polygon.getExaminationPoint().getX() + "," + 
				polygon.getExaminationPoint().getY() + ") on monikulmion viivalla."));
			}
			if (polygon.isInside()) {
				answers.add("Piste ("+ polygon.getExaminationPoint().getX() + "," + 
				polygon.getExaminationPoint().getY() +") on monikulmion sisällä."); 
			 }
			if (!polygon.isInside() && !polygon.isOnAnyLine()) {
				 answers.add(("Piste ("+ polygon.getExaminationPoint().getX() +  "," + 
				 polygon.getExaminationPoint().getY() + ") on monikulmion ulkopuolella."
				 ));
			 }
		}
		
		return answers;
	}
	
	/**
	 * 
	 */
	public static void main(String args[]) { 
		ArrayList<Point2D> cornerPoints =constructPoints(readFile("src/main/java/"
				+ "resources/polygoni" + ".txt"));
		ArrayList<Point2D> examinationPoints =constructPoints(readFile("src/main/"
				+ "java/resources/"+ "pisteet.txt"));
		ArrayList<Polygon> polygons = new ArrayList<>();
		 
		for (Point2D point : examinationPoints) {
			Polygon polygon = new Polygon (point, cornerPoints);
			polygons.add(polygon);
		 }
		
		 writeFile("src/main/java/resources/selvitys.txt",createAnswers
				 (polygons));
		 System.out.println("Program completed");
	}
}
