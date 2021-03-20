package com.example.android3lesson.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;

import java.util.ArrayList;
import java.util.List;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final Listener listener;
    private ArrayList<GameModel> list = new ArrayList<>();
    //private HomeFragment game;
//    private final Game<String> game;

    public EmojiAdapter(ArrayList<GameModel> list, Listener listener) {
        this.list = list;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(v -> {
            holder.bind(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void addList(GameModel model) {
            list.add( model);
            notifyDataSetChanged();
    }

 /*   public void addList(GameModel text1, GameModel text2) {
        list.add( text1);
        list.add( text2);
        notifyDataSetChanged();
    }*/


    class EmojiHolder extends RecyclerView.ViewHolder {

        private final Listener listener;
        private final TextView tvCard;

        public EmojiHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            tvCard = itemView.findViewById(R.id.tv_card);

        }

        public void bind(GameModel model) {
            if (model.isKnopka())
                tvCard.setText(model.getFirst());
            else
                tvCard.setText(model.getSecond());
            model.setKnopka(!model.isKnopka());
        }

    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
