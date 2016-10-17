package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class SepiaFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          Double newRed = (r * .393) + (g *.769) + (b * .189);
	          Double newGreen = (r * .349) + (g *.686) + (b * .168);
	          Double newBlue = (r * .272) + (g *.534) + (b * .131);
	          
	          int realred = newRed.intValue();
	          int realgreen = newGreen.intValue();
	          int realblue = newBlue.intValue();
	          
	          if(realred > 255) {
	        	  realred = 255;
	          } else {
	        	  realred = realred;
	          }
	          if(realgreen > 255) {
	        	  realgreen = 255;
	          } else {
	        	  realgreen = realgreen;
	          }
	          if(realblue > 255) {
	        	  realblue = 255;
	          } else {
	        	  realblue = realblue;
	          }
	          processed.set(i, j, new Color(realred, realgreen, realblue));
	    	  
	      }
	    }
		
		return processed;
	}

}
