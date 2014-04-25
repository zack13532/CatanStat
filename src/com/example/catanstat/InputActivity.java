package com.example.catanstat;

import java.util.Vector;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
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
		
		//current turn number
		private int turnNum;
		private TextView turnDisp;
		private Vector<Integer> diceRollHist;
		private Spinner diceSpinner1, diceSpinner2;
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			View rootView = inflater.inflate(R.layout.fragment_input,
					container, false);

			turnNum = 1;

			diceSpinner1 = (Spinner) rootView.findViewById(R.id.dicespinner1);
			diceSpinner2 = (Spinner) rootView.findViewById(R.id.dicespinner2);
			
			Integer[] diceRes = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
					R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
			
			SimpleImageArrayAdapter diceSpinnerAdapter1 = new SimpleImageArrayAdapter(getActivity(), diceRes);
			diceSpinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			SimpleImageArrayAdapter diceSpinnerAdapter2 = new SimpleImageArrayAdapter(getActivity(), diceRes);
			diceSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			// Create an ArrayAdapter using the string array and a default spinner layout
			/*ArrayAdapter<CharSequence> diceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.dicerolls, android.R.layout.simple_spinner_item);
			
			// Specify the layout to use when the list of choices appears
			diceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			// Apply the adapter to the spinner
			diceSpinner.setAdapter(diceSpinnerAdapter);
			*/
			
			diceSpinner1.setAdapter(diceSpinnerAdapter1);
			diceSpinner2.setAdapter(diceSpinnerAdapter2);

			turnDisp = (TextView) rootView.findViewById(R.id.turndisp);
			turnDisp.setText("Turn " + turnNum);
			
			Button submitButt = (Button) rootView.findViewById(R.id.submitbutt);
			
			submitButt.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v){
					submitTurn(v);
				}
			});
			
			//create generic spinner listener
			OnItemSelectedListener spinListen = new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> p, View v, int pos, long i){
					setSpinnerSelection(p, v, pos, i);
				}
				public void onNothingSelected(AdapterView<?> p){
					doNothing(p);
				}
			};
			
			// Set Item Listeners
			diceSpinner1.setOnItemSelectedListener(spinListen);
			diceSpinner2.setOnItemSelectedListener(spinListen);

			//change this so it references a global constant variable instead of 20
			diceRollHist = new Vector<Integer>(20);
			
			return rootView;
		}
		
		//called when the user clicks the Submit button
		public void submitTurn(View v){
			
			int roll = diceSpinner1.getSelectedItemPosition() +
					   diceSpinner2.getSelectedItemPosition() + 2;
			
			diceRollHist.add(roll);
			
			turnNum++;
			turnDisp.setText("Turn " + turnNum + "\nLast Roll: " + roll);
		}
		
		public void setSpinnerSelection(AdapterView<?> parent, View view,
				int position, long id) {
			parent.setSelection(position);
			
		}

		public void doNothing(AdapterView<?> parent) {
			// Do nothing CAUSE ZACK IS GAY
		}
		
	}
	
}
