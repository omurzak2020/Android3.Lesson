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
import android.widget.Toast;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;
import com.example.android3lesson.data.Game;
import com.example.android3lesson.ui.EmogiGame;
import com.example.android3lesson.ui.EmojiAdapter;
import com.example.android3lesson.ui.GameModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment implements EmojiAdapter.Listener {

    private EmojiAdapter adapter;
    private RecyclerView recyclerView;
    private EmogiGame game;
    Game<String> gGame;
    private GameModel model;

    ArrayList<GameModel> list;
    private List card;

    private String  text1;
    private String  text2;


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
        getParentFragmentManager().setFragmentResultListener("rk_text", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                text1 = (String) result.getSerializable("text");
                text2 = (String) result.getSerializable("textt");

             /*   adapter.addList((GameModel) new GameModel(text1,text2));
                adapter.addList(text1);*/
            }
        });

        game = new EmogiGame();
        list = new ArrayList<>();

        adapter = new EmojiAdapter(list, this);
        adapter.addList((GameModel) new GameModel("Ruslan", "Nazar"));
        adapter.addList((GameModel) new GameModel("Azamzhon", "Chyngyz"));
        adapter.addList((GameModel) new GameModel(text1,text2));

        //  Log.d("TAG", "init: "+text1+ text2);
        //  adapter.addList((GameModel) new GameModel());
        recyclerView.setAdapter(adapter);


        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.formFragment);
            }
        });
    }

    private void init() {
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();
    }


}