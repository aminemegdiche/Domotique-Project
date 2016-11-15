package com.isims.Domotique;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;

public class Setting {
	
	public SharedPreferences pref;
	public Editor editor;
	private Context context;
	
	private static final String  IP="ip";
	private static final String  PORT="port";
	private static final String  PIN="pin";
	private static final String  ID="id";
	
	
	public Setting(Context c)
	{
		context=c;
		pref=context.getSharedPreferences("Domotique", 0);
		editor=pref.edit();
	}

	public void createSettings(String ip,String port,String pin)
	{
		
		editor.putString(IP, ip);
		editor.putString(PORT, port);
		editor.putString(PIN, pin);
		editor.commit();
		
	}

	public void setId(String id)
	{
		editor.putString(ID, id);
		editor.commit();
	}
	public  String getIp() {
		return pref.getString(IP, "10.0.2.2");
				
	}

	public  String getPort() {
		return  pref.getString(PORT, "80");
	}

	public  String getPin() {
		return  pref.getString(PIN, "0000");
	}

	public  String getId() {
		return  pref.getString(ID, "0");
	}
	
	
	
}
