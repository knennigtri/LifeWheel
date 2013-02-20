package com.nennig.life.wheel.charting;

import android.content.res.Resources;

import com.nennig.life.wheel.R;

public class PieConstants {
	private static int pieScale = 10;
	
    //Simple check to ensure the scaling rules for the chart are enforced.
    public static float getSliceItemPercentage(float num){
    	if(num < pieScale)
    		return num / pieScale;
    	return pieScale / pieScale;
    }
    
    //Simple color picker for each slice of the pie!
    public static int getSliceColor(Resources res, String str){
    	String[] arr = res.getStringArray(R.array.category_dropdown);
    	int colorCounter = 0;
    	for(String cat : arr){
    		if(str.equals(cat)){
    			switch(colorCounter){
    			case 0:
    				return res.getColor(R.color.yellow);
    			case 1:
    				return res.getColor(R.color.red);
    			case 2:
    				return res.getColor(R.color.orange);
    			case 3:
    				return res.getColor(R.color.blue);
    			case 4:
    				return res.getColor(R.color.black);
    			case 5:
    				return res.getColor(R.color.purple);
    			case 6:
    				return res.getColor(R.color.green);
    			default:
    				return res.getColor(R.color.yellow);
    			}	    			
    		}
    		colorCounter++;
    	}
    	return res.getColor(R.color.yellow);
    }
    public static int getItemColor(Resources res, String str){
    	String[] arr = res.getStringArray(R.array.category_dropdown);
    	int colorCounter = 0;
    	for(String cat : arr){
    		if(str.equals(cat)){
    			switch(colorCounter){
	    			case 0:
	    				return res.getColor(R.color.yellow_light);
	    			case 1:
	    				return res.getColor(R.color.red_light);
	    			case 2:
	    				return res.getColor(R.color.orange_light);
	    			case 3:
	    				return res.getColor(R.color.blue_light);
	    			case 4:
	    				return res.getColor(R.color.black_light);
	    			case 5:
	    				return res.getColor(R.color.purple_light);
	    			case 6:
	    				return res.getColor(R.color.green_light);
	    			default:
	    				return res.getColor(R.color.yellow_light);
    			}	    			
    		}
    		colorCounter++;
    	}
    	return res.getColor(R.color.yellow_light);
    }
}
