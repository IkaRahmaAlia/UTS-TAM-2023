package com.example.qola;


import com.example.qola.LayananFragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class TotalFragment extends Fragment {

    ImageView back;

    TextView total;
    Button qopay, cod;

    int totalHarga;

    LayananFragment layananFragment = new LayananFragment();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_total, container, false);
        back = view.findViewById(R.id.iv_back_total);
        qopay = view.findViewById(R.id.btn_qopay_payment);
        cod = view.findViewById(R.id.btn_cod);
        total = view.findViewById(R.id.biaya);
        // Mengambil nilai totalHarga dari bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            int totalHarga = bundle.getInt("totalHarga", 0);
            total.setText("Rp" + totalHarga);
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_totalFragment_to_layananFragment);
            }
        });
        qopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_totalFragment_to_OTPFragment);
            }
        });
        return view;

    }
}