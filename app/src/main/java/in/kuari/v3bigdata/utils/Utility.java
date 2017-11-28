package in.kuari.v3bigdata.utils;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ketan on 28/11/17.
 */

public class Utility {
    /*public static void main(String[] args) throws ParseException {
        System.out.print(timeToAgo("2017-11-11"));
    }*/
  public   static String timeToAgo(String time) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        long timestamp = sdf.parse(time).getTime();
        //  long ti = System.currentTimeMillis() - 10000;
        long now = System.currentTimeMillis();
        return DateUtils.getRelativeTimeSpanString(timestamp,now,1).toString();
    }
}
