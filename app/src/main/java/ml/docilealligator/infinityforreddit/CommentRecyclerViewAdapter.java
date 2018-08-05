package ml.docilealligator.infinityforreddit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

class CommentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<CommentData> mCommentData;
    private RequestQueue mVoteThingRequestQueue;

    CommentRecyclerViewAdapter(Context context, ArrayList<CommentData> commentData,
                               RequestQueue voteThingRequestQueue) {
        mContext = context;
        mCommentData = commentData;
        mVoteThingRequestQueue = voteThingRequestQueue;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CommentViewHolder) holder).authorTextView.setText(mCommentData.get(position).getAuthor());
        ((CommentViewHolder) holder).commentTimeTextView.setText(mCommentData.get(position).getCommentTime());
        ((CommentViewHolder) holder).commentTextView.setText(mCommentData.get(position).getCommentContent());
        ((CommentViewHolder) holder).scoreTextView.setText(Integer.toString(mCommentData.get(position).getScore()));
        ((CommentViewHolder) holder).upvoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((CommentViewHolder) holder).downvoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCommentData.size();
    }

    private class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView authorTextView;
        private TextView commentTimeTextView;
        private TextView commentTextView;
        private ImageView upvoteButton;
        private ImageView downvoteButton;
        private TextView scoreTextView;
        private ImageView replyButton;

        public CommentViewHolder(View itemView) {
            super(itemView);
            authorTextView = itemView.findViewById(R.id.author_text_view_item_post_comment);
            commentTimeTextView = itemView.findViewById(R.id.comment_time_text_view_item_post_comment);
            commentTextView = itemView.findViewById(R.id.comment_text_view_item_post_comment);
            upvoteButton = itemView.findViewById(R.id.plus_button_item_post_comment);
            downvoteButton = itemView.findViewById(R.id.minus_button_item_post_comment);
            scoreTextView = itemView.findViewById(R.id.score_text_view_item_post_comment);
            replyButton = itemView.findViewById(R.id.reply_button_item_post_comment);
        }
    }
}