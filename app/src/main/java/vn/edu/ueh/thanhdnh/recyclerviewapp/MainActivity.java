package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
  private static final int REQUEST_CODE_ADD_CONTACT = 1;
  private RecyclerView mRecyclerView;
  private ContactListAdapter mAdapter;
  private LinkedList<Contact> mContactList = new LinkedList<>();
  private FloatingActionButton fabAddContact;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecyclerView = findViewById(R.id.myrecyclerview);
    mAdapter = new ContactListAdapter(this, mContactList);
    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    // Thêm các đối tượng Contact vào danh sách
    mContactList.add(new Contact(1, "Anna", null, "123456789"));
    mContactList.add(new Contact(2, "John", null, "987654321"));
    mContactList.add(new Contact(3, "Michael", null, "555123456"));
    mContactList.add(new Contact(4, "Jenny", null, "555987654"));

    fabAddContact = findViewById(R.id.addContact);
    fabAddContact.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_CONTACT);
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_CODE_ADD_CONTACT && resultCode == RESULT_OK && data != null) {
      String name = data.getStringExtra("name");
      String phone = data.getStringExtra("phone");
      String imageUriString = data.getStringExtra("imageUri");

      // Chuyển đổi imageUriString thành Uri hoặc gán null nếu rỗng
      Uri imageUri = (imageUriString != null && !imageUriString.isEmpty()) ? Uri.parse(imageUriString) : null;

      // Tạo đối tượng Contact mới và thêm vào danh sách
      int newId = mContactList.size() + 1;
      Contact newContact = new Contact(newId, name, imageUri, phone);

      mContactList.add(newContact);
      mAdapter.notifyDataSetChanged();
    }
  }
}
