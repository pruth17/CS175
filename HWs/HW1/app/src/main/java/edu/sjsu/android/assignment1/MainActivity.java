package edu.sjsu.android.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    double inteRate;
    double monthlyPayment = 0;

    RadioGroup loanTerm;
    EditText borrowedAmount;
    SeekBar interestRate;
    TextView payment;
    TextView rateLabel;
    CheckBox tax;
    CheckBox insurance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        borrowedAmount = (EditText) findViewById(R.id.borrowedAmount);
        payment = (TextView) findViewById(R.id.payment);
        interestRate = (SeekBar) findViewById(R.id.interestRate);
        rateLabel = (TextView) findViewById(R.id.rateLabel);
        loanTerm = (RadioGroup) findViewById(R.id.loanTerm);//need to check how the value is returned and stored.
        tax = (CheckBox) findViewById(R.id.tax);
        insurance = (CheckBox) findViewById(R.id.insurance);




        interestRate.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser) {
                            inteRate = interestRate.getProgress() / 10.0;
                            rateLabel.setText("Interest Rate is: "  +  inteRate + " % ");
                        }
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        //called when touched of seekbar

                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //Called when untouched of seekbar
                    }
                }
        );
    }
    public void calculate(View v) {
        
        monthlyPayment = 0;
        int selectedTerm = loanTerm.getCheckedRadioButtonId();
        RadioButton selected = (RadioButton) findViewById(selectedTerm);
        String tem = borrowedAmount.getText().toString();
        if (tem.matches(".*[a-z].*")){
            payment.setText("Please enter numbers");

        }
        else {
            float temp1 = Float.parseFloat(tem);
            if (temp1 > 0.00 && selectedTerm != -1) {


                payment.setText("id: " + getLoan(selected.getText() + ""));
                double N = getLoan(selected.getText() + "") * 1.00;
                double P = Double.parseDouble(borrowedAmount.getText() + "");
                double T = P * 0.001;

                if (inteRate == 0) {

                    monthlyPayment = (P / N);
                    if (tax.isChecked()) {
                        if (insurance.isChecked()) {
                            //insurance + tax = 2(P*0.001)
                            monthlyPayment = monthlyPayment + 2 * T;
                        } else {
                            //only tax is checked
                            monthlyPayment = monthlyPayment + T;
                        }

                    }
                    else {
                        if (insurance.isChecked()) {

                            monthlyPayment = monthlyPayment + T;
                        } else {
                            //both are not checked
                            // no change on monthlyPayment
                        }
                    }
                    String result = String.format("%1$.2f/month", monthlyPayment);
                    payment.setTextColor(Color.BLACK);
                    payment.setText("Payment: " + result);
                } else {

                    double temp = inteRate / 1200.00;

                    double denominator = 1.00 - Math.pow((1.00 + temp), -N);
                    double numerator = temp;
                    monthlyPayment = P * (numerator / denominator);
                    if (tax.isChecked()) {
                        if (insurance.isChecked()) {

                            monthlyPayment = monthlyPayment + 2 * T;
                        } else {

                            monthlyPayment = monthlyPayment + T;
                        }

                    } else {
                        if (insurance.isChecked()) {

                            monthlyPayment = monthlyPayment + T;
                        } else {
                            //both are not checked
                            // no change on monthlyPayment
                        }
                    }
                    String result = String.format("%1$.2f/month", monthlyPayment);
                    payment.setTextColor(Color.BLACK);
                    payment.setText("Payment: " + result);

                }
            }
            else {

                payment.setText("wrong input");
                payment.setTextColor(Color.RED);
            }
        }
    }


    public int getLoan(String text) {
        int result = 0;
        String[] temp = text.split(" ");
        result = Integer.parseInt(temp[0]);
        return result;
    }
}