package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * couldn't find anything at said exactly what you guys were looking for with
 * javadocs, so this is it.
 * this is where most of the code is, update and erase functions (I hope) do
 * just that
 */

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, addressField, businessField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        businessField = (EditText) findViewById(R.id.business);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            addressField.setText(receivedPersonInfo.address);
            businessField.setText(receivedPersonInfo.business);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        receivedPersonInfo.setAddress(addressField.getText().toString());
        receivedPersonInfo.setBusiness(businessField.getText().toString());
        receivedPersonInfo.setName(nameField.getText().toString());
        receivedPersonInfo.setNumber(numberField.getText().toString());
        receivedPersonInfo.setProvince(provinceField.getText().toString());
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);
    }

    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
    }
}
