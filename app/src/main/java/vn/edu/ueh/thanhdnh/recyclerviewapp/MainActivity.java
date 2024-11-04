package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
  RecyclerView mRecyclerView;
  ContactListAdapter mAdapter;
  LinkedList<String> mWordList = new LinkedList<String>(){{
    add("Anna");
    add("John");
    add("Michael");
    add("Jenny");
    add("Bob");
    add("Smith");
    add("Marry");
    add("Harry");
    add("Lilly");
    add("Berry");
    add("Tom");
    add("Jack");
    add("Mandy");
  }};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    mRecyclerView = findViewById(R.id.myrecyclerview);
    mAdapter = new ContactListAdapter(this, mWordList);
    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
  }
}
