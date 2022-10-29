import java.math.BigDecimal;
import java.util.ArrayList;

public class Polygon {
	private Point2D examinationPoint;
	private ArrayList<Point2D> cornerPoints;
	
	/**
	 * 
	 */
	public Polygon(Point2D examinationPoint, ArrayList<Point2D> cornerPoints) {
	    this.examinationPoint = examinationPoint;
	    this.cornerPoints = cornerPoints;  
	  }
	
	/**
	 * 
	 */
	public Point2D getExaminationPoint () {
		return examinationPoint;
	}
	
	/** 
	 * 
	 */
	public boolean isOnAnyLine() {
		boolean isOnSomeLine = false;
		Point2D c = examinationPoint;
		
		for (int i = 0; i < cornerPoints.size()-1; ++i) {
			Point2D a = cornerPoints.get(i);
			Point2D b = cornerPoints.get(i+1);
			if (Segment.isOnLine(a, b, c)) {
				isOnSomeLine = true;
			}
		}
		//Separately examining the segment between first and last corner
		if (Segment.isOnLine(cornerPoints.get(0), cornerPoints.get(cornerPoints.
				size()-1),c)){
			isOnSomeLine = true;
		}
		
		return isOnSomeLine;
	}
	
	 /**
	 * 
	 */
	public boolean isInside() {
		 boolean odd = false;
	        
	      for (int i = 0, j = cornerPoints.size() - 1; i < cornerPoints.size(); 
	      		i++) {
		    	  // If the point falls between the end points of the segment in y
				  // dimension
	          if ((cornerPoints.get(i).getY() > examinationPoint.getY()) != 
	          			(cornerPoints.get(j).getY() > examinationPoint.getY())){
	          	
			        // And if the x value of the point reaches the x value of the 
	          	    // segment before the y value (otherwise the crossing would 
	          	    // happen outside of the segment)
	          		int comparison = BigDecimal.valueOf(examinationPoint.getX()).
	          				compareTo(BigDecimal.valueOf((cornerPoints.get(j).getX() -
	          				cornerPoints.get(i).getX()) * (examinationPoint.getY() - 
	          				cornerPoints.get(i).getY()) / (cornerPoints.get(j).getY() - 
	          				cornerPoints.get(i).getY()) + cornerPoints.get(i).getX()));
	          		if (comparison == -1) {
	          			odd = !odd;
	          		}		  
	          }
	          j = i;
	        }
	      
	      return odd;
	 }
}
