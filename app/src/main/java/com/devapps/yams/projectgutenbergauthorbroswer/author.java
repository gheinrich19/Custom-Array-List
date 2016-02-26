package com.devapps.yams.projectgutenbergauthorbroswer;

/**
 * Created by yams on 10/11/2015.
 */
public class author {


    private String mFirstName = "";
    private String mLastName = "";


    public author (String fn, String ln){

        mFirstName = fn;
        mLastName = ln;

    }

   public String getmFirstName(){

       return mFirstName;
   }

    public String getmLastName(){

        return mLastName;
    }

    public String toString(){

        return mFirstName + " " + mLastName;
    }

 }

