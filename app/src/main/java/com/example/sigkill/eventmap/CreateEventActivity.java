package com.example.sigkill.eventmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class CreateEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

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


    }

    public void  onClickButton(View view) {
        Event event = new Event();
        View parent = (View)view.getParent();
        if (parent != null) {
            event.id = UUID.randomUUID();
            TextView txtView = parent.findViewById(R.id.editText4);
            event.Title = txtView.getText().toString();

            TextView txtView2 = parent.findViewById(R.id.editText5);
            event.Description = txtView2.getText().toString();

            event.Coordinates = getIntent().getParcelableExtra("latlng");

            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("events");

            myRef.child(event.id.toString()).child("id").setValue(event.id.toString());
            myRef.child(event.id.toString()).child("title").setValue(event.Title);
            myRef.child(event.id.toString()).child("desc").setValue(event.Description);
            myRef.child(event.id.toString()).child("coord").setValue(event.Coordinates.toString());

                    //EventSaver.getInstance().store_event(event);
            //Toast.makeText(getApplication(), "123123", Toast.LENGTH_LONG).show();
        }

    }
}
