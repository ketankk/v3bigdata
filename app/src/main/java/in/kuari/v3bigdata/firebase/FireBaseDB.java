package in.kuari.v3bigdata.firebase;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ketan on 3/12/17.
 */

public class FireBaseDB {
    private static FirebaseDatabase  database;
    static public FirebaseDatabase getInstance(){
        if(database==null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        return database;

    }
}
