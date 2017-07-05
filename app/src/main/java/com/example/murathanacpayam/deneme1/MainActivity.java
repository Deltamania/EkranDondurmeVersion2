package com.example.murathanacpayam.deneme1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,EditText.OnEditorActionListener{
    TextView tv,tvKarakter;
    Button bSaldir,bYemek,bUyu;
    karakter k;
    EditText isim;
    Bundle save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim = (EditText) findViewById(R.id.editText);
        tvKarakter = (TextView) findViewById(R.id.tv1);
        if(savedInstanceState != null){
            k = savedInstanceState.getParcelable("karakter");
            isim.setVisibility(View.INVISIBLE);
            tvKarakter.setText(k.toString());
            tvKarakter.setVisibility(View.VISIBLE);
        }
        else{
            k = new karakter();
            k.hareketSayisi = 10;
            k.kilo=10;
            k.saldiriGucu=100;
        }
        tv = (TextView) findViewById(R.id.tv2);

        bSaldir = (Button) findViewById(R.id.btn);
        bSaldir.setOnClickListener(this);
        bYemek=(Button)findViewById(R.id.btn2);
        bYemek.setOnClickListener(this);
        bUyu = (Button) findViewById(R.id.btn3);
        bUyu.setOnClickListener(this);

        tvKarakter.setText(k.toString());

        isim.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        tv.setText("Karakterin ismi : " + isim.getText() + " olarak atandi.");
        k.isim = isim.getText().toString();
        isim.setVisibility(View.INVISIBLE);
        tvKarakter.setText(k.toString());
        tvKarakter.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==bSaldir.getId())
            tv.setText(k.savas());
        if(v.getId()==bYemek.getId())
            tv.setText(k.yemek());
        if(v.getId()==bUyu.getId())
            tv.setText(k.uyumak());
        tvKarakter.setText(k.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("karakter",k);
    }
}
