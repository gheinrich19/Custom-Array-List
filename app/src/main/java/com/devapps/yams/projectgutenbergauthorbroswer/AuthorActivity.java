                                /****************************************************************************
                                 ****** Author: Gage Heinrich    ********************************************
                                 ****** Project_Gutenberg_Author_Browser_2 ************************************
                                 ****** CS3200 Mobile Apps       ********************************************
                                 ****** 10/11/2015               *********************************************
                                 ************************************************************************** */

package com.devapps.yams.projectgutenbergauthorbroswer;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

                                /**
 * Created by yams on 10/3/2015.
 */
public class AuthorActivity extends ListActivity  {
 private static int index;
 private static Resources mRes= null;
 private static String[] mAuthorArray;
 private static String[] mAuthorArrayURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_gmain);


        mRes = getResources();

        Bundle extras = getIntent().getExtras();
              if (extras != null) {
          index = extras.getInt("name");

             switch(index) {

                 case 0:
                     mAuthorArray = mRes.getStringArray(R.array.andersens_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.andersens_urls);
                     break;

                 case 1:
                     mAuthorArray = mRes.getStringArray(R.array.twains_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.twains_urls);
                     break;

                 case 2:
                     mAuthorArray = mRes.getStringArray(R.array.sabatinis_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.sabatinis_urls);
                     break;

                 case 3:
                     mAuthorArray = mRes.getStringArray(R.array.dickens_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.dickens_urls);
                     break;

                 case 4:
                     mAuthorArray = mRes.getStringArray(R.array.maupassants_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.maupassants_urls);
                     break;
                 case 5:
                     mAuthorArray = mRes.getStringArray(R.array.hugos_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.hugos_urls);
                     break;
                 case 6:
                     mAuthorArray = mRes.getStringArray(R.array.tolstoys_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.tolstoys_urls);
                     break;
                 case 7:
                     mAuthorArray = mRes.getStringArray(R.array.kiplings_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.kiplings_urls);
                     break;
                 case 8:
                     mAuthorArray = mRes.getStringArray(R.array.tagores_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.tagores_urls);
                     break;
                 case 9:
                     mAuthorArray = mRes.getStringArray(R.array.shakespeares_titles);
                     mAuthorArrayURL = mRes.getStringArray(R.array.shakespeares_urls);
                     break;
                 default:
                     mAuthorArray = null;
                     mAuthorArrayURL = null;
                     break;


             }
                  getListView().setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mAuthorArray));
                  getListView().setTextFilterEnabled(true);
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Trying to get a string from my object made from a listview. Kept getting value of the object not the listview content.
        /*Object passTheString = l.getItemAtPosition(position);
        String myString = passTheString.toString();
        Intent intent = new Intent(getApplicationContext(), MyWebView.class);
        intent.putExtra("webby", myString );
        startActivity(intent);
        */

        Uri uri = Uri.parse(mAuthorArrayURL[position]);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}
