package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText editName;
    private EditText editPhone;
    private TextView editFile;
    private Button btnSave, btnClear, btnSelectImage;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        // WindowInsets setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Map views
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editFile = findViewById(R.id.editFile);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnSelectImage = findViewById(R.id.btnSelectImage);
        imageView = findViewById(R.id.imageView);

        // Clear button listener
        btnClear.setOnClickListener(v -> {
            editName.setText("");
            editPhone.setText("");
            editFile.setText("");
            imageView.setImageURI(null);
        });

        // Save button listener
//        btnSave.setOnClickListener(v -> {
//            String name = editName.getText().toString();
//            String phone = editPhone.getText().toString();
//
//            Intent resultIntent = new Intent();
//            resultIntent.putExtra("name", name);
//            resultIntent.putExtra("phone", phone);
//            setResult(RESULT_OK, resultIntent);
//            finish();
//        });
        // Save button listener
        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String phone = editPhone.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("phone", phone);
            // Pass the image URI if available
            if (imageView.getTag() != null) {
                resultIntent.putExtra("imageUri", imageView.getTag().toString());
            }
            setResult(RESULT_OK, resultIntent);
            finish();
        });


        // Select Image button listener
        btnSelectImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                imageView.setImageURI(selectedImageUri);
                editFile.setText(selectedImageUri.getLastPathSegment()); // Display filename
                imageView.setTag(selectedImageUri); // Store URI as a tag for later use
            }
        }
    }

}

