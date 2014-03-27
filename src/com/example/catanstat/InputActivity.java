package com.example.catanstat;

import java.util.Locale;
import java.util.Vector;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class InputActivity extends FragmentActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		Intent intent = getIntent();
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment implements OnItemSelectedListener {
		
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		//current turn number
		private int turnNum;
		private TextView turnDisp;
		private Vector<Integer> diceRollHist;
		private Spinner diceSpinner;
		
		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			turnNum = 1;
			
			View rootView = inflater.inflate(R.layout.fragment_input_dummy,
					container, false);
			diceSpinner = (Spinner) rootView.findViewById(R.id.dicespinner);
			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> diceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.dicerolls,
					android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
			diceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner
			diceSpinner.setAdapter(diceSpinnerAdapter);

			turnDisp = (TextView) rootView.findViewById(R.id.turndisp);
			turnDisp.setText("Turn " + turnNum);
			
			Button submitButt = (Button) rootView.findViewById(R.id.submitbutt);
			
			//change this so it references a global constant variable instead of 20
			diceRollHist = new Vector<Integer>(20);
			
			// Set Item Listener
			diceSpinner.setOnItemSelectedListener(this);
			
			return rootView;
		}

		
		//called when the user clicks the Submit button
		public void submitTurn(){
			
			diceRollHist.add(diceSpinner.getSelectedItemPosition()+2);
			
			turnNum++;
			turnDisp.setText("Turn " + turnNum);
		}
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			parent.setSelection(position);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// Do nothing
		}
	}


}
