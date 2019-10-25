package com.madantiwari.viewimage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rdodayahang, rdorajesh, rdosaugat;
    ImageView imghero;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdodayahang=findViewById(R.id.rdoDayahang);
        rdorajesh=findViewById(R.id.rdoRajesh);
        rdosaugat=findViewById(R.id.rdoSaugat);
        imghero=findViewById(R.id.imgHero);
        builder=new AlertDialog.Builder(this);

        rdodayahang.setOnClickListener(this);
        rdorajesh.setOnClickListener(this);
        rdosaugat.setOnClickListener(this);

    }

    public void dialogbox(final int box){
        builder.setMessage("Do you want to view this picture?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        imghero.setImageResource(box);
                        Toast.makeText(getApplicationContext(),"You clicked Yes", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"You clicked No",Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("View Photo");
        alert.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.rdoDayahang:
                dialogbox(R.drawable.dayahang);
                break;

            case R.id.rdoRajesh:
                dialogbox(R.drawable.rajeshhamal);
                break;

            case R.id.rdoSaugat:
                dialogbox(R.drawable.saugatmalla);
        }
    }
}
