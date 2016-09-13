package com.example.ifpb.testeapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements TextWatcher {


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> nomes = new ArrayList<String>();
        nomes.add("JOÃO");
        nomes.add("MARIA");
        nomes.add("JOSÉ");
        nomes.add("JOAQUIM");
        nomes.add("EMANUEL");

        ArrayAdapter<String> nomeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);

        ListView listView = (ListView) findViewById(R.id.nomesListView);
        listView.setAdapter(nomeAdapter);

        EditText nomeEditText = (EditText)  findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i("MostrarnomeActivity", "beforeTextChanged");
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("MostrarnomeActivity", "onTextChanged");

        TextView nomeEditText = (TextView) findViewById(R.id.nomeEditText);
        nomeEditText.setText(s);

        // interar na lista de nomes e verificar qual nome é igual a busca = s



    }

    public void afterTextChanged(Editable s) {
        Log.i("MostrarnomeActivity", "afterTextChanged");
    }


}