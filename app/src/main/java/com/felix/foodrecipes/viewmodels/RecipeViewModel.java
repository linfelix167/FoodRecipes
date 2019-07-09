package com.felix.foodrecipes.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.felix.foodrecipes.models.Recipe;
import com.felix.foodrecipes.repositories.RecipeRepository;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;
    private String mRecipeId;
    private boolean mDidRetrieveRecipe;

    public RecipeViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
        mDidRetrieveRecipe = false;
    }

    public LiveData<Recipe> getRecipe() {
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId) {
        mRecipeId = recipeId;
        mRecipeRepository.searchRecipeById(recipeId);
    }

    public String getRecipeId() {
        return mRecipeId;
    }

    public boolean didRetrieveRecipe() {
        return mDidRetrieveRecipe;
    }

    public void setRetrieveRecipe(boolean retrieveRecipe) {
        this.mDidRetrieveRecipe = retrieveRecipe;
    }

    public LiveData<Boolean> isRecipeRequestTimedOut() {
        return mRecipeRepository.isRecipeRequestTimedOut();
    }
}
