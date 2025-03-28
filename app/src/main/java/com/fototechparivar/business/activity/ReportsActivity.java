package com.fototechparivar.business.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import com.fototechparivar.business.databinding.ActivityReportsBinding;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReportsActivity extends AppCompatActivity {

    ActivityReportsBinding binding;
    String token, c, startDate, date;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReportsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date dates = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        startDate = format.format(dates);

        binding.etFromDate.setText(startDate);

        binding.etFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == binding.etFromDate) {
                    final Calendar calendar = Calendar.getInstance();
                    mYear = calendar.get(Calendar.YEAR);
                    mMonth = calendar.get(Calendar.MONTH);
                    mDay = calendar.get(Calendar.DATE);

                    //show dialog
                    DatePickerDialog datePickerDialog = new DatePickerDialog(ReportsActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // fromdate.setText (dayOfMonth + "-" + (month + 1) + "-" + year );
                            binding.etFromDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                }
            }
        });

        binding.etToDate.setText(date);

        binding.etToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == binding.etToDate) {
                    final Calendar calendar = Calendar.getInstance();
                    mYear = calendar.get(Calendar.YEAR);
                    mMonth = calendar.get(Calendar.MONTH);
                    mDay = calendar.get(Calendar.DATE);

                    //show dialog
                    DatePickerDialog datePickerDialog = new DatePickerDialog(ReportsActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            binding.etToDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();

                    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                }
            }
        });

    }
}