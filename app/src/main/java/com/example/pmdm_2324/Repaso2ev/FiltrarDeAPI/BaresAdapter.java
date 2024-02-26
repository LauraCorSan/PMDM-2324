package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.Bar;

import java.util.ArrayList;

public class BaresAdapter extends RecyclerView.Adapter<BaresAdapter.ViewHolder>{
    private ArrayList<Bar> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Bar unBar);
    }

    private BaresAdapter.ItemClickListener clickListener;

    public void setClickListener(BaresAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;

        private final TextView tvEstrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvNombre = (TextView) view.findViewById(R.id.tvNombreBar);
            tvEstrellas = (TextView) view.findViewById(R.id.tvNumEstrellas);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String estrellas) {
            tvNombre.setText(nombre);
            tvEstrellas.setText(estrellas);
        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition(), datos.get(getAdapterPosition()));
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data_RickAndMorty to populate views to be used
     * by RecyclerView.
     */
    public BaresAdapter(ArrayList<Bar> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BaresAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ver_bares_row, viewGroup, false);

        return new BaresAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BaresAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Bar unBar = datos.get(position);
        viewHolder.setInfo(unBar.getNombre(), unBar.getStringEstrellas());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setBares(ArrayList<Bar> bares){
        datos.clear();
        datos.addAll(bares);
        notifyDataSetChanged();
    }
}
