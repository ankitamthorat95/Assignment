

package com.axxessassignmentapp.application.offline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import com.axxessassignmentapp.application.models.CommentModel;

import java.util.ArrayList;

public class CommentsDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = CommentsDatabaseHelper.class.getSimpleName();

    public final static String DATABASE_NAME = "AxxessAssignmentdb.db";

    public final static String TABLE_COMMENTS = "comments";

    public final static String COL_1 = "id";
    public final static String COL_2 = "imageid";
    public final static String COL_3 = "comment";

    private static final int DATABASE_VERSION = 2;

    private SQLiteDatabase database;
   // private static DatabaseAccess databaseAccess;

    Context context;

    public CommentsDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_COMMENTS+
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," + //0
                "imageid TEXT,"+
                "comment TEXT)");                      //1

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);

    }

    public boolean isCommentAvailable(String imageid) {

        // array of columns to fetch
        String[] columns = {
                COL_1
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria

        String selection = COL_2 + " = ?" ;


        // selection arguments
        String[] selectionArgs = {imageid};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_COMMENTS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    public SQLiteDatabase getDatabase(){
        return this.getWritableDatabase();
    }


     public long addUpdateComment(CommentModel commentModel){
         SQLiteDatabase db = this.getWritableDatabase();
         long  result = 0;

         Cursor c = db.rawQuery("SELECT * FROM "+TABLE_COMMENTS+" WHERE imageid=? OR comment=?", new String[]{commentModel.getImageid(), commentModel.getComment()});
         Log.e(TAG, "ifCommentExists: "+c.getCount() );
         if(c.getCount()>0)
         {
             // update
             result = updateData(commentModel) ;
             Log.e(TAG, "addUpdateComment: update "+result );
             return result;
         }
         else
         {
             //new entry
             result = saveComment(commentModel) ;
             Log.e(TAG, "addUpdateComment: save "+result );
             return result;
         }
     }

     public long saveComment(CommentModel commentModel) {
         SQLiteDatabase db = this.getWritableDatabase();
         Log.e(TAG, "saveNotification: ");

         long response = 0;
         try {
             ContentValues contentValues = new ContentValues();
             contentValues.put(COL_2, commentModel.getImageid());
             contentValues.put(COL_3, commentModel.getComment());
             response = db.insert(TABLE_COMMENTS, null, contentValues);
             //}
         } catch (Exception ex) {
             Log.e(TAG, "saveComment: ", ex);
         } finally {
             db.close();
         }
         return response;
     }

     private long updateData(CommentModel commentModel) {
         int result = 0;
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(COL_2, commentModel.getImageid());
         contentValues.put(COL_3, commentModel.getComment());

         String WHERE =  "imageid='"+commentModel.getImageid()+"' AND comment='"+commentModel.getComment()+"'  ";


         //String WHERE = "senderid='" + id + "OR receiverid='"+id+"'";
         return db.update(TABLE_COMMENTS, contentValues, WHERE, null);

     }

    public ArrayList<CommentModel> GetComments(String imageId) {
       // Log.e(TAG, "GetComments: ");
        SQLiteDatabase database = this.getWritableDatabase();

        ArrayList<CommentModel> commentList = new ArrayList<>();

        try {
           // Cursor dbCcursor = database.rawQuery("select * from "+TABLE_COMMENTS+" where imageid=" + imageId + "", null);
            Cursor dbCcursor = database.rawQuery("select * from "+TABLE_COMMENTS+" WHERE imageid = " + "'" + imageId + "'", null);
            //  Log.e("dbCcursor: ", dbCcursor.toString());

            if (dbCcursor.moveToFirst()) do {
                try {
                    CommentModel comments = new CommentModel();
                    comments.setId(dbCcursor.getInt(0));
                    comments.setImageid(dbCcursor.getString(1));
                    comments.setComment(dbCcursor.getString(2));

                    commentList.add((comments));
                } catch (Exception ex) {
                    Log.e(TAG, "GetComments: " + ex.getMessage());
                }

            } while (dbCcursor.moveToNext());
        } catch (Exception ex) {
            Log.e(TAG, "GetComments: " + ex.getMessage());
        }
        return commentList;
    }


    public void delete(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_COMMENTS,COL_1 + " = ?",new String[] { id });
    }

}
