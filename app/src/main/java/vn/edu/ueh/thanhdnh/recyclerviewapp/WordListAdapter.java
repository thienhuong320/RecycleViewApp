package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {
  private LayoutInflater mInflater;
  private LinkedList<String> mWordList;

  public WordListAdapter(Context context, LinkedList<String> wordList) {
    mInflater = LayoutInflater.from(context);
    this.mWordList = wordList;
  }

  @NonNull
  @Override
  public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View mItemView = mInflater.inflate(R.layout.contact_list, parent, false);
    return new WordViewHolder(mItemView, this);

  }

  @Override
  public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
    String mCurrent = mWordList.get(position);
    holder.getWordItemView().setText(mCurrent);
  }

  @Override
  public int getItemCount() {
    return mWordList.size();
  }
}
