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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;
import com.example.android3lesson.ui.EmogiGame;
import com.example.android3lesson.ui.EmojiAdapter;
import com.example.android3lesson.ui.GameModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements EmojiAdapter.Listener {

    private EmojiAdapter adapter;
    private RecyclerView recyclerView;
    private EmogiGame game;

    ArrayList<GameModel> list;

    private Object  text1;
    private Object  text2;


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
                text1 = (Object) result.getSerializable("text");
                text2 = (Object) result.getSerializable("textt");

            }
        });

        addList();

        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.formFragment);
            }
        });
    }

    private void addList() {
        //game = new EmogiGame();
        list = new ArrayList<>();

        adapter = new EmojiAdapter(list, this);
        adapter.addList((GameModel) new GameModel("Ruslan", "Nazar"));
        adapter.addList((GameModel) new GameModel("Azamzhon", " Chyngyz"));
       // adapter.addList((ArrayList<GameModel>) text1,text2);
        recyclerView.setAdapter(adapter);

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