package com.example.brandon.bluetoothexample;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    BluetoothAdapter dBluetoothAdapter ;
    int bTooth_Request = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBluetoothAdapter = BluetoothAdapter.getDefaultAdapter() ;

        if (dBluetoothAdapter == null){
            Toast.makeText(getApplicationContext(), "Bluetooth not enabled", Toast.LENGTH_LONG).show();
            finish() ;
        }

        if (!dBluetoothAdapter.isEnabled()){
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE) ;
            startActivityForResult(enableBluetooth, bTooth_Request);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == bTooth_Request) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getBaseContext(), "Bluetooth was not enabled", Toast.LENGTH_LONG).show();
                finish();
            }
            else if(resultCode == RESULT_OK){
                Toast.makeText(getBaseContext(), "Bluetooth was enabled", Toast.LENGTH_LONG).show();
            }
        }

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
