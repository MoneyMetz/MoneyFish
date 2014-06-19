package com.cal.moneyfish.project;

/**
 * Created by jjmetzler on 5/31/14.
 */


    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;

    import java.util.ArrayList;
    import java.util.HashMap;

    public class SessionManager {

        // Shared Preferences
        SharedPreferences pref;

        // Editor for Shared preferences
        SharedPreferences.Editor editor;

        // Context
        Context _context;

        // Shared pref mode
        int PRIVATE_MODE = 0;

        // Sharedpref file name
        private static final String PREF_NAME = "GPO_Preferences";

        // All Shared Preferences Keys
        private static final String IS_LOGIN = "IsLoggedIn";

        // User access keys (make variables public to access from outside)
        public static final String KEY_UID = "uid";
        public static final String KEY_NAME = "name";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_PHONE = "phone";
        public static final String KEY_FACEBOOK = "facebook";
        public static final String KEY_GOOGLE = "google";
        public static final String KEY_DISCOVER = "discoverable";
        public static final String KEY_PROMPT = "prompt_approval";
        //public static final String[] KEY_PROJECTS = "projects_list";

        // Constructor
        public SessionManager(Context context){
            this._context = context;
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }

        /**
         * Create login session
         * */
        public void createSession(String uid, String name, String email, String phone, String facebook, String google){
            // Storing login value as TRUE
            editor.putBoolean(IS_LOGIN, true);

            // Storing user information in pref
            editor.putString(KEY_UID, uid);
            editor.putString(KEY_NAME, name);
            editor.putString(KEY_EMAIL, email);
            editor.putString(KEY_PHONE, phone);
            editor.putString(KEY_FACEBOOK, facebook);
            editor.putString(KEY_GOOGLE, google);

            // commit changes
            editor.commit();
        }

        public void settingsSession( String discoverable){
            // Storing login value as TRUE
            editor.putBoolean(IS_LOGIN, true);

            // Storing user information in pref
            editor.putString(KEY_DISCOVER, discoverable);

            // commit changes
            editor.commit();
        }

   /* public void projectsSession( ArrayList<String> pids){
        for(int i = 0; i < pids.size();i++){
            editor.
        }
    }*/

        /**
         * Check login method wil check user login status
         * If false it will redirect user to login page
         * Else won't do anything
         * */
        //TODO
        //check logged in flag to see if they already have a uid.
        //if yes then get uid from shared preferences.
        //if not then create new row in db and put new uid in shared preferences.
        /*
         public void checkLogin(){
            // Check login status
            if(!this.isLoggedIn()){
                // user is not logged in redirect him to Login Activity
                Intent i = new Intent(_context, LoginActivity.class);
                // Closing all the Activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // Add new Flag to start new Activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Staring Login Activity
                _context.startActivity(i);
            }

        }
*/



        /**
         * Get stored session data
         * */
        public HashMap<String, String> getUserDetails(){
            HashMap<String, String> user = new HashMap<String, String>();
            // user details
            user.put(KEY_UID, pref.getString(KEY_UID, null));
            // return user
            return user;
        }





    }

