package com.example.howl;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_POST = "post";
    public static final String KEY_USER = "username";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getPost() {
        return getString(KEY_POST);
    }

    public void setPost(String post) {
        put(KEY_POST, post);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public ParseFile getImage() {
        return getParseFile("profilePic");
    }


}
