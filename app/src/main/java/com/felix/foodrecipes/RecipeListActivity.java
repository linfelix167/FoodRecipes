package com.felix.foodrecipes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.felix.foodrecipes.adapters.OnRecipeListener;
import com.felix.foodrecipes.adapters.RecipeRecyclerAdapter;
import com.felix.foodrecipes.models.Recipe;
import com.felix.foodrecipes.util.Testing;
import com.felix.foodrecipes.viewmodels.RecipeListViewModel;

import java.util.List;

public class RecipeListActivity extends BaseActivity implements OnRecipeListener {

    private static final String TAG = RecipeListActivity.class.getSimpleName();

    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecyclerView = findViewById(R.id.recipe_list);

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        initRecyclerView();
        subscribeObservers();
        initSearchView();
    }

    private void subscribeObservers() {
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                if (recipes != null) {
                    Testing.printRecipe(recipes, TAG);
                    mAdapter.setRecipes(recipes);
                }
            }
        });
    }

    private void initRecyclerView() {
        mAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initSearchView() {
        final SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mRecipeListViewModel.searchRecipesApi(s, 1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }
}
