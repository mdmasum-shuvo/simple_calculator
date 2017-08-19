package com.talukder.masum.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView eInput;
   //Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bDevide,bInto,bPlus,bMinus,bRemind,bCancel,bM;

    String total="";
    String sign="";
    double v1,v2;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eInput= (TextView) findViewById(R.id.editNumber);

    }

    //------------------- this method is for click number and show the numebr
    //                    on editText view and put in a variable string "Total"

    public void onclickNUmber(View view){
        final Button button=(Button)view;
        button.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction()==MotionEvent.ACTION_DOWN){
                   button.getBackground().setAlpha(100);
               }

                else  if(event.getAction()==MotionEvent.ACTION_UP){
                   button.getBackground().setAlpha(255);
               }
                return false;
            }
        });
        String str=button.getText().toString(); //to get the button text and put in str variable

        total+=str;            //str add with total several time and store full string in Total
        eInput.setText(total); // it set the string every time we give input

    }

    //----------------this method gives us the sign and first total convert to double v1;

    public void onAdd(View v){
       final Button button= (Button) v;
        button.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    button.getBackground().setAlpha(100);
                }

                else  if(event.getAction()==MotionEvent.ACTION_UP){
                    button.getBackground().setAlpha(255);
                }
                return false;
            }
        });

        if(!total.equals("")){
            v1=Double.parseDouble(total);

            sign=button.getText().toString();
            eInput.setText("");
            total="";
        }
        else {
            Toast.makeText(MainActivity.this,"Please input number first", Toast.LENGTH_SHORT).show();
        }

        //----------------------------------------------------------------


    }
    //--------------this method is used to calculate two number to check the sign-----------------

    public void oncalculate(View v){
        final Button button= (Button) v;
        button.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    button.getBackground().setAlpha(100);
                }

                else  if(event.getAction()==MotionEvent.ACTION_UP){
                    button.getBackground().setAlpha(255);
                }
                return false;
            }
        });

        //--------------------------------------------

        String str2=eInput.getText().toString();
        if (!sign.equals("")|| !str2.equals("")){
            v2=Double.parseDouble(str2);
            double final_total=0;
            if (sign.equals("/") ){
                if (v2==0){
                    Toast.makeText(MainActivity.this, "you can't devide something by zero", Toast.LENGTH_SHORT).show();
                }
                else
                final_total = v1 / v2;


            }

            else if (sign.equals("x")){
                final_total=v1*v2;
            }
            else if (sign.equals("+")){
                final_total=v1+v2;
            }
            else if (sign.equals("-")){
                final_total=v1-v2;
            }
            else if (sign.equals("%")){
                final_total=v1%v2;
            }


            eInput.setText(new DecimalFormat("##.##").format(final_total));
           // tv.setText(new DecimalFormat("##.##").format(i2));
            total=Double.toString(final_total);
        }

        else {
            Toast.makeText(MainActivity.this, "Please input value first", Toast.LENGTH_SHORT).show();
        }

    }
    public void cancel(View v){

        eInput.setText("");
        total="";
    }


}
