package com.isims.Domotique;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.trainingpro.TrainingDom.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Thermiques extends Activity {

	
	ListView list;
	  ArrayList<String> data;
	  ArrayList<String> dataids;
	  ArrayList<String> dataState;
	  Button chaud,froid;
	  ToggleButton on_off;
	  TextView temp;
	  LinearLayout layoutstate;
	  int temp_value=0;
	  boolean changeState=false;
	  int thermiqueState=0;
	 int thermique_on_off=0;
	int  thermiqueindex=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thermiques);
		list=(ListView) findViewById(R.id.listView4);
		chaud=(Button) findViewById(R.id.buttonchaud);
		froid=(Button) findViewById(R.id.buttonfroid);
		on_off=(ToggleButton) findViewById(R.id.toggleButton1);
		temp=(TextView) findViewById(R.id.textViewth);
		Typeface font=Typeface.createFromAsset(getAssets(), "CristoLikidTryout.ttf");
		temp.setTypeface(font);
		data=new ArrayList<String>();
		dataids=new ArrayList<String>();
		dataState=new ArrayList<String>();
		new LoadTask().execute(); 
		
      chaud.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				thermiqueState=1;//chaud
				new ChangeTask().execute();
			}
		});
		froid.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				thermiqueState=0;//froid
				new ChangeTask().execute();
			}
		});
		
		 on_off.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					
					if(isChecked)
						thermique_on_off=1;//on
					else
						thermique_on_off=0;//off
					
					new ChangeTask().execute();
				}
			});
		 
		 list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					thermiqueindex=arg2;
					if(dataState.get(thermiqueindex).equals("0"))
					{	
					dialog();	
					}
					
					
				}
			});
			 
	}
	
	public void dialog()
	{
		AlertDialog.Builder dialog=new AlertDialog.Builder(Thermiques.this);
		
		dialog.setTitle("Info");
		
		dialog.setMessage("Thermique n'existe pas dans la pièce");
		dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		dialog.show();
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thermiques, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
		Timer autoupdate=new Timer();
		
		autoupdate.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(changeState)
						new ThermiqueStateTask().execute();
						
					}
				});
				
				
			}
		},1000, 1000);
		
		super.onResume();
	}

	
	public class LoadTask extends AsyncTask<String, String, String>
	{

		private JSONParser jParser;
		private ProgressDialog pDialog;
		private String msg;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			 pDialog=new ProgressDialog(Thermiques.this);
	    		pDialog.setMessage("Lister les pièces");
	    		pDialog.show();
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> parames = new ArrayList<NameValuePair>();
			  parames.add(new BasicNameValuePair("id",new Setting(Thermiques.this).getId()));
			
			  jParser=new JSONParser();
				
			  JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Thermiques.this).getIp()+":"+new Setting(Thermiques.this).getPort()+"/Domotique/List.php", "GET", parames);
				
				//  JSONObject json = jParser.makeHttpRequest("http://www.arduino.net78.net/Domotique/List.php", "GET", parames);
				  
				  Log.i("etat req json",json.toString());
				  
			  try {
				int success=json.getInt("success");
				
				if(success==1)
					
				{ 
					JSONArray rooms = json.getJSONArray("Room");
					
					for (int i = 0; i <rooms.length(); i++) {
						
						JSONObject r = rooms.getJSONObject(i);
						
						String des_rm = r.getString("room");
						String id_rm = r.getString("id_rm");
						String li_s = r.getString("th_s");
						dataState.add(li_s);
						dataids.add(id_rm);
						data.add(des_rm);
						
						
					}
					
					
					msg=json.getString("message");
					return "success";
				}else{
					msg=json.getString("message");
					return "fail";
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			return null;
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
			
			if(result.equals("success"))
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(Thermiques.this, android.R.layout.simple_list_item_1, data);
				list.setAdapter(adapter);
			}
			if(result.equals("success"))
			{
				Toast.makeText(Thermiques.this, msg, Toast.LENGTH_SHORT).show();
			}
			changeState=true;
			super.onPostExecute(result);
		}
		
	}

	public class ChangeTask extends AsyncTask<String, String, String>
	{

		private JSONParser jParser;
		
		private String msg;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> parames = new ArrayList<NameValuePair>();
			 parames.add(new BasicNameValuePair("id_usr",new Setting(Thermiques.this).getId()));
			 parames.add(new BasicNameValuePair("id_rm",dataids.get(thermiqueindex)));
			 parames.add(new BasicNameValuePair("th",thermique_on_off+""));
			 parames.add(new BasicNameValuePair("th_m",thermiqueState+""));
			 
					
			  jParser=new JSONParser();
				
			  JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Thermiques.this).getIp()+":"+new Setting(Thermiques.this).getPort()+"/Domotique/Thermique.php", "GET", parames);
					
				//  JSONObject json = jParser.makeHttpRequest("http://www.arduino.net78.net/Domotique/Thermique.php", "GET", parames);
				  
				  Log.i("etat req json",json.toString());
				  
			  try {
				int success=json.getInt("success");
				
				if(success==1)
					
				{ 
                		msg=json.getString("message");
						return "success";
			
				  }else{
					msg=json.getString("message");
					return "fail";
	
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			return null;
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			Toast.makeText(Thermiques.this, msg, Toast.LENGTH_SHORT).show();
			
			
			 
			
			super.onPostExecute(result);
		}
		
	}

	
	public class ThermiqueStateTask extends AsyncTask<String, String, String>
	{

		private JSONParser jParser;
		
		private String msg;

		 

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> parames = new ArrayList<NameValuePair>();
			 parames.add(new BasicNameValuePair("id_usr",new Setting(Thermiques.this).getId()));
			 parames.add(new BasicNameValuePair("id_rm",dataids.get(thermiqueindex)));
			
					
			  jParser=new JSONParser();
				
			  JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Thermiques.this).getIp()+":"+new Setting(Thermiques.this).getPort()+"/Domotique/ThermiqueState.php", "GET", parames);
				
				//  JSONObject json = jParser.makeHttpRequest("http://arduino.net78.net/Domotique/ThermiqueState.php", "GET", parames);
				  
				  Log.i("etat req json",json.toString());
				  
			  try {
				int success=json.getInt("success");
				
				if(success==1)
					
				{ 
					
					   
					 temp_value=Integer.parseInt(json.getString("th_v"));   
					 thermiqueState=Integer.parseInt(json.getString("th_m"));
						msg=json.getString("message");
						return "success";
					 
					
					
			
					
				}else{
					msg=json.getString("message");
					return "fail";
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			return null;
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			
//Toast.makeText(Lights.this, msg, Toast.LENGTH_SHORT).show();
			
			
			if(result.equals("success"))
			{
				temp.setText(temp_value+" C");
				
				 
				
			}
			
			super.onPostExecute(result);
		}
		
	}


}
