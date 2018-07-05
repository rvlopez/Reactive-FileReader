package com.example.ruben.filereader.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruben.filereader.R;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileReaderAdapter extends RecyclerView.Adapter<FileReaderAdapter.ViewHolder> {

    private Map<String, Integer> wordsMap;
    private Object[] keySetArray;

    @Inject public FileReaderAdapter() {
        setHasStableIds(true);
    }

    @Override
    public FileReaderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FileReaderAdapter.ViewHolder holder, int position) {
        String key = keySetArray[position].toString();
        holder.word.setText(key);
        holder.quantity.setText(String.valueOf(wordsMap.get(key)));
    }

    @Override
    public int getItemCount() {
        return wordsMap.size();
    }

    @Override
    public long getItemId(int position) {
        if (getEntry(position) != null) {
            return getEntry(position).getValue();
        } else {
            return 0;
        }
    }

    public void setMapKeyArray(Map<String, Integer> wordsMap, Object[] keySetArray) {
        this.wordsMap = wordsMap;
        this.keySetArray = keySetArray;
        notifyDataSetChanged();
    }

    private Map.Entry<String, Integer> getEntry(int position) {
        int i = 0;

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (i++ == position) {
                return entry;
            }
        }

        return null;
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
