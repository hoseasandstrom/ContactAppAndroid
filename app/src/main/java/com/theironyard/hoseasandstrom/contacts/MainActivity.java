package com.theironyard.hoseasandstrom.contacts;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<Contact> contacts;

    ListView list;
    EditText textName;
    EditText textNumber;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        textName = (EditText) findViewById(R.id.nameBar);
        textNumber = (EditText)findViewById(R.id.numberBar);
        addButton = (Button) findViewById(R.id.add);

        contacts = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String name = textName.getText().toString();
        String number = textNumber.getText().toString();
        Contact contact = new Contact(name, number);
        contacts.add(contact);
        textName.setText("");
        textNumber.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact name = contacts.getItem(position);
        contacts.remove(name);
        return true;
    }
}
