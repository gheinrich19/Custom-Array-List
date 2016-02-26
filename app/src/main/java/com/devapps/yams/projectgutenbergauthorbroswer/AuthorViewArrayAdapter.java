package com.devapps.yams.projectgutenbergauthorbroswer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yams on 10/11/2015.
 */
public class AuthorViewArrayAdapter extends ArrayAdapter <author> {

    int mResID;
    Context mContext;
    List<author> mListOfAuthors;

    public AuthorViewArrayAdapter(Context context, int resID, List<author> items) {
        super(context, resID, items);
        mResID = resID;
        mContext = context;
        mListOfAuthors = items;
    }


    public View getView(int position, View convertView, ViewGroup parent){

        RelativeLayout mv;
        author selected_auth = getItem(position);
        String selected_first_name = selected_auth.getmFirstName();
        String selected_last_name = selected_auth.getmLastName();


        if ( convertView == null ) {
            mv = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(mResID, mv, true);
        }
        else {
            mv = (RelativeLayout)convertView;
        }


        ((TextView) mv.findViewById(R.id.last_name)).setText(selected_last_name + ",");
        ((TextView) mv.findViewById(R.id.first_name)).setText(selected_first_name);


        ImageView imgv = (ImageView) mv.findViewById(R.id.image);
        Resources res = mContext.getResources();

        Drawable pic = null;
        switch ( position ) {
            case 0: pic = res.getDrawable(R.drawable.hc_andersen); break;
            case 1: pic = res.getDrawable(R.drawable.m_twain); break;
            case 2: pic = res.getDrawable(R.drawable.r_sabatini); break;
            case 3: pic = res.getDrawable(R.drawable.c_dickens); break;
            case 4: pic = res.getDrawable(R.drawable.gd_maupassant); break;
            case 5: pic = res.getDrawable(R.drawable.v_hugo); break;
            case 6: pic = res.getDrawable(R.drawable.leo_tolstoy); break;
            case 7: pic = res.getDrawable(R.drawable.r_kipling); break;
            case 8: pic = res.getDrawable(R.drawable.r_tagore); break;
            case 9: pic = res.getDrawable(R.drawable.w_shakespeare); break;
            default: pic = res.getDrawable(R.drawable.abc_ic_menu_copy_mtrl_am_alpha);
        }

        imgv.setImageDrawable(pic);

        return mv;

    }
}
