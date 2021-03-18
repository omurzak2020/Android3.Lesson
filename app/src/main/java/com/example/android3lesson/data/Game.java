package com.example.android3lesson.data;

import com.example.android3lesson.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i)));
        }
    }


    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            findPairs(card);
        }
    }

    private void findPairs(Card<CardContent> card) {
        for (Card<CardContent> searchCard : cards) {
            if (searchCard.isFaceUp() &&
                    searchCard.equals(card)) {
                card.setMatched(true);
                searchCard.setMatched(true);
              return;
            }
        }
    }

    public List<Card<CardContent>> getCard() {
        return cards;
    }

}
