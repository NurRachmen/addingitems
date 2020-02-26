package com.example.addingitemsrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    Context context;
    List<String> message;

    public MessageAdapter(Context context) {
        this.context = context;

        message = new ArrayList<>();

    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {

        String displayMessage = message.get(position);

        holder.textView.setText(displayMessage);

    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview);

        }
    }

    public void addItems(String msg){
        message.add(msg);
        notifyItemChanged(message.size() - 1);
    }

}
