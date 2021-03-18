package com.example.android3lesson.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;

import java.util.List;

public class  EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final EmogiGame game;
    private final Listener listener;
    //private HomeFragment game;
//    private final Game<String> game;

    public EmojiAdapter(EmogiGame game, Listener listener) {
        this.game = game;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent,false);
        return new EmojiHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }



    public void addList(List<String> list) {
        game.putCard(list);
        notifyDataSetChanged();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {

        private final Listener listener;
        private final TextView tvCard;

        public EmojiHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.cardClick(card);
                }
            });

            if (card.isFaceUp()) {
                tvCard.setBackgroundColor(View.GONE);
                tvCard.setText(card.getContent());
            } else {
                //tvCard.setBackgroundResource(R.drawable.volk);
                tvCard.setText("sozler");
            }
        }


    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
