     package com.isims.Domotique;
     
     import java.util.ArrayList;
     
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
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
     
     public class Rooms extends Activity {
     
     	private ArrayList<String> data;
     	ListView list;
     	Button btn;
     	private CheckBox ch1;
     	private CheckBox ch2;
     	private CheckBox ch3;
     	EditText roomname;
     	@Override
     	protected void onCreate(Bundle savedInstanceState) {
     		super.onCreate(savedInstanceState);
     		setContentView(R.layout.activity_rooms);
     		roomname=(EditText) findViewById(R.id.editText1);
     		list=(ListView) findViewById(R.id.listView1);
     		btn=(Button) findViewById(R.id.button1);
     		btn.setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				dialog();
     			}
     		});
     		data=new ArrayList<String>();
     		new RoomTask().execute();
     	}
     
     	@Override
     	public boolean onCreateOptionsMenu(Menu menu) {
     		// Inflate the menu; this adds items to the action bar if it is present.
     		getMenuInflater().inflate(R.menu.rooms, menu);
     		return true;
     	}
     	
     	public class RoomTask extends AsyncTask<String, String, String>
     	{
     
     		
     		
     		private ProgressDialog pDialog;
     		private JSONParser jParser;
     		private String message;
     
     		@Override
     		protected void onPreExecute() {
     			// TODO Auto-generated method stub
     			pDialog=new ProgressDialog(Rooms.this);
     			pDialog.setMessage("Loading Rooms");
     			pDialog.show();
     			
     			super.onPreExecute();
     		}
     
     		@Override
     		protected String doInBackground(String... params) {
     			// TODO Auto-generated method stub
     			jParser=new JSONParser();
     			
     			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
     			parames.add(new BasicNameValuePair("id", new Setting(Rooms.this).getId()));
     			
     			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Rooms.this).getIp()+":"+new Setting(Rooms.this).getPort()+"/Domotique/List.php", "GET", parames);
     			
     			Log.i("",json.toString());
     			
     		 
     				try {
     					int success=json.getInt("success");
     					if(success==1)
     					{
     						JSONArray rooms = json.getJSONArray("Room");
     						for (int i = 0; i < rooms.length(); i++) {
     							JSONObject r = rooms.getJSONObject(i);
     							String roomname = r.getString("room");
     							data.add(roomname);
     						}
     						
     						message=json.getString("message");
     						return "success";
     						
     					}else
     					{
     						message=json.getString("message");
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
     				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Rooms.this, android.R.layout.simple_list_item_activated_1, data);
     			
     				list.setAdapter(adapter);
     			}else	
     			{
     				Toast.makeText(Rooms.this, message, Toast.LENGTH_LONG).show();
     			}
     			
     			super.onPostExecute(result);
     		}
     		
     	
     		
     	}
     	
     	
     	void dialog()
     	{
     		AlertDialog.Builder aDialog =new AlertDialog.Builder(Rooms.this);
     		aDialog.setTitle("Choisir une option :");
     		LinearLayout layout =new LinearLayout(Rooms.this);
     		layout.setOrientation(LinearLayout.VERTICAL);
     		layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
     		
     	ch1=new CheckBox(Rooms.this);
     	ch1.setText("Eclairge");
     	ch1.setTextColor(Color.BLACK);
     	
     	ch2=new CheckBox(Rooms.this);
     	ch2.setText("Volet");
     	ch2.setTextColor(Color.BLACK);
     	
     	
     	ch3=new CheckBox(Rooms.this);
     	ch3.setText("Thermique");
     	ch3.setTextColor(Color.BLACK);
     	
     	
     	layout.addView(ch1);
     	layout.addView(ch2);
     	layout.addView(ch3);
     	
     	
     	aDialog.setView(layout);
     	

     	aDialog.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
     		
     		@Override
     		public void onClick(DialogInterface dialog, int which) {
     			// TODO Auto-generated method stub
     			
     			new addTask().execute();
     			
     		}
     	});
     		
     	aDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
     		
     		@Override
     		public void onClick(DialogInterface dialog, int which) {
     			// TODO Auto-generated method stub
     			
     		}
     	});	
     		
     	aDialog.show();	
     		
     	
     	}
     	
     	public class addTask extends AsyncTask<String, String, String>
     	{
     
     		 JSONParser jParser;
     		private String message;
     
     		@Override
     		protected String doInBackground(String... params) {
     			// TODO Auto-generated method stub
     			jParser=new JSONParser();
     			
     			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
     			parames.add(new BasicNameValuePair("id_usr", new Setting(Rooms.this).getId()));
     			 parames.add(new BasicNameValuePair("des_rm",roomname.getText().toString()));
     			 parames.add(new BasicNameValuePair("li_s",chekBoxState(ch1.isChecked())));
     			 parames.add(new BasicNameValuePair("sh_s",chekBoxState(ch2.isChecked())));
     			  parames.add(new BasicNameValuePair("th_s",chekBoxState(ch3.isChecked())));
     			
     			
     			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Rooms.this).getIp()+":"+new Setting(Rooms.this).getPort()+"/Domotique/Room.php", "GET", parames);
     			
     			Log.i("",json.toString());
     			
     			
     			try {
     				int success =json.getInt("success");
     				if(success==1)
     				{
     					message=json.getString("message");
     					return "success";
     				}else
     				{
     					message=json.getString("message");
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
     	 	if(result.equals("success"))   
     		{
     	 		data.clear();
     	 		new RoomTask().execute();
     	 		
     			
     		}else	
     		{
     			Toast.makeText(Rooms.this, message, Toast.LENGTH_LONG).show();
     		}
     			super.onPostExecute(result);
     		}
     
     
     
     
     
     
     public String chekBoxState(boolean ch)
      {
     	 if(ch)
     		 return "1";
     	 else 
     		 return "0";
      }

     		
     	}
     
     	
     	
     }
