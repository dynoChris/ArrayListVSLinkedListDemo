package com.oliverstudio.arraylistvslinkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private static final int LIST_SIZE = 1_000_000;
    private static final int COUNT_DIFFERENT_WORDS = 2000;
    private static final int INDEX_START_PUSHING = LIST_SIZE / 2;
    private static final String DIFFERENT_WORD = "World";

    private Button mPopulateArrayListButton, mPopulateLinkedListButton;
    private Button mDelFromCenterArrayButton, mDelFromCenterLinkedButton;

    private ArrayList<String> mStringArrayList = new ArrayList<>();
    private LinkedList<String> mStringLinkedList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mPopulateArrayListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("devptag", "Start populate ArrayList");
                for (int i = 0; i < LIST_SIZE; i++) {
                    mStringArrayList.add("Hello");
                    if (i==INDEX_START_PUSHING) {
                        for (int j = 0; j < COUNT_DIFFERENT_WORDS; j++) {
                            mStringArrayList.add(DIFFERENT_WORD);
                        }
                    }
                }
                Log.d("devptag", "Finished ArrayList");
                Log.d("devptag", "ArrayListList: " + mStringArrayList.toString());
            }
        });


        mDelFromCenterArrayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("devptag", "Start removing ArrayList");
                for (int i = 0; i < mStringArrayList.size(); i++) {
                    if(TextUtils.equals(mStringArrayList.get(i), DIFFERENT_WORD)) {
                        mStringArrayList.remove(i--);
                    }
                }
                Log.d("devptag", "Finishing removing ArrayList");
                Log.d("devptag", "ArrayList: " + mStringArrayList.toString());
            }
        });

        //********************************************************
        //LinkedList
        //********************************************************
        mPopulateLinkedListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("devptag", "Start populate LinkedList");
                for (int i = 0; i < LIST_SIZE; i++) {
                    mStringLinkedList.add("Hello");
                    if (i==INDEX_START_PUSHING) {
                        for (int j = 0; j < COUNT_DIFFERENT_WORDS; j++) {
                            mStringLinkedList.add(DIFFERENT_WORD);
                        }
                    }
                }
                Log.d("devptag", "Finished LinkedList");
                Log.d("devptag", "LinkedList: " + mStringLinkedList.toString());
            }
        });

        mDelFromCenterLinkedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("devptag", "Start removing LinkedList");

                ListIterator<String> iterator = mStringLinkedList.listIterator();
                while (iterator.hasNext()) {
                    String value = iterator.next();
                    if (TextUtils.equals(value, DIFFERENT_WORD)) {
                        iterator.remove();
                    }
                }

                Log.d("devptag", "Finishing removing LinkedList");
                Log.d("devptag", "LinkedList: " + mStringLinkedList.toString());
            }
        });
    }

    private void initViews() {
        mPopulateArrayListButton = findViewById(R.id.array_btn);
        mPopulateLinkedListButton = findViewById(R.id.linked_btn);

        mDelFromCenterArrayButton = findViewById(R.id.array_del_center_btn);
        mDelFromCenterLinkedButton = findViewById(R.id.linked_del_center_btn);
    }
}
