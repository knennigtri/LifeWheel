/* Copyright (C) 2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.nennig.life.wheel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.nennig.life.wheel.R;
import com.nennig.life.wheel.charting.PieChart;

public class MainActivity extends Activity {
    private static int pieScale = 10;
    private int itemCount = 0;
    private static final String TAG = "lifewheel.MainActivity";
    
    private String lifeType = "";
    private float scaleValue = 0;
	
	/**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final Resources res = getResources();
        itemList.add(new Slice("Sleeping", 3f/pieScale, res.getColor(R.color.red), res.getColor(R.color.red_light)));
//        itemList.add(new Slice("Work", 4f/pieScale, res.getColor(R.color.yellow), res.getColor(R.color.yellow_light)));
//        itemList.add(new Slice("Social", 5f/pieScale, res.getColor(R.color.blue), res.getColor(R.color.blue_light)));
//        itemList.add(new Slice("Personal", 6f/pieScale, res.getColor(R.color.green), res.getColor(R.color.green_light)));
//        itemList.add(new Slice("Health", 7f/pieScale, res.getColor(R.color.purple), res.getColor(R.color.purple_light)));
//        itemList.add(new Slice("Eating", 8f/pieScale, res.getColor(R.color.black), res.getColor(R.color.black_light)));
//
//        itemList.add(new Slice("Video Games", 3f/pieScale, res.getColor(R.color.red), res.getColor(R.color.red_light)));
//        itemList.add(new Slice("Drinking", 4f/pieScale, res.getColor(R.color.yellow), res.getColor(R.color.yellow_light)));
//        itemList.add(new Slice("Prayer", 5f/pieScale, res.getColor(R.color.blue), res.getColor(R.color.blue_light)));
//        itemList.add(new Slice("TV", 6f/pieScale, res.getColor(R.color.green), res.getColor(R.color.green_light)));
//        itemList.add(new Slice("Reading", 7f/pieScale, res.getColor(R.color.purple), res.getColor(R.color.purple_light)));
//        itemList.add(new Slice("Tanning", 8f/pieScale, res.getColor(R.color.black), res.getColor(R.color.black_light)));
        
        
        
        
        setContentView(R.layout.main);
        final PieChart pie = (PieChart) this.findViewById(R.id.Pie);
        Slice _slice;
        _slice =itemList.get(itemCount);
        pie.addItem(_slice.label,_slice.cPercent,_slice.sliceColor,_slice.itemColor);
        itemCount++;
//        _slice =itemList.get(itemCount);
//        pie.addItem(_slice.label,_slice.cPercent,_slice.sliceColor,_slice.itemColor);
//        itemCount++;

        //Add Button
        ((Button) findViewById(R.id.main_add_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	itemList.add(new Slice(lifeType, scaleValue / pieScale, res.getColor(R.color.yellow), res.getColor(R.color.yellow_light)));
            	if(itemCount < itemList.size())
            	{
	            	Slice _slice;
	            	_slice =itemList.get(itemCount);
	                pie.addItem(_slice.label,_slice.cPercent,_slice.sliceColor,_slice.itemColor);
	                itemCount++;
            	}
            }
        });
        
        ((Button) findViewById(R.id.main_delete_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	if((itemCount - 1) > 0)
            	{
	            	Slice _slice;
	            	_slice =itemList.get(itemCount - 1);
	                pie.removeItem(_slice.label);
	                itemCount--;
            	}
            }
        });
        
        ((Spinner) findViewById(R.id.main_name_spinner)).setOnItemSelectedListener(new OnItemSelectedListener() 
        {    
	         @Override
	         public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
	        	 lifeType = adapter.getItemAtPosition(i).toString();
	        	 Log.d(TAG,"lifeType Changed to: "	+lifeType);	 
	         }	 
	          @Override     
	          public void onNothingSelected(AdapterView<?> parentView) {} 
          });
        ((Spinner) findViewById(R.id.main_scale_spinner)).setOnItemSelectedListener(new OnItemSelectedListener() 
        {    
	         @Override
	         public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
	        	 scaleValue = Float.parseFloat(adapter.getItemAtPosition(i).toString());
	        	 Log.d(TAG,"lifeType Changed to: "	+lifeType);	 
	         }	 
	          @Override     
	          public void onNothingSelected(AdapterView<?> parentView) {} 
          });
    }
    
    public static List<Slice> itemList = new ArrayList<Slice>();

    private class Slice {
        public String label;
        public int itemColor;
        public int sliceColor;
        public float cPercent; 
        
        public Slice(String l, float p, int sColor, int iColor) {
        	 label = l;
        	 cPercent = p;
        	 sliceColor = sColor;
        	 itemColor = iColor;
        }
    }
}

