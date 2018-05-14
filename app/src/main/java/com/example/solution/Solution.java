package com.example.solution;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Solution extends Activity {

    private int mYear, mMonth, mDay;
    final private int DATE_PICKER_DIALOG = 888;
    private Calendar calendar;
    TextView Output;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        // TextView to display the current date and selected date.
		 Output = (TextView) findViewById(R.id.Output);
		// Button for Date selection pop-up
		Button changeDate = (Button) findViewById(R.id.changeDate);
		
		// TODO: On launch of Activity, display the current date.
		// On click of Change Date button display the DatePickerDialog and show the current date.
		// On selecting the date display the selection in the TextView. 
        calendar = Calendar.getInstance();
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mYear = calendar.get(Calendar.YEAR);
        
        showDialog(DATE_PICKER_DIALOG);
   }
    
    private void showDate(int year, int month, int day) {

        mMonth = month+1;
        mDay = day;
        mYear = year;

        Output.setText( Integer.toString(mMonth)
                       +"/"+ Integer.toString(mDay)
                       +"/"+ Integer.toString(mYear));
    }

    private DatePickerDialog.OnDateSetListener dateListener = new
        DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker dp, int a0, int a1, int a2) {
                showDate(a0, a1, a2);
            }
        };

    @Override
    protected Dialog onCreateDialog(int id){
        if( id==DATE_PICKER_DIALOG) {
            return new DatePickerDialog(this, dateListener, mYear, mMonth, mDay);
        }
        return null;
    }
    
    public void setDate(View view) {
        showDialog(888);
    }
}

