package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  public TextView getWordItemView() {
    return wordItemView;
  }

  public ImageView getImageViewItem() {
    return imageViewItem;
  }

  public Button getButtonItem() {
    return buttonItem;
  }

  public void setWordItemView(TextView wordItemView) {
    this.wordItemView = wordItemView;
  }

  private TextView wordItemView;
  private ImageView imageViewItem;
  private Button buttonItem;

  private WordListAdapter mAdapter;

  public WordViewHolder(View itemView, WordListAdapter adapter) {
    super(itemView);
    wordItemView = itemView.findViewById(R.id.textView);
    this.mAdapter = adapter;
    itemView.setOnClickListener(this);
    Button btn = (Button) itemView.findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        TextView tv = (TextView) itemView.findViewById(R.id.textView);
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Info")
          .setMessage("Here is " + tv.getText().toString())
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dialogInterface.dismiss();
            }
          })
          .show();
      }
    });
  }

  @Override
  public void onClick(View view) {
    //ImageView imv = (ImageView) view.findViewById(R.id.imageView);
    TextView tv = (TextView) view.findViewById(R.id.textView);
    //Button btn = (Button) view.findViewById(R.id.button);
    Toast.makeText(view.getContext(), tv.getText(), Toast.LENGTH_SHORT).show();
  }
}
