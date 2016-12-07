package com.example.mac.infolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Archita on 10-07-2016.
 */
public class Main2Activity extends AppCompatActivity {
    ListView list;
    String[] web = {
            "Weight Loss",
            "Workout",
            "Flexibility",


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayAdapter adapter = new
                ArrayAdapter(this,
                R.layout.notes_row, web);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Main2Activity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                if (position ==0){
                    //code specific to first list them
                    Intent myIntent = new Intent(view.getContext(),Main7Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position==1){
                    Intent myIntent = new Intent(view.getContext(),Main5Activity.class);
                    startActivityForResult(myIntent,0);
                }
                if (position==2){
                    Intent myIntent = new Intent(view.getContext(),Main6Activity.class);
                    startActivityForResult(myIntent,0);
                }

            }
        });
    }

}
