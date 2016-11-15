package com.isims.Domotique;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.trainingpro.TrainingDom.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Params extends Activity {
EditText ip,port,pin;
Button confirm;
 String pins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if(getIntent().getExtras()==null){
        	
        
        if(verify())
        {
        	Intent i=new Intent(Params.this, DashBoard.class);
			 startActivity(i);
        }
        }
        else
        {
        if(getIntent().getExtras().getString("param").equals("1"));
        Toast.makeText(Params.this, "From dashboard", Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_params);
        ip=(EditText) findViewById(R.id.editText1);
        port=(EditText) findViewById(R.id.editText2);
        pin=(EditText) findViewById(R.id.editText3);
        confirm=(Button) findViewById(R.id.button1);
        confirm.setOnClickListener(new OnClickListener() {
			
		

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ips=ip.getText().toString();
				String ports=port.getText().toString();
				 pins=pin.getText().toString();
				
				
				new Setting(Params.this).createSettings(ips, ports, pins);
				new ParamTask().execute();
				
			}
		});
    }


 public boolean verify()
 {
	 if(new Setting(Params.this).getId().equals("0"))
	 {
		 return false;
	 }
	 
	 return true;
 }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.params, menu);
        return true;
    }
    
    
    
    public class ParamTask extends AsyncTask<String, String, String>
    {

    	private ProgressDialog pDialog;
		private JSONParser jParser;
		 String message;
    
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
    		 pDialog=new ProgressDialog(Params.this);
    		pDialog.setMessage("Loading Please Wait");
    		pDialog.show();
			super.onPreExecute();
		}
    	
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			jParser=new JSONParser();
			
			ArrayList<NameValuePair> parames=new ArrayList<NameValuePair>();
			parames.add(new BasicNameValuePair("pin", pins));
			
			JSONObject json = jParser.makeHttpRequest("http://"+new Setting(Params.this).getIp()+":"+new Setting(Params.this).getPort()+"/Domotique/Param.php", "GET", parames);
			
			Log.i("",json.toString());
			
			try {
				int success=json.getInt("success");
				if(success==1)
				{
					message=json.getString("message");
					int id_usr=json.getInt("id");
					new Setting(Params.this).setId(id_usr+"");
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
				Intent i=new Intent(Params.this, DashBoard.class);
				 startActivity(i);
			}
			else
			{
				Toast.makeText(Params.this,message, Toast.LENGTH_LONG).show();
				
			}
			super.onPostExecute(result);
		}

		
		
		
    	
    }
    
}
