package in.kuari.v3bigdata.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

import in.kuari.v3bigdata.utils.Utility;

/**
 * Created by ketan on 25/11/17.
 */

public class Post implements Serializable {

    private long postId;
    private String postTitle;
    private List<String> tags;
    private String topic;
    private String referUrl;
    private User postedBy;
    private String postedOn;

    public Post() {
    }

    public Post(long postId,String postedBy, String postedOn) {
        this.postId=postId;
        this.postedBy = new User(postedBy);
        this.postedOn = postedOn;
    }

    public String getReferUrl() {
        return referUrl;
    }

    public void setReferUrl(String referUrl) {
        this.referUrl = referUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }


    public String getPostedOn() {
        /*try {
            String pon=Utility.timeAgo(postedOn);
            return pon;
        } catch (ParseException e) {


        }*/
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public int compare(Object o, Object t1) {
        Post post1= (Post) o;
        Post post2= (Post) t1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long post2on = sdf.parse(post2.postedOn).getTime();
            long post1on = sdf.parse(post1.postedOn).getTime();
            return (int)(post1on-post2on);

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }


    }
}



