package com.lightwave.simpleasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

class SimpleAsyncTask extends  AsyncTask <Void, Integer, String>{

    private final static String logTag = SimpleAsyncTask.class.getSimpleName();
    private WeakReference<TextView> mTextView;
    private WeakReference<TextView> mProgressView;


    public SimpleAsyncTask(TextView tv)
    {
        mTextView = new WeakReference<>(tv);
        mProgressView = new WeakReference<>(tv);
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(logTag, "Values: " +values[0]);
        mTextView.get().setText(String.valueOf(values[0]));
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 2000;

        int i = 0;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "Slept for " +s +"milliseconds";
    }
}
