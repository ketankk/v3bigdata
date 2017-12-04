package in.kuari.v3bigdata.utils;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ketan on 28/11/17.
 */

public class Utility {

    public   static String timeAgo(String time) throws ParseException {
        if (time==null)
            time=System.currentTimeMillis()+"";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timestamp = sdf.parse(time).getTime();
        long now = System.currentTimeMillis();
        return DateUtils.getRelativeTimeSpanString(timestamp,now,1).toString();
    }
}
