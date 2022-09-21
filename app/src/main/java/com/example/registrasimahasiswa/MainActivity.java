package com.example.registrasimahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
EditText etnm;
EditText etem;
EditText etps;
RadioGroup rb;
RadioButton rb2;
Spinner sp;
SeekBar sb;
ToggleButton tb;
TextView tu,tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //inputan
       etnm = findViewById(R.id.etnm);
       etem = findViewById(R.id.etem);
       etps = findViewById(R.id.etps);

    //jenisKelamin
        rb = findViewById(R.id.rb);

    //usia
        sb = findViewById(R.id.sb);
        tu = findViewById(R.id.tu);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tu.setText(String.valueOf(progress + "tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //asrama
            tb = findViewById(R.id.tb);

        //prodi
            sp = findViewById(R.id.sp);
            tp = findViewById(R.id.tp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nama_prodi, android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(adapter);
            sp.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String programstudi = parent.getItemAtPosition(position).toString();
        tp.setText(String.valueOf(programstudi));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
    public void kirimdata(View view) {
        int idradio = rb.getCheckedRadioButtonId();
        rb2 = findViewById(idradio);

        Intent i1 = new Intent(this, hasil.class);
        i1.putExtra("nama",etnm.getText().toString());
        i1.putExtra("email",etem.getText().toString());
        i1.putExtra("katasandi",etps.getText().toString());
        i1.putExtra("jenisKelamin",rb2.getText().toString());
        i1.putExtra("usia",tu.getText().toString());
        i1.putExtra("prodi",tp.getText().toString());
        i1.putExtra("asrama",tb.getText().toString());
        startActivity(i1);

    }

    private void startActivities(Intent i1) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}