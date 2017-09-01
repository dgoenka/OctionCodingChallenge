package com.divyanshgoenka.octioncodingchallenge.android.util;

import android.util.Log;

import com.divyanshgoenka.octioncodingchallenge.OctionCodingChallengeApplication;
import com.divyanshgoenka.octioncodingchallenge.R;
import com.divyanshgoenka.octioncodingchallenge.util.Constants;


import org.ocpsoft.prettytime.PrettyTime;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.HttpException;

/**
 * Created by divyanshgoenka on 08/08/17.
 */

public class FormatUtils {

    public static final String TAG = "FormatUtils";

    public static String parseForList(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = sdf.parse(dateStr);
        PrettyTime p = new PrettyTime();
        return p.format(date);
    }

    public static String titleForException(Throwable e) {

        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            if(httpException.code()>300)
                return OctionCodingChallengeApplication.getInstance().getString(R.string.connection_error);
            else
                return ""+httpException.code();
        }else if(e instanceof ConnectException || e instanceof UnknownHostException){
            return OctionCodingChallengeApplication.getInstance().getString(R.string.connection_error);
        }
        return e!=null?e.getClass().toString():null;
    }

    public static String contentForException(Throwable e) {

        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            return httpException.message();
        }else if(e instanceof ConnectException || e instanceof UnknownHostException){
            return e.getLocalizedMessage();
        }

        return e!=null?e.getClass().toString():null;
    }

    public static String parseUrl(String media)throws URISyntaxException {
        if(isAbsoluteURL(media))
            return media;
        Log.e(TAG,"returning: "+Constants.Api.API_URL+media);
        return Constants.Api.API_URL+media;
    }

    public static boolean isAbsoluteURL(String url) throws URISyntaxException {
        final URI uri = new URI(url);
        return uri.isAbsolute();
    }

    public static String formatTime(Long endTimeUnix) {
        return new PrettyTime().format(new Date(endTimeUnix*1000));
    }
}
