package com.example.android3lesson.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;
import com.example.android3lesson.ui.EmogiGame;
import com.example.android3lesson.ui.EmojiAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment implements EmojiAdapter.Listener {

    private EmojiAdapter adapter;
    private RecyclerView recyclerView;
    private EmogiGame game;
    Game<String> gGame;
    private List card;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_cards);
        init();
        game = new EmogiGame();
        adapter = new EmojiAdapter(game,this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext() , DividerItemDecoration.VERTICAL));
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.formFragment);
            }
        });
        setFragmentText();
    }

    private void init() {
        recyclerView.setAdapter(adapter);
    }

    private void setFragmentText() {
        getParentFragmentManager().setFragmentResultListener("rk_text",
                getViewLifecycleOwner(),
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String text1 = result.getString("text1");
                        String text2 = result.getString("text2");
//                        adapter.addList(Collections.singletonList(text1));

                      card = new ArrayList();
                        card.add(text1);
                        card.add(text2);

                        gGame = new Game<>(card);
                        adapter.notifyDataSetChanged();


                        Log.e("TAG", "onFragmentResult: " + text1 +" "+ text2 );
                    }
                });
    }

    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();
    }


}