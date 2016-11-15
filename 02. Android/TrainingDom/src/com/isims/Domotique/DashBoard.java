package com.isims.Domotique;

import com.trainingpro.TrainingDom.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DashBoard extends Activity {
ImageView light,shutter,thermique,room,param;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dash_board);
		initAttrs();
		initListeners();
		
	}
	
	public void initAttrs()
	{
		light  = (ImageView) findViewById(R.id.ImageView00);
		shutter  = (ImageView) findViewById(R.id.ImageView01);
		thermique  = (ImageView) findViewById(R.id.ImageView02);
		room  = (ImageView) findViewById(R.id.ImageView03);
		param  = (ImageView) findViewById(R.id.ImageView04);
		 
	}

	public void initListeners()
	{
		light.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashBoard.this, Lights.class);
				startActivity(intent);
			}
		});
		shutter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashBoard.this, Shutters.class);
				startActivity(intent);
			}
		});
		thermique.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashBoard.this, Thermiques.class);
				startActivity(intent);
			}
		});
		room.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashBoard.this, Rooms.class);
				startActivity(intent);
			}
		});
		param.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashBoard.this, Params.class);
				intent.putExtra("param", "1");
				startActivity(intent);
			}
		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dash_board, menu);
		return true;
	}

}
