package com.example.howl.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.howl.LoginActivity;
import com.example.howl.Post;
import com.example.howl.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfilePageFragment extends PostsFragment{

    private static final String TAG = "ProfilePageFragment";
    private TextView textViewName;
    private TextView textViewUsername;
    private Button btnLogout;
    private TextView textViewMajor;
    private TextView textViewClass;

    public ProfilePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_page, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.signout_menu, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_signout:
            default:
                Toast.makeText(getContext(), "Click Registered", Toast.LENGTH_SHORT).show();
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewUsername = view.findViewById(R.id.textViewUsername);
        textViewUsername.setText(ParseUser.getCurrentUser().getUsername().toString());
        textViewName = view.findViewById(R.id.textViewName);
        textViewName.setText(ParseUser.getCurrentUser().get("name").toString().toUpperCase());
        textViewMajor = view.findViewById(R.id.textViewMajor);
        textViewMajor.setText(ParseUser.getCurrentUser().get("major").toString());
        textViewClass = view.findViewById(R.id.textViewClass);
        textViewClass.setText(ParseUser.getCurrentUser().get("class").toString());
    }

    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        //query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts!", e);
                    return;
                }
                for (Post post: posts) {
                    Log.i(TAG, "Post: " + post.getPost() + ", username: " + post.getUser().getUsername());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}