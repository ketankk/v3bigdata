package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 6/12/17.
 */
public class ExampleModel {

    private final long mId;
    private final String mText;

    public ExampleModel(long id, String text) {
        mId = id;
        mText = text;
    }

    public long getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }
}