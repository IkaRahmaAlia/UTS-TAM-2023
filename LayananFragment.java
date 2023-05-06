package com.example.qola;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;
public class LayananFragment extends Fragment {
    ImageView back;
    Button lanjutkan;
    String[] item1 = {"Pakaian Rp3500", "Selimut / Sprei Rp5000", "Gorden Rp7000"};
    String[] item2 = {"Express (2 Jam) + Rp1500", "Reguler (3 Hari) + Rp0"};
    String[] item3 = {"Ya (+ Rp5000)", "Tidak (+ Rp0)"};
    String[] item4 = {"1Kg (+ Rp0)", " Lebih dari 1Kg (dikali setiap kg)"};
    AutoCompleteTextView jenis_barang, paket_laundrynya, antar_jemput, beratLaundrian;
    ArrayAdapter<String> Adapterjenis, paket, antarJemput, beratBarang;
    int harga = 0;
    int totalHarga = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layanan, container, false);
        back = view.findViewById(R.id.iv_back_layanan);
        lanjutkan = view.findViewById(R.id.next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_layananFragment_to_pilihLayananFragment);
            }
        });
        lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungHarga(); // Memanggil method hitungHarga() untuk menghitung harga
            }
        });
        jenis_barang = view.findViewById(R.id.barang);
        paket_laundrynya = view.findViewById(R.id.paket_laundry);
        antar_jemput = view.findViewById(R.id.antar);
        beratLaundrian = view.findViewById(R.id.berat);

        Adapterjenis = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, item1);
        paket = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, item2);
        antarJemput = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, item3);
        beratBarang = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, item4);

        jenis_barang.setAdapter(Adapterjenis);
        paket_laundrynya.setAdapter(paket);
        antar_jemput.setAdapter(antarJemput);
        beratLaundrian.setAdapter(beratBarang);
        return view;
    }
    public void hitungHarga() {
        // hitung harga item1
        if (jenis_barang.getText().toString().equals(item1[0])) {
            harga += 3500;
        } else if (jenis_barang.getText().toString().equals(item1[1])) {
            harga += 5000;
        } else if (jenis_barang.getText().toString().equals(item1[2])) {
            harga += 7000;
        }
        // hitung harga item2
        if (paket_laundrynya.getText().toString().equals(item2[0])) {
            harga += 1500;
        } else if (paket_laundrynya.getText().toString().equals(item2[1])) {
            harga += 0;
        }
        // hitung harga item3
        if (antar_jemput.getText().toString().equals(item3[0])) {
            harga += 5000;
        } else if (antar_jemput.getText().toString().equals(item3[1])) {
            harga += 0;
        }
        // hitung harga item4
        if (beratLaundrian.getText().toString().equals(item4[0])) {
            harga += 0;
        } else if (beratLaundrian.getText().toString().equals(item4[1])) {
            String beratString = beratLaundrian.getText().toString().replaceAll("[^0-9]", ""); // mengambil angka saja dari beratLaundrian
            int berat = Integer.parseInt(beratString);
            harga += berat * 1000;
        }
        totalHarga = harga;
        // Tampilkan total harga pada fragment berbeda
        Bundle bundle = new Bundle();
        bundle.putInt("totalHarga", totalHarga);
        Navigation.findNavController(getView()).navigate(R.id.action_layananFragment_to_totalFragment, bundle);
    }
}