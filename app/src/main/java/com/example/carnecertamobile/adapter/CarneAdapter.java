package com.example.carnecertamobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carnecertamobile.R;
import com.example.carnecertamobile.model.Carne;

import java.util.List;

public class CarneAdapter extends RecyclerView.Adapter<CarneAdapter.CarneViewHolder> {

    private List<Carne> carnes;

    public CarneAdapter(List<Carne> carnes) {
        this.carnes = carnes;
    }

    @NonNull
    @Override
    public CarneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carne, parent, false);
        return new CarneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarneViewHolder holder, int position) {
        Carne carne = carnes.get(position);
        holder.txtNome.setText(carne.getNome());
        holder.txtDetalhes.setText(carne.getCategoria() + " | " + carne.getPreferencia());
    }

    @Override
    public int getItemCount() {
        return carnes.size();
    }

    static class CarneViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome;
        TextView txtDetalhes;

        public CarneViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtItemNome);
            txtDetalhes = itemView.findViewById(R.id.txtItemDetalhes);
        }
    }
}
