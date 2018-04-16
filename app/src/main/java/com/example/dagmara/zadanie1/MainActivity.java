package com.example.dagmara.zadanie1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ListView listView;
    private List<String> l1;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//glowna warstwa
        getElementsFromLayout();

        l1 = new ArrayList<>();
        Collections.addAll(l1);

        adapter = new ArrayAdapter<>(this, R.layout.activity_main2, R.id.rowTextView, l1);//druga warstwa nachodzaca na glowna
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//wprowadzanie danych
                String text = editText.getText().toString();
                editText.setText("");

                l1.add(text);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void l1Remove(View v) { //przycisk usuwania elementow listy
        final int position = listView.getPositionForView((View) v.getParent());
        l1.remove(position);
        adapter.notifyDataSetChanged();
    }

    private void getElementsFromLayout() { //elementy warstw
        button = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.l1_list);
    }
}