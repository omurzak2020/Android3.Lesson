package com.example.android3lesson.ui;

import java.io.Serializable;

public class GameModel implements Serializable {
    private String first;
    private String second;
    private boolean knopka=true;

    public GameModel(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public boolean isKnopka() {
        return knopka;
    }

    public void setKnopka(boolean knopka) {
        this.knopka = knopka;
    }
}
