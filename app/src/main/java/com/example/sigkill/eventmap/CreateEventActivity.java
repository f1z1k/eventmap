package com.example.sigkill.eventmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class CreateEventActivity extends AppCompatActivity {
    public static java.util.Map<String, Event> dict = null;
    public Event event;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        if (dict == null) {
            dict = new HashMap<String, Event>();
        }

        /*DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("events");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })
*/
        //Toast.makeText(getApplication(), getIntent().getParcelableExtra("latlng").toString(), Toast.LENGTH_LONG).show();


        id = getIntent().getStringExtra("id");

        event = dict.get(id);

        Boolean ok = event != null;
        Log.e("CreateEventActivity" + id, ok.toString());

        EditText text = (EditText)findViewById(R.id.editText4);
        text.setText(event != null ? event.Title : "Title", TextView.BufferType.EDITABLE);
        text = (EditText) findViewById(R.id.editText5);
        text.setText(event != null ? event.Description : "Description", TextView.BufferType.EDITABLE);
    }

    public void  onClickButton(View view) {
        View parent = (View)view.getParent();


        if (parent != null) {
            if (event == null) {
                event = new Event();
            }

            TextView txtView = parent.findViewById(R.id.editText4);
            event.Title = txtView.getText().toString();

            TextView txtView2 = parent.findViewById(R.id.editText5);
            event.Description = txtView2.getText().toString();

            event.Coordinates = getIntent().getParcelableExtra("latlng");

            //Intent intent = new Intent(this, MainActivity.class);

            dict.put(id, event);

            //setResult(RESULT_OK, intent);
            finish();
        }
    }
}
