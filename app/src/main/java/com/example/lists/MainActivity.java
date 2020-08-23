package com.example.lists;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listv);

        List<Map<String, String>> content = new ArrayList<>();
        Map<String, String> rowMap;
        String[] arrayContent = getString(R.string.large_text).split("\\n\\n");
        for (int i = 0; i < arrayContent.length; i++) {
            rowMap = new HashMap<>();
            rowMap.put("title", arrayContent[i]);
            rowMap.put("subtitle", String.valueOf(arrayContent[i].length()));
            content.add(rowMap);
        }

        String[] from = new String[]{"title", "subtitle"};
        int[] to = new  int[]{R.id.textViewTitle, R.id.textViewSubtitle};
        SimpleAdapter adapter = new SimpleAdapter(this, content, R.layout.list_item, from, to);
        listView.setAdapter(adapter);

    }

}