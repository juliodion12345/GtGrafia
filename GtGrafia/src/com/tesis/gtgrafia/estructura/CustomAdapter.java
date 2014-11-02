package com.tesis.gtgrafia.estructura;

import java.util.List;

import com.tesis.gtgrafia.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>{

    public Context context; 
    public int resource;    
    public int textViewResourceId;
    public List<String> objects = null;
    public Typeface tf; 

    public CustomAdapter(Context context, int resource, int textViewResourceId, List<String> objects) { 
    	super(context, resource, textViewResourceId, objects);

    	this.context = context;
	    this.resource = resource;
	    this.textViewResourceId = textViewResourceId;
	    this.objects = objects;

	    this.tf = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.gt_font));
	}
    
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View textView = v ;
        
        if(textView == null){
            LayoutInflater vi = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            textView = vi.inflate(textViewResourceId, null);
        }

        TextView text = (TextView) textView.findViewById(R.id.list_text);

        if(objects.get(position) != null ) {
        	text.setText(objects.get(position));
            text.setTypeface(tf);
        }

        return textView;
    }
	
}
