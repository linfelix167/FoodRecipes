package com.felix.foodrecipes.util;

import android.util.Log;

import com.felix.foodrecipes.models.Recipe;

import java.util.List;

public class Testing {

    public static void printRecipe(List<Recipe> list, String tag) {
        for (Recipe recipe : list) {
            Log.d(tag, "onChanged: " + recipe.getTitle());
        }
    }
}
