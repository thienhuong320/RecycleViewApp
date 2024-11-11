package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
  private LayoutInflater mInflater;
  private List<Contact> mContactList;  // Chỉnh lại kiểu danh sách thành List<Contact>
  private Context mContext;

  public ContactListAdapter(Context context, List<Contact> contactList) {
    mInflater = LayoutInflater.from(context);
    this.mContactList = contactList;
    this.mContext = context;
  }

  @NonNull
  @Override
  public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View mItemView = mInflater.inflate(R.layout.contact_list, parent, false);
    return new ContactViewHolder(mItemView, this);
  }

  @Override
  public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
    Contact currentContact = mContactList.get(position);

    holder.getWordItemView().setText(currentContact.getName());
    holder.getPhoneItemView().setText(currentContact.getTelephone());
    if (currentContact.getImageUri() != null) {
      holder.getImageViewItem().setImageURI(currentContact.getImageUri());
    } else {
      holder.getImageViewItem().setImageResource(R.drawable.android_icon); // Hình ảnh mặc định nếu không có
    }

    // Sự kiện khi nhấn vào toàn bộ mục liên hệ để mở DetailActivity
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra("contactId", currentContact.getId());
        intent.putExtra("contactName", currentContact.getName());
        intent.putExtra("contactPhone", currentContact.getTelephone());
        intent.putExtra("contactPhoto", currentContact.getImageUri());
        mContext.startActivity(intent);
      }
    });

    // Sự kiện khi nhấn vào nút Dial để thực hiện gọi điện
    holder.getButtonItem().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + currentContact.getTelephone()));
        mContext.startActivity(dialIntent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mContactList.size();
  }
}