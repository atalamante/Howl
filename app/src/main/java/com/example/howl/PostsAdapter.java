package com.example.howl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;
    private Bitmap bitmap;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername;
        private TextView tvName;
        private TextView tvPost;
        private TextView tvMajor;
        private TextView tvClass;
        public ImageView ivProfilePicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvName = itemView.findViewById(R.id.tvName);
            tvPost = itemView.findViewById(R.id.tvPost);
            ivProfilePicture = itemView.findViewById(R.id.ivProfilePicture);
            tvMajor = itemView.findViewById(R.id.tvMajor);
            tvClass = itemView.findViewById(R.id.tvClass);
        }

        public void bind(Post post) {
            tvPost.setText(post.getPost());
            tvUsername.setText(post.getUser().getUsername());
            tvName.setText(post.getUser().get("name").toString());
            ParseFile image = post.getUser().getParseFile("profilePic");
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivProfilePicture);
            }
            tvMajor.setText(post.getUser().get("major").toString());
            tvClass.setText(post.getUser().get("class").toString());
        }
    }
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

}
