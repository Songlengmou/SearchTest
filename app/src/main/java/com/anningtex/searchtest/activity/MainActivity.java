package com.anningtex.searchtest.activity;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.searchtest.R;
import com.anningtex.searchtest.searche.SearchFragment;

/**
 * @author Song
 * desc:搜索 以及 历史记录
 */
public class MainActivity extends AppCompatActivity {
    private EditText mEdSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEdSearch = findViewById(R.id.ed_search);
        mEdSearch.setOnClickListener(v -> {
            SearchFragment searchFragment = SearchFragment.newInstance();
            searchFragment.setOnSearchClickListener(keyword -> {
                if (keyword != null) {
                    //do  something
                }
            });
            searchFragment.showFragment(getSupportFragmentManager(), SearchFragment.TAG);
        });
    }
}
