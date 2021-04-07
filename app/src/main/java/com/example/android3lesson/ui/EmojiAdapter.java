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
import java.util.Collection;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final Listener listener;
    private ArrayList<GameModel> list = new ArrayList<>();

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


    public void addList(ArrayList<GameModel> model, Object text2) {
            list.addAll( 0,model);
//            this.list.addAll(0, (Collection<? extends GameModel>) text2);
            notifyDataSetChanged();
    }

    public void addItem(GameModel model) {
           // list.add(model);
            //notifyDataSetChanged();
    }

    public void addList(GameModel azamzhon) {
        list.add(azamzhon);
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

        public void bind(GameModel model) {
            if (model.isKnopka())
                tvCard.setText((CharSequence) model.getFirst());
            else
                tvCard.setText((CharSequence) model.getSecond());
            model.setKnopka(!model.isKnopka());
        }

    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
