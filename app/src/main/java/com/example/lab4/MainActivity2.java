package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private Button sendbtn;
    private EditText set_drink;
    private RadioGroup rg1,rg2;
    private String sugar = "無糖";
    private String ice_opt="去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1=findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.No_sugar:
                        sugar="無糖";
                        break;
                    case R.id.Less_sugar:
                        sugar="少糖";
                        break;
                    case R.id.Half_sugar:
                        sugar="半糖";
                        break;
                    case R.id.Full_sugar:
                        sugar="全糖";
                        break;
                }
            }
        });

        rg2=findViewById(R.id.rg2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.alittle_ice:
                        ice_opt="微冰";
                        break;
                    case R.id.Less_ice:
                        ice_opt="少冰";
                        break;
                    case R.id.Normal_ice:
                        ice_opt="正常冰";
                        break;
                }
            }
        });
        sendbtn=findViewById(R.id.btn_send);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_drink=findViewById(R.id.ed_drink);
                String drink = set_drink.getText().toString();
                Intent i =new Intent();
                Bundle b =new Bundle();
                b.putString("sugar",sugar);
                b.putString("drink",drink);
                b.putString("ice",ice_opt);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}