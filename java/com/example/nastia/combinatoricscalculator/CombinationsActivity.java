package com.example.nastia.combinatoricscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CombinationsActivity extends AppCompatActivity {

    private EditText comRepNObj;
    private EditText comRepKObj;
    private EditText comNORepNObj;
    private EditText comNORepKObj;
    private String msgNNO;
    private String msgKNO;
    private String msgNRep;
    private String msgKRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinations);
        //Input from user non repetitive values
        comNORepNObj=(EditText) findViewById(R.id.comNoRepNText);
        comNORepKObj=(EditText) findViewById(R.id.comNoRepKText);
        //Input from user repetitive values
        comRepNObj=(EditText) findViewById(R.id.comRepNText);
        comRepKObj=(EditText) findViewById(R.id.comRepKText);
        //Initializing buttons
        Button repBtn = (Button) findViewById(R.id.comRepBtn);
        Button repNOBtn = (Button) findViewById(R.id.comNoRepBtn);
        //Initializing output result
        final TextView noRepMsg=(TextView) findViewById(R.id.comNoRepRes);
        final TextView repMsg=(TextView) findViewById(R.id.comRepRes);
        //OnClick event for non repetition calculation
        repNOBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Saving input from user
                msgNNO = comNORepNObj.getText().toString();
                msgKNO = comNORepKObj.getText().toString();
                //Calculating the possibilities
                if (msgKNO.equals("") || msgNNO.equals("") || (Long.parseLong(msgKNO) > Long.parseLong(msgNNO)))
                    noRepMsg.setText("קלט שגוי");
                else{
                    CombiClass noRepObj = new CombiClass(msgNNO, msgKNO);
                    noRepMsg.setText(noRepObj.combiNoRep());
                }
            }
        });
        //OnClick event for repetition calculation
        repBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Saving input from user
                msgNRep=comRepNObj.getText().toString();
                msgKRep=comRepKObj.getText().toString();
                //Calculating the possibilities
                if( msgKRep.equals("") || msgNRep.equals("") || (Long.parseLong(msgKRep)>Long.parseLong(msgNRep)))
                    repMsg.setText("קלט שגוי");
                else {
                    CombiClass repObj = new CombiClass(msgNRep, msgKRep);
                    repMsg.setText(repObj.combiRep());
                }
            }
        });

    }
}
