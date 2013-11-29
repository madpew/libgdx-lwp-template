package org.example.lwp.template;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class TemplateLWPSettings extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        //SharedPreferences settings = this.getSharedPreferences("templatelwpSettings", MODE_PRIVATE);
        //setCheckbox(R.id.checkUseAF, settings.getBoolean("chkUseAF",true));
        //setCheckbox(R.id.checkShowLogo, settings.getBoolean("chkShowLogo",true));
        
        ((Button)findViewById(R.id.linkButton)).setOnClickListener(
        		new OnClickListener() {
        			public void onClick(View arg)
        			{
        				onLinkButtonClick();
        			}
        		});
    }
    
    public void setCheckbox(int id, boolean value){
    	CheckBox tmp = (CheckBox) findViewById(id);
    	tmp.setChecked(value);
    }
    
    public void setSlider(int id, float value){
    	SeekBar tmp = (SeekBar) findViewById(id);
    	tmp.setProgress((int)(value*255));
    }
    
    public boolean getCheckbox(int id){
    	CheckBox tmp = (CheckBox) findViewById(id);
    	return tmp.isChecked();
    }
    
    public float getSlider(int id){
    	SeekBar tmp = (SeekBar) findViewById(id);
    	return (tmp.getProgress())/255f;
    }
    
    
	public void onStop(){
    	super.onStop();
        SharedPreferences settings = getSharedPreferences("templatelwpSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        
        //editor.putBoolean("xxx", getCheckbox(R.id.xxx));
        //TemplateLWPMain.xxx = getCheckbox(R.id.xxx);
        editor.commit();
    }
	
	public void onLinkButtonClick(){
		Uri uri = Uri.parse(getString(R.string.lblLinkContent));
		 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		 startActivity(intent);
	}
}