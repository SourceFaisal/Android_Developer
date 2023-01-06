package id.ac.poliban.e020320066.homework4_5;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface RecipeListAdapterr {
    @NonNull
    RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position);

    int getItemCount();
}
