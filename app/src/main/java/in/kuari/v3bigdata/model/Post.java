package in.kuari.v3bigdata.model;

import java.util.List;

/**
 * Created by ketan on 25/11/17.
 */

public class Post {

    private long postId;
    private User postedBy;
    private String postedOn;
    List<String> tags;

    public Post() {
    }

    public Post(long postId,String postedBy, String postedOn) {
        this.postId=postId;
        this.postedBy = new User(postedBy);
        this.postedOn = postedOn;
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
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }
}



