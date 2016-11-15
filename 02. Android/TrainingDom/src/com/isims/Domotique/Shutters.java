package com.isims.Domotique;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.isims.Domotique.Rooms.RoomTask;
import com.trainingpro.TrainingDom.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Shutters extends Activity {
	 ImageView open,close,shutter;
	 ListView list;
	 private ArrayList<String> data;
	 ArrayList<String> dataIds;
	 int indice=0;
	 int shutterState ;
	 int shutterImageState=0;
	 boolean RoomTaskState=false;
	 Timer autoUpdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shutters);
		list=(ListView) findViewById(R.id.listView2);
		open=(ImageView) findViewById(R.id.imageView3);
		close=(ImageView) findViewById(R.id.imageView2);
		shutter=(ImageView) findViewById(R.id.imageView1);
		open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shutterState=1;
				new ShutterTask().execute();
			}
		});
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shutterState=0;
				new ShutterTask().execute();
			}
		});
		data=new ArrayList<String>();
		dataIds=new ArrayList<String>();
		new RoomTask().execute();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				indice=arg2;
			}
		});
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
					new ShutterStateTask().execute();
					Log.i("state","ok");
					}
					
				}
			});
			
			
		}
	}, 1000,1000);
	
	
	super.onResume();
}
	
@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	//autoUpdate.cancel();
	super.onDestroy();
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shutters, menu);
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
			pDialog=new ProgressDialog(Shutters.this);
			pDialog.setMessage("Loading Rooms");
			pDialog.show();
			
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jParser=new JSONParser();
			
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id", new Setting(Shutters.this).getId()));
			
			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Shutters.this).getIp()+":"+new Setting(Shutters.this).getPort()+"/Domotique/List.php", "GET", parames);
			
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
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Shutters.this, android.R.layout.simple_list_item_1, data);
			
				list.setAdapter(adapter);
				
				RoomTaskState=true;
			}else	
			{
				Toast.makeText(Shutters.this, message, Toast.LENGTH_LONG).show();
			}
			
			super.onPostExecute(result);
		}
		
	
		
	}
	

	public class ShutterTask extends AsyncTask<String , String, String>
	{
		

		private JSONParser jsonParser;
		private String message;

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jsonParser=new JSONParser();
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id_usr", new Setting(Shutters.this).getId()));
			parames.add(new BasicNameValuePair("id_rm", dataIds.get(indice)));
			parames.add(new BasicNameValuePair("sh_v",shutterState+""));
			
			JSONObject json = jsonParser.makeHttpRequest("http://"+new Setting(Shutters.this).getIp()+":"+new Setting(Shutters.this).getPort()+"/Domotique/Shutter.php", "GET", parames);
			
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
			
			Toast.makeText(Shutters.this, message, Toast.LENGTH_LONG).show();
			
			if(result.equals("success"))
			{
			switch (shutterState) {
			case 0:
				
				shutter.setImageResource(R.drawable.shutterc);
				break;

			case 1:
				shutter.setImageResource(R.drawable.shuttero);
				break;

			default:
				break;
			}
			}
			super.onPostExecute(result);
		}

	
		
		
	}

	
	public class ShutterStateTask extends AsyncTask<String , String, String>
	{
		

		private JSONParser jsonParser;
		private String message;

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jsonParser=new JSONParser();
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("id_usr", new Setting(Shutters.this).getId()));
		    parames.add(new BasicNameValuePair("id_rm", dataIds.get(indice)));
			//parames.add(new BasicNameValuePair("id_rm", "2"));
			
			JSONObject json = jsonParser.makeHttpRequest("http://"+new Setting(Shutters.this).getIp()+":"+new Setting(Shutters.this).getPort()+"/Domotique/ShutterState.php", "GET", parames);
			
			try {
				int success=json.getInt("success");
				
				if(success==1)
				{
					
					shutterImageState=Integer.parseInt(json.getString("sh_v"));
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
			Toast.makeText(Shutters.this, message, Toast.LENGTH_LONG).show();
			
			if(result.equals("success"))
			{
				
			switch (shutterImageState) {
			case 0:
				
				shutter.setImageResource(R.drawable.shutterc);
				break;

			case 1:
				shutter.setImageResource(R.drawable.shuttero);
				break;

			default:
				break;
			}
				}
			
			super.onPostExecute(result);
		}

	
		
		
	}



}
