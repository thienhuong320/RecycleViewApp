package vn.edu.ueh.thanhdnh.recyclerviewapp;

import android.net.Uri;

public class Contact {
    private int id;
    private String name;
    private Uri imageUri;
    private String telephone;

    // Constructor
    public Contact(int id, String name, Uri imageUri, String telephone) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
        this.telephone = telephone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters
    public Uri getImageUri() {
        return imageUri;
    }



    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // toString method
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + imageUri  + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
