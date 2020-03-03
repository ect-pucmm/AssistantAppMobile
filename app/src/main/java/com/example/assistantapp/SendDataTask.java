package com.example.assistantapp;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;

public class SendDataTask extends AsyncTask<JSONObject, Void, Result> {

    private final Response.Listener listener;
    private final Response.ErrorListener errorListener;

    public SendDataTask(Response.Listener listener, Response.ErrorListener errorListener) {
        this.listener = listener;
        this.errorListener = errorListener;
    }

    @Override
    protected Result doInBackground(JSONObject... params) {


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Result<>("Success");
    }

    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        if (result.getResult() == null) {
            Log.wtf("ERROR", "HttpPostTask: Result was null");
            errorListener.onErrorResponse(result.getError());
        } else {
            listener.onResponse(result.getResult());
        }
    }

    @Override
    protected void onCancelled() {
        errorListener.onErrorResponse(new Exception("Task cancelled"));
    }
}
