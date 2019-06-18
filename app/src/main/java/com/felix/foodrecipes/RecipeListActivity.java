package com.felix.foodrecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
    }

    public void test(View view) {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            showProgressBar(false);
        } else {
            showProgressBar(true);
        }
    }
}