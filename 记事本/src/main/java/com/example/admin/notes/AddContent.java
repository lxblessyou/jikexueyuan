package com.example.admin.notes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2015-07-01.
 */
public class AddContent extends Activity implements View.OnClickListener {
    private int extraValue ;
    private ImageView iv;
    private VideoView vv;
    private EditText et;
    private Button  saveBtn;
    private Button cancelBtn;

    private NotesDb mNotesDb;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        Intent intent = getIntent();
        extraValue = intent.getIntExtra(MainActivity.EXTRA_KEY, -1);

        init();
    }

    private void init() {
        mNotesDb = new NotesDb(this);
        mDb = mNotesDb.getWritableDatabase();

        iv = (ImageView) findViewById(R.id.img);
        vv = (VideoView) findViewById(R.id.vv);
        et = (EditText) findViewById(R.id.et);
        saveBtn = (Button) findViewById(R.id.btn_save);
        cancelBtn = (Button) findViewById(R.id.btn_cancel);
        saveBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                addToDb();
                finish();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    private void addToDb() {
        String column = null;
        switch (extraValue) {
            case MainActivity.CONTENT_VALUE:
                column = et.getText().toString().trim();
                break;
            case MainActivity.IMAGE_VALUE:

                break;
            case MainActivity.VIDEO_VALUE:

                break;
            default:
                break;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDb.COLUMN_CONTENT, column);
        contentValues.put(NotesDb.COLUMN_DATE, getTime());
        mDb.insert(NotesDb.TABLE_NAME, null, contentValues);
    }

    public String getTime() {
        String time = null;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        time = simpleDateFormat.format(date);
        return time;
    }
}
