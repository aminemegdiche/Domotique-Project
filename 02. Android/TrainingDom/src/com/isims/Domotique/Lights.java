package com.isims.Domotique;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.isims.Domotique.Shutters.ShutterStateTask;
import com.trainingpro.TrainingDom.R;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class Lights extends Activity {
	 ListView list;
	 private ArrayList<String> data;
	 ArrayList<String> dataIds;
	 ArrayList<String> dataLi_m;
	 boolean RoomTaskState=false;
	 Button on,off;
	 SeekBar lightgradient;
	 int lightState=0;
	 int lightindex=0;
	 ImageView light;
	 int lightImageState=0;
	 Timer autoUpdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lights);
		list=(ListView) findViewById(R.id.listView3);
		light=(ImageView) findViewById(R.id.imageViewlight);
		on=(Button) findViewById(R.id.buttonon);
		off=(Button) findViewById(R.id.buttonoff);
		lightgradient=(SeekBar) findViewById(R.id.seekBar1);
		on.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lightState=1;
				new LightTask().execute();
			}
		});
		off.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lightState=0;
				new LightTask().execute();
			}
		});
		lightgradient.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if(progress>=0 && progress<=33)
					lightState=3;//low
				if(progress>=34 && progress<=66)
					lightState=2;//medium
				
				if(progress>=67 && progress<=100)
					lightState=1;//high
				
				new LightTask().execute();
			} 
		});
		data=new ArrayList<String>();
		dataIds=new ArrayList<String>();
		dataLi_m=new ArrayList<String>();
		new RoomTask().execute();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				lightindex=arg2;
				
				int li_m = Integer.parseInt(dataLi_m.get(arg2));
				
				if(li_m==1)
					lightgradient.setVisibility(SeekBar.VISIBLE);
				else
					lightgradient.setVisibility(SeekBar.INVISIBLE);	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lights, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		  autoUpdate = new Timer();
		
		autoUpdate.schedule(new TimerTask() {
			
			@Override
			public void run() { 
				// TODO Auto-generated method stub
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(RoomTaskState==true)
						{
						new LightStateTask().execute();
						Log.i("state","ok");
						}
						
					}
				});
				
				
			}
		}, 1000,1000);
		
		
		super.onResume();
	}
	
	
	public class RoomTask extends AsyncTask<String, String, String>
	{

		
		
		private ProgressDialog pDialog;
		private JSONParser jParser;
		private String message;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			pDialog=new ProgressDialog(Lights.this);
			pDialog.setMessage("Loading Rooms");
			pDialog.show();
			
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jParser=new JSONParser();
			
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id", new Setting(Lights.this).getId()));
			
			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Lights.this).getIp()+":"+new Setting(Lights.this).getPort()+"/Domotique/List.php", "GET", parames);
			
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
							String roomid=r.getString("id_rm");
							dataIds.add(roomid);
							
							String roomli_m=r.getString("li_m");
							dataLi_m.add(roomli_m);
							
							
							
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
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Lights.this, android.R.layout.simple_list_item_1, data);
			
				list.setAdapter(adapter);
				
				RoomTaskState=true;
			}else	
			{
				Toast.makeText(Lights.this, message, Toast.LENGTH_LONG).show();
			}
			
			super.onPostExecute(result);
		}
		
	
		
	}

	
	public class LightTask extends AsyncTask<String, String, String>
	{

		private String message;

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			JSONParser jParser = new JSONParser();
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id_usr", new Setting(Lights.this).getId()));
			parames.add(new BasicNameValuePair("id_rm",dataIds.get(lightindex)));
			parames.add(new BasicNameValuePair("li_v", lightState+""));
				
			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Lights.this).getIp()+":"+new Setting(Lights.this).getPort()+"/Domotique/Light.php", "GET", parames);
			
			
			try {
				int success=json.getInt("success");
				
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
			
			Toast.makeText(Lights.this, message, Toast.LENGTH_LONG).show();
			
			if(result.equals("success"))
			{
			switch (lightState) {
			case 0:
				
				light.setImageResource(R.drawable.light_off);
				break;

			case 1:
				light.setImageResource(R.drawable.light_max);
				break;
				
			case 2:
				light.setImageResource(R.drawable.light_middle);
				break;
				
			case 3:
				light.setImageResource(R.drawable.light_low);
				break;

			default:
				break;
			}
			}
			super.onPostExecute(result);
		}

		
		
		
	}

	public class LightStateTask extends AsyncTask<String , String, String>
	{
		

		private JSONParser jsonParser;
		private String message;

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jsonParser=new JSONParser();
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id_usr", new Setting(Lights.this).getId()));
		    parames.add(new BasicNameValuePair("id_rm", dataIds.get(lightindex)));
			//parames.add(new BasicNameValuePair("id_rm", "2"));
			
			JSONObject json = jsonParser.makeHttpRequest("http://"+new Setting(Lights.this).getIp()+":"+new Setting(Lights.this).getPort()+"/Domotique/LightState.php", "GET", parames);
			
			try {
				int success=json.getInt("success");
				
				if(success==1)
				{
					
					lightImageState=Integer.parseInt(json.getString("li_v"));
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
			
			if(result.equals("fail"))
			Toast.makeText(Lights.this, message, Toast.LENGTH_LONG).show();
			
			if(result.equals("success"))
			{
			switch (lightImageState) {
			case 0:
				
				light.setImageResource(R.drawable.light_off);
				break;

			case 1:
				light.setImageResource(R.drawable.light_max);
				break;
				
			case 2:
				light.setImageResource(R.drawable.light_middle);
				break;
				
			case 3:
				light.setImageResource(R.drawable.light_low);
				break;

			default:
				break;
			}
			}
			super.onPostExecute(result);
		}

	
		
		
	}




}
