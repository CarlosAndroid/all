package com.codes.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codes.R;

import java.util.ArrayList;

public class Toolbars extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<RecyclerViewData> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewLista);

        setSupportActionBar(toolbar);

        //https://www.youtube.com/watch?v=bcNZtonqhRw

        datos = new ArrayList<RecyclerViewData>();
        for(int i=1; i<51; i++) {
            datos.add(new RecyclerViewData("Título " +i, "Subtítulo " +i));
        }
        // use this setting to improve performance if you know that changes
        // in content do not change the layout_adapter size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout_adapter manager
        mLayoutManager = new LinearLayoutManager(this);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Toast.makeText(this, "Nuevo", Toast.LENGTH_SHORT).show();
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
                Log.i("ActionBar", "Buscar!");
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
