package com.example.android3lesson.ui;


import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;
import java.util.ArrayList;
import java.util.List;

public class EmogiGame {

    private final Game<String> game;
    private List<String> content;

    public EmogiGame() {
        content = new ArrayList<>();
        content.add("Hello");
        content.add("hi");
        content.add("how are you");
        game = new Game<>(content);
        //content.addList(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
      return game.getCard();
    }

    public void putCard(List<String> list) {
        content.addAll(list);
    }

}
