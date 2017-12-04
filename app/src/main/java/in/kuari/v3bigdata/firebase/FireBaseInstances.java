package in.kuari.v3bigdata.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ketan on 3/12/17.
 */

public class FireBaseInstances {
    private static FirebaseDatabase  database;
    static private FirebaseDatabase getInstance(){
        if(database==null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        return database;

    }
    public static DatabaseReference getQuestions(){
        DatabaseReference ref = getInstance().getReference("data").child("questions");
        ref.keepSynced(true);
        return ref;

    }
    public static DatabaseReference getTags(){
        DatabaseReference ref = getInstance().getReference("data").child("tags");
        ref.keepSynced(true);
        return ref;
    }
    public static DatabaseReference getTopics(){
        DatabaseReference ref = getInstance().getReference("data").child("topics");
        ref.keepSynced(true);
        return ref;
    }
    public static DatabaseReference getNavMenuList(){
        DatabaseReference ref = getInstance().getReference("view").child("navmenulist");
        ref.keepSynced(true);
        return ref;
    }
}
