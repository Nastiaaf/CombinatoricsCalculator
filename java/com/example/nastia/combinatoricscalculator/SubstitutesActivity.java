package com.example.nastia.combinatoricscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubstitutesActivity extends AppCompatActivity {

    private EditText subsRepNObj;
    private EditText subsRepKObj;
    private EditText subsNORepNObj;
    private EditText subsNORepKObj;
    private String msgNNO;
    private String msgKNO;
    private String msgNRep;
    private String msgKRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitutes);
        //Input from user non repetitive values
        subsNORepNObj=(EditText) findViewById(R.id.subNoRepNText);
        subsNORepKObj=(EditText) findViewById(R.id.subNoRepKText);
        //Input from user repetitive values
        subsRepNObj=(EditText) findViewById(R.id.subRepNText);
        subsRepKObj=(EditText) findViewById(R.id.subRepKText);
        //Initializing buttons
        Button repBtn = (Button) findViewById(R.id.subRepBtn);
        Button repNOBtn = (Button) findViewById(R.id.subNoRepBtn);
        //Initializing output result
        final TextView noRepMsg=(TextView) findViewById(R.id.subsNoRepRes);
        final TextView repMsg=(TextView) findViewById(R.id.subsRepRes);
        //OnClick event for non repetition calculation
        repNOBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Saving input from user
                msgNNO=subsNORepNObj.getText().toString();
                msgKNO=subsNORepKObj.getText().toString();
                //Calculating the possibilities
                if(msgKNO.equals("") || msgNNO.equals("") || (Long.parseLong(msgKNO) > Long.parseLong(msgNNO)))
                    noRepMsg.setText("קלט שגוי");
                else {
                    SubClass noRepObj = new SubClass(msgNNO, msgKNO);
                    noRepMsg.setText(noRepObj.SubsNoRep());
                }
            }
        });
        //OnClick event for repetition calculation
        repBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Saving input from user
                msgNRep=subsRepNObj.getText().toString();
                msgKRep=subsRepKObj.getText().toString();
                //Calculating the possibilities
                if(msgKRep.equals("") || msgNRep.equals(""))
                    repMsg.setText("קלט שגוי");
                else {
                    SubClass repObj = new SubClass(msgNRep, msgKRep);
                    repMsg.setText(repObj.SubsRep());
                }
            }
        });

    }
}
