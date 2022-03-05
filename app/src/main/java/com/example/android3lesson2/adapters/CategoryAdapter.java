package com.example.android3lesson2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.data.room.CategoryModel;
import com.example.android3lesson2.databinding.CategoryHolderBinding;
import com.example.android3lesson2.utils.interfaces.OnCategoryClickListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    OnCategoryClickListener onCategoryClickListener;
    List<CategoryModel> list = new ArrayList<>();

    public void setList(List<CategoryModel> list) {
        this.list = list;
    }

    public void setOnCategoryClickListener(OnCategoryClickListener onCategoryClickListener) {
        this.onCategoryClickListener = onCategoryClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryHolder(CategoryHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        private CategoryHolderBinding binding;

        public CategoryHolder(@NonNull CategoryHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(CategoryModel categoryModel) {
            binding.tvCard.setText(categoryModel.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCategoryClickListener.onClick(categoryModel.getTitle(), getAdapterPosition());
                }
            });

        }
    }
}

