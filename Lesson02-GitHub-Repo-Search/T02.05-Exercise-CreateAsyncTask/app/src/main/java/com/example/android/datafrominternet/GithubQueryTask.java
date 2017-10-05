package com.example.android.datafrominternet;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.android.datafrominternet.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by sudhar on 10/5/17.
 */

public class GithubQueryTask extends AsyncTask<URL, Void, String> {

    private TextView mSearchResultsTextView;

    public GithubQueryTask(TextView searchResultsTextView) {
        this.mSearchResultsTextView = searchResultsTextView;
    }

    @Override
    protected String doInBackground(URL... urls) {
        try {
            return NetworkUtils.getResponseFromHttpUrl(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null) {
            mSearchResultsTextView.setText(s);
        }
    }
}
