package com.example.android3lesson.ui;

import java.io.Serializable;
import java.util.Objects;

public class GameModel implements Serializable {
    private Object   first;
    private Object second;
    private boolean knopka=true;

    public GameModel(Object first, Object  second) {
        this.first = first;
        this.second = second;
    }


    public Object getFirst() {
        return first;
    }

    public void setFirst(String  first) {
        this.first = first;
    }

    public Object  getSecond() {
        return second;
    }

    public void setSecond(String  second) {
        this.second = second;
    }

    public boolean isKnopka() {
        return knopka;
    }

    public void setKnopka(boolean knopka) {
        this.knopka = knopka;
    }

}
