package com.example.nastia.combinatoricscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsActivity extends AppCompatActivity {
    private EditText perRepObj;
    private EditText perNORepObj;
    private String msgNO;
    private String msgRep;
    private int i;
    private int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permutations);
        //Input from the user
        perNORepObj=(EditText) findViewById(R.id.noRepTxt);
        perRepObj=(EditText) findViewById(R.id.repTxt);
        final TextView noRepMsg=(TextView) findViewById(R.id.perNoRepRes);
        final TextView repMsg=(TextView) findViewById(R.id.perRepRes);
        //Button for non repetitive
        Button noRepBtn=(Button) findViewById(R.id.perNoRepBtn);
        //Button for repetitive
        Button repBtn=(Button) findViewById(R.id.perRepBtn);
        //Not repetitive permutations
        noRepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgNO = perNORepObj.getText().toString();
                if (msgNO.equals("")  || Long.parseLong(msgNO) < 1 || Long.parseLong(msgNO) > 20)
                    noRepMsg.setText("קלט שגוי.");
                else {
                    PerClass noRep = new PerClass(msgNO);
                    noRepMsg.setText(noRep.PerNoRep());
                }
            }
        });
        //Repetitive permutations
         repBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgRep=perRepObj.getText().toString();
                String strArr[] = msgRep.trim().split(" ");
                ArrayList<String> lstStr = new ArrayList<String>(Arrays.asList(strArr));
                for (i=0; i<lstStr.size();i++){
                    if (lstStr.get(i).equals("")  || Long.parseLong(lstStr.get(i)) < 1 || Long.parseLong(lstStr.get(i)) > 20)
                        flag=0;
                }
                if (flag==0)
                {
                    repMsg.setText("קלט שגוי.");
                    flag=1;
                }
                else{
                    PerClass rep = new PerClass(lstStr);
                    repMsg.setText(rep.PerRep());
                }
            }
        });

    }
}
