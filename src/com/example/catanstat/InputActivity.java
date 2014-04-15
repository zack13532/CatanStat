package com.example.catanstat;

import java.util.Locale;
import java.util.Vector;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
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
		
		getFragmentManager().beginTransaction().add(R.id.container, new InputFragment()).commit();
	}

	public static class InputFragment extends Fragment {
		
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
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			View rootView = inflater.inflate(R.layout.fragment_input,
					container, false);

			turnNum = 1;
			
			diceSpinner = (Spinner) rootView.findViewById(R.id.dicespinner);
			
			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> diceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.dicerolls, android.R.layout.simple_spinner_item);
			
			// Specify the layout to use when the list of choices appears
			diceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			// Apply the adapter to the spinner
			diceSpinner.setAdapter(diceSpinnerAdapter);

			turnDisp = (TextView) rootView.findViewById(R.id.turndisp);
			turnDisp.setText("Turn " + turnNum);
			
			Button submitButt = (Button) rootView.findViewById(R.id.submitbutt);
			
			submitButt.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v){
					submitTurn(v);
				}
			});
			
			//change this so it references a global constant variable instead of 20
			diceRollHist = new Vector<Integer>(20);
			
			// Set Item Listener
			diceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> p, View v, int pos, long i){
					setSpinnerSelection(p, v, pos, i);
				}
				public void onNothingSelected(AdapterView<?> p){
					doNothing(p);
				}
			});
			
			return rootView;
		}

		
		//called when the user clicks the Submit button
		public void submitTurn(View v){
			
			diceRollHist.add(diceSpinner.getSelectedItemPosition()+2);
			
			turnNum++;
			turnDisp.setText("Turn " + turnNum);
		}
		
		public void setSpinnerSelection(AdapterView<?> parent, View view,
				int position, long id) {
			parent.setSelection(position);
			
		}

		public void doNothing(AdapterView<?> parent) {
			// Do nothing
		}
	}


}
