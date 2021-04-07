package com.example.android3lesson.ui;


import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;

import java.util.ArrayList;
import java.util.List;

public class EmogiGame {

    private final Game<String> game;
    private List<String> list;

    public EmogiGame() {
        list = new ArrayList<>();
//        content.add("how are you");
        game = new Game<>(list);
        //content.addList(content);
    }


    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
      return game.getCard();
    }

    public void putCard(List<String> list) {
        list.addAll(list);
    }

}
