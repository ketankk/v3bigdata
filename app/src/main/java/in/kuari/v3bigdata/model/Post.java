package in.kuari.v3bigdata.model;

import java.io.Serializable;
import java.text.ParseException;
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
    private User postedBy;
    private String postedOn;

    public Post() {
    }

    public Post(long postId,String postedBy, String postedOn) {
        this.postId=postId;
        this.postedBy = new User(postedBy);
        this.postedOn = postedOn;
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
}



