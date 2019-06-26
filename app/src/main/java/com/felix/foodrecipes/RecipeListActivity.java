package com.felix.foodrecipes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.felix.foodrecipes.models.Recipe;
import com.felix.foodrecipes.requests.RecipeApi;
import com.felix.foodrecipes.requests.ServiceGenerator;
import com.felix.foodrecipes.requests.responses.RecipeResponse;
import com.felix.foodrecipes.requests.responses.RecipeSearchResponse;
import com.felix.foodrecipes.util.Constants;
import com.felix.foodrecipes.util.Testing;
import com.felix.foodrecipes.viewmodels.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = RecipeListActivity.class.getSimpleName();

    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        subscribeObservers();
    }

    public void test(View view) {
        testRetrofitRequest();
    }

    private void subscribeObservers() {
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                if (recipes != null) {
                    Testing.printRecipe(recipes, TAG);
                }
            }
        });
    }

    public void searchRecipesApi(String query, int pageNumber) {
        mRecipeListViewModel.searchRecipesApi(query, pageNumber);
    }

    private void testRetrofitRequest() {
        searchRecipesApi("chicken breast", 1);
    }
}
