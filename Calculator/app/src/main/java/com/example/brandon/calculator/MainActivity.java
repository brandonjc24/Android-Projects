package com.example.brandon.calculator;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.Activity;



public class MainActivity extends ActionBarActivity {


    private char operation ;
    private String firstNum = "";
    private String secondNum = "";

    public char getOperation() {
        return operation;
    }

    public String getFirstNum() {
        return firstNum;
    }

    public String getSecondNum() {
        return secondNum;
    }


    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void setFirstNum(String firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(String secondNum) {
        this.secondNum = secondNum;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView ResultTextView = (TextView) findViewById(R.id.Result_Text_view) ;
        ResultTextView.setText("0");

        Button equalB = (Button) findViewById(R.id.buttonEqual) ;
        Button oneB = (Button) findViewById(R.id.button1) ;
        Button twoB = (Button) findViewById(R.id.button2) ;
        Button threeB = (Button) findViewById(R.id.button3) ;
        Button fourB = (Button) findViewById(R.id.button4) ;
        Button fiveB = (Button) findViewById(R.id.button5) ;
        Button sixB = (Button) findViewById(R.id.button6) ;
        Button sevenB = (Button) findViewById(R.id.button7) ;
        Button eightB = (Button) findViewById(R.id.button8) ;
        Button nineB = (Button) findViewById(R.id.button9) ;
        Button zeroB = (Button) findViewById(R.id.button0) ;
        Button addB = (Button) findViewById(R.id.buttonA) ;
        Button subtractB = (Button) findViewById(R.id.buttonS) ;
        Button multiplyB = (Button) findViewById(R.id.buttonM) ;
        Button divideB = (Button) findViewById(R.id.buttonD) ;
        Button clearB = (Button) findViewById(R.id.buttonC) ;
        Button decimalB = (Button) findViewById(R.id.buttondeci) ;

        oneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("1");
            }
        });
        twoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("2");
            }
        });
        threeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("3");
            }
        });
        fourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("4");
            }
        });
        fiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("5");
            }
        });
        sixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("6");
            }
        });
        sevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("7");
            }
        });
        eightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("8");
            }
        });
        nineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultTextView.append("9");
            }
        });
        zeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ResultTextView.getText().toString().equals('0'))
                    ResultTextView.append("0");
            }
        });
        decimalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ResultTextView.getText().toString().contains("."))
                    ResultTextView.append(".");
            }
        });

        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFirstNum("") ;
                setSecondNum("");
                ResultTextView.setText("0") ;
            }
        });

        equalB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getFirstNum() == "")
                    setFirstNum("0");
                if (getSecondNum() == "" && getFirstNum() != ""){
                    if (ResultTextView.getText().toString() == "")
                        ResultTextView.setText("0");
                    setSecondNum(ResultTextView.getText().toString());

                    if (getOperation() == '+'){
                        ResultTextView.setText( String.valueOf(Double.parseDouble(getFirstNum().toString()) + Double.parseDouble(getSecondNum().toString())) );
                    }
                    else if(getOperation() == '-'){
                        ResultTextView.setText( String.valueOf(Double.parseDouble(getFirstNum().toString()) - Double.parseDouble(getSecondNum().toString())) );
                    }
                    else if(getOperation() == '*'){
                        ResultTextView.setText( String.valueOf(Double.parseDouble(getFirstNum().toString()) * Double.parseDouble(getSecondNum().toString())) );
                    }
                    else if(getOperation() == '/'){
                        if (Integer.parseInt(getSecondNum().toString()) != 0)
                            ResultTextView.setText( String.valueOf(Double.parseDouble(getFirstNum().toString()) / Double.parseDouble(getSecondNum().toString())) );
                        else
                            ResultTextView.setText("Invalid operation");
                    }
                }
            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFirstNum() == ""){
                    setFirstNum(ResultTextView.getText().toString()) ;
                    ResultTextView.setText("0") ;
                    setOperation('+');
                }

            }
        });
        subtractB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFirstNum() == ""){ //
                    setFirstNum(ResultTextView.getText().toString()) ;
                    ResultTextView.setText("0") ;
                    setOperation('-');
                }
            }
        });
        multiplyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFirstNum() == ""){ //
                    setFirstNum(ResultTextView.getText().toString()) ;
                    ResultTextView.setText("0") ;
                    setOperation('*');
                }
            }
        });
        divideB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFirstNum() == ""){ //
                    setFirstNum(ResultTextView.getText().toString()) ;
                    ResultTextView.setText("0") ;
                    setOperation('/');
                }
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
