package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  private TextView wordItemView;
  private TextView phoneItemView;
  private ImageView imageViewItem;
  private Button buttonItem;
  private ContactListAdapter mAdapter;

  public ContactViewHolder(View itemView, ContactListAdapter adapter) {
    super(itemView);

    wordItemView = itemView.findViewById(R.id.txtName);
    phoneItemView = itemView.findViewById(R.id.txtPhone);
    imageViewItem = itemView.findViewById(R.id.imageView);
    buttonItem = itemView.findViewById(R.id.btnPhone);
    this.mAdapter = adapter;

    itemView.setOnClickListener(this);

    // Đặt biểu tượng điện thoại và thêm sự kiện nhấn vào biểu tượng để gọi điện
    imageViewItem.setImageResource(R.drawable.phone_foreground);
    imageViewItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String phoneNumber = phoneItemView.getText().toString();
        if (!phoneNumber.isEmpty()) {
          Intent intent = new Intent(Intent.ACTION_DIAL);
          intent.setData(Uri.parse("tel:" + phoneNumber));
          view.getContext().startActivity(intent);
        } else {
          Toast.makeText(view.getContext(), "Số điện thoại không khả dụng", Toast.LENGTH_SHORT).show();
        }
      }
    });

    // Thiết lập sự kiện nhấn cho nút để hiển thị hộp thoại thông tin
    buttonItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Thông tin")
                .setMessage("Tên: " + wordItemView.getText().toString() + "\nSố điện thoại: " + phoneItemView.getText().toString())
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
    Toast.makeText(view.getContext(), "Tên: " + wordItemView.getText() + "\nSố điện thoại: " + phoneItemView.getText(), Toast.LENGTH_SHORT).show();
  }

  // Getters
  public TextView getWordItemView() {
    return wordItemView;
  }

  public TextView getPhoneItemView() {
    return phoneItemView;
  }

  public ImageView getImageViewItem() {
    return imageViewItem;
  }

  public Button getButtonItem() {
    return buttonItem;
  }

  // Setters
  public void setWordItemView(TextView wordItemView) {
    this.wordItemView = wordItemView;
  }

  public void setPhoneItemView(TextView phoneItemView) {
    this.phoneItemView = phoneItemView;
  }
}
