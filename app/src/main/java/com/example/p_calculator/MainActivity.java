package com.example.p_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculations;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculations = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);

    }
    private void updateText(String strAdd){
        String oldText = display.getText().toString();

        int coursePos = display.getSelectionStart();

        String leftStr = oldText.substring(0 , coursePos);
        String rightStr = oldText.substring(coursePos);

      display.setText(String.format("%s%s%s", leftStr,strAdd,rightStr));
      display.setSelection(coursePos + strAdd.length());
    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void subBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void divBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void mulBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void clearBTNPush(View view){
        display.setText("");
        previousCalculations.setText("");
    }
    public void openPBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void closePBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void backBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();

        if (cursorPos != 0 && textLength != 0){
            SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1 , cursorPos , "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void equalBTNPush(View view){
        String userExp = display.getText().toString();
        previousCalculations.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText) ,"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText) ,"*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void trigSinBTNPush(View view){
        updateText("sin(");
    }
    public void trigCosBTNPush(View view){
        updateText("cos(");
    }
    public void trigTanBTNPush(View view){
        updateText("tan(");
    }
    public void trigSinArcBTNPush(View view){
        updateText("arcsin(");
    }
    public void trigCosArcBTNPush(View view){
        updateText("arccos(");
    }
    public void trigTanArcBTNPush(View view){
        updateText("arctan(");
    }
    public void trigLogBTNPush(View view){
        updateText("log(");
    }
    public void trigLnBTNPush(View view){
        updateText("ln(");
    }
    public void trigSquareRootBTNPush(View view){
        updateText("sqrt(");
    }
    public void trigEBTNPush(View view){
        updateText("e");
    }
    public void trigPieBTNPush(View view){
        updateText("pi");
    }
    public void trigAboluteXBTNPush(View view){
        updateText("abs(");
    }
    public void trigPrimeBTNPush(View view){
        updateText("ispr(");
    }
    public void trigXSquareBTNPush(View view){
        updateText("^(2)");
    }
    public void trigXPowerYBTNPush(View view){
        updateText("^(");
    }


}