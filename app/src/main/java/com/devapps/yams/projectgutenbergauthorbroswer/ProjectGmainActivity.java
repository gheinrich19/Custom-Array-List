package com.devapps.yams.projectgutenbergauthorbroswer;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class ProjectGmainActivity extends ListActivity  {
    private static String[] mListOfAuthors;
    private static Resources mRes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_gmain);

        mRes = getResources();
        mListOfAuthors = mRes.getStringArray(R.array.gutenberg_authors);

        /* this  creates an array list of object type authors
        * creates a new instance of one that is empty. it then populates then
        * takes the java insance object created form the xml array of authors and
        * uses sp;it and trim to put string parameters into and instance object
        * of type author*/
        ArrayList<author> authors = new ArrayList<author>();
        for(String bigName : mListOfAuthors){

            String [] theFirstLastName = bigName.trim().split(" ");
            authors.add(new author(theFirstLastName[0], theFirstLastName[1]));

        }
        AuthorViewArrayAdapter Myadptr = new AuthorViewArrayAdapter(this, R.layout.author_view,authors);
       //
       // getListView().setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListOfAuthors));

        getListView().setAdapter(Myadptr);



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {


      Intent intent = new Intent(getApplicationContext(), AuthorActivity.class);
        intent.putExtra("name", position);
        startActivity(intent);


       // Toast.makeText(this, "" + v. , Toast.LENGTH_SHORT).show();

    }





}
