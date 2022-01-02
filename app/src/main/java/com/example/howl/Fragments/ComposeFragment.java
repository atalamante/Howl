package com.example.howl.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.howl.MainActivity;
import com.example.howl.Post;
import com.example.howl.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;


public class ComposeFragment extends Fragment {

    private EditText editTextPost;
    private Button btnPost;
    public static final String TAG = "ComposeFragment";

    public ComposeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compose, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextPost = view.findViewById(R.id.editTextPostDescription);
        btnPost = view.findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String post = editTextPost.getText().toString();
                if (post.isEmpty()) {
                    Toast.makeText(getContext(), "The Post cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currUser = ParseUser.getCurrentUser();
                savePost(post, currUser);
            }
        });
    }

    private void savePost(String post, ParseUser currUser) {
        Post newPost = new Post();
        newPost.setPost(post);
        newPost.setUser(currUser);
        newPost.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error while saving!", e);
                    Toast.makeText(getContext(), "Error while saving!", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Post save was successful!");
                editTextPost.setText("");
            }
        });
    }

}