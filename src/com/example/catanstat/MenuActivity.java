package com.example.catanstat;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MenuActivity extends FragmentActivity {

	static PlayerList playerList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		playerList = new PlayerList();
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			

			Intent myIntent = new Intent(MenuActivity.this, InputActivity.class);
			MenuActivity.this.startActivity(myIntent); 
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		EditText entryOne;
		EditText entryTwo;
		EditText entryThree;
		EditText entryFour;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_menu, container,
					false);
			
			//textfields
			entryOne = (EditText) view.findViewById(R.id.player1);
			entryTwo = (EditText) view.findViewById(R.id.player2);
			entryThree = (EditText) view.findViewById(R.id.player3);
			entryFour = (EditText) view.findViewById(R.id.player4);
			
			//button
			Button submit = (Button) view.findViewById(R.id.add);
			submit.setText("Add");
			
	        
			//submit-button listener
			submit.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	               
	            	/* sends action when button is clicked */
	            	buttonClicked(v);

	            }
	        });
	        
			return view;
		}
		
		// creates 4 new player objects and add them to singleton playerlist
		// using the text field data as name of players
		public void buttonClicked (View view) {
			
			String p1_name = entryOne.getText().toString();
			String p2_name = entryTwo.getText().toString();
			String p3_name = entryThree.getText().toString();
			String p4_name = entryFour.getText().toString();
			
			playerList.addPlayer(p1_name);
			playerList.addPlayer(p2_name);
			playerList.addPlayer(p3_name);
			playerList.addPlayer(p4_name);
			
		}
	}

	public static class PlayerList {
		   private static PlayerList instance = null;
		   private ArrayList<Player>players;
		   protected PlayerList() {
		      // Exists only to defeat instantiation.
		   }
		   public static PlayerList getInstance() {
		      if(instance == null) {
		         instance = new PlayerList();
		      }
		      return instance;
		   }
		   public void addPlayer(String name){
			   
			   players.add(new Player(name));
		   }
	}
}
