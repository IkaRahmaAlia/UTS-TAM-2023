package com.example.qola;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PilihLayananFragment extends Fragment {

    ImageView back;
    CardView cuci, cuciLipat, setrika, cuciSetrika;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_pilih_layanan, container, false);
            back = view.findViewById(R.id.iv_back_pilih_layanan);
            cuci = view.findViewById(R.id.cuci);
            cuciLipat = view.findViewById(R.id.cuci_lipat);
            cuciSetrika = view.findViewById(R.id.cuci_setrika);
            setrika = view.findViewById(R.id.setrika);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(view).navigate(R.id.action_pilihLayananFragment_to_homeScreenFragment);
                }
            });

            cuci.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(view).navigate(R.id.action_pilihLayananFragment_to_layananFragment);
                }
            });

            cuciLipat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(view).navigate(R.id.action_pilihLayananFragment_to_layananFragment);
                }
            });

            cuciSetrika.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(view).navigate(R.id.action_pilihLayananFragment_to_layananFragment);
                }
            });

            setrika.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(view).navigate(R.id.action_pilihLayananFragment_to_layananFragment);
                }
            });



            return view;
    }
}