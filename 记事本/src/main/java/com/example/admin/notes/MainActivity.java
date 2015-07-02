package com.example.admin.notes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_KEY = "extraKey";
    public static final int CONTENT_VALUE = 0;
    public static final int IMAGE_VALUE = 1;
    public static final int VIDEO_VALUE = 2;

    private Button btnContent;
    private Button btnImage;
    private Button btnVideo;

    private ListView lv;
    private MyAdapter myAdapter;
    private NotesDb mNotesDb;
    private SQLiteDatabase mDb;
    private Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnContent = (Button) findViewById(R.id.btn_content);
        btnImage = (Button) findViewById(R.id.btn_image);
        btnVideo = (Button) findViewById(R.id.btn_video);
        btnContent.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnVideo.setOnClickListener(this);

        mNotesDb = new NotesDb(this);
        mDb = mNotesDb.getReadableDatabase();
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddContent.class);
        switch (v.getId()) {
            case R.id.btn_content:
                intent.putExtra(EXTRA_KEY, CONTENT_VALUE);
                startActivity(intent);
                break;
            case R.id.btn_image:
                intent.putExtra(EXTRA_KEY, IMAGE_VALUE);
                startActivity(intent);
                break;
            case R.id.btn_video:
                intent.putExtra(EXTRA_KEY, VIDEO_VALUE);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        showListView();
    }

    private void showListView() {
        mCursor = mDb.query(NotesDb.TABLE_NAME, null, null, null, null, null, null);
        myAdapter = new MyAdapter(this, mCursor);
        lv.setAdapter(myAdapter);
    }
}
