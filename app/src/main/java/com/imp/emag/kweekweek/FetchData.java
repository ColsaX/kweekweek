package com.imp.emag.kweekweek;

import android.os.AsyncTask;
import android.util.Log;

import com.imp.emag.kweekweek.model.OneEvent;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by tzury on 18/05/15.
 */
public class FetchData extends AsyncTask<Void,Void,ArrayList<OneEvent>> {


    private static final String URL_GET="http://www.kweekweek.com/api/v2/events/search?type=events&date_only=10-07-2014";
    private static final String SUMMARY = "summary";
    private static final String DATA = "data";
    private static final String ITEMS = "items";
    private static final String TITLE = "title";
    private static final String FORMATTED_PRICE_FROM = "formatted_price_from";
    private static final String START_AT = "starts_at";
    private static final String CATEGORIES= "categories";
    private static final String NAME="name";
    private static final String THUMB="thumb";
    private static final String HREF="href";
    private static final String LOCATION="location";


    ArrayList<OneEvent> events;

    public FetchData(ArrayList<OneEvent> events) {
        this.events=events;
    }

    @Override
    protected ArrayList<OneEvent> doInBackground(Void... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL_GET);

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            InputStream content = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            String jsonData = builder.toString();
            Log.i("Test data", jsonData);
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject data = jsonObject.getJSONObject(DATA);
            JSONArray jsonEvents = data.getJSONArray(ITEMS);


            for(int i=0; i <jsonEvents.length();i++){
                JSONObject summary = jsonEvents.getJSONObject(i);
                JSONObject event = summary.getJSONObject(SUMMARY);
                JSONArray category = event.getJSONArray(CATEGORIES);
                String categories="";
                for(int j=0; j<category.length();j++){
                    JSONObject oneCategory = category.getJSONObject(j);
                    categories=categories+" "+oneCategory.getString(NAME);
                }
                events.add(new OneEvent(event.getJSONObject(THUMB).getString(HREF), event.getString(TITLE), event.getString(FORMATTED_PRICE_FROM), event.getString(START_AT),event.getString(LOCATION),categories));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return events;
    }

    protected void onPostExecute(ArrayList<OneEvent> result) {
        events=result;
    }

}