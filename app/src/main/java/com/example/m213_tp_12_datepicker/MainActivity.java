package com.example.m213_tp_12_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();

        btn=findViewById(R.id.dateButton);
        txt=findViewById(R.id.age);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener OL = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {

                        String Smounth, SDay;

                        if(selectedMonth < 9)  Smounth ="0"+(selectedMonth+1);
                        else Smounth = String.valueOf(selectedMonth+1);

                        if(selectedDay < 10)  SDay ="0"+(selectedDay);
                        else SDay = String.valueOf(selectedDay);

                        String selected = selectedYear+"-"+(Smounth)+"-"+SDay;
                        LocalDate dateEmb = LocalDate.parse(selected);
                        LocalDate currentDate = LocalDate.now();
                        int yearsExp = Period.between(dateEmb, currentDate).getYears();
                        int mounthsExp = Period.between(dateEmb, currentDate).getMonths();



                        txt.setText("vôtre expérience est de: "+yearsExp+" ans et "+mounthsExp+" mois");
                    }
                };

                DatePickerDialog mDatePicker = new DatePickerDialog(MainActivity.this, OL, mYear, mMonth, mDay);
                mDatePicker.show();



            }
        });

    }
}