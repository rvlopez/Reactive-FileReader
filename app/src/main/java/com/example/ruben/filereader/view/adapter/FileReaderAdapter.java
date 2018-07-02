package com.example.ruben.filereader.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruben.filereader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileReaderAdapter extends RecyclerView.Adapter<FileReaderAdapter.ViewHolder> {

    @Override
    public FileReaderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FileReaderAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.word) TextView word;
        @BindView(R.id.quantity) TextView quantity;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
