package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Atraccion;

import java.util.ArrayList;

public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.ViewHolder> {

    private ArrayList<Atraccion> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Atraccion unaAtraccion);
    }

    private AtraccionesAdapter.ItemClickListener clickListener;

    public void setClickListener(AtraccionesAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;
        private final TextView tvDescripcion;
        private final TextView tvOcupantes;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvNombre = (TextView) view.findViewById(R.id.tvNombreAtraccion);
            tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcionAtraccion);
            tvOcupantes = (TextView) view.findViewById(R.id.tvNumOcupantes);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String descripcion, int ocupantes) {
            tvNombre.setText(nombre);
            tvDescripcion.setText(descripcion);
            tvOcupantes.setText(String.valueOf(ocupantes));
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
    public AtraccionesAdapter(ArrayList<Atraccion> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AtraccionesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ver_atracciones_row, viewGroup, false);

        return new AtraccionesAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AtraccionesAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Atraccion unaAtraccion = datos.get(position);
        viewHolder.setInfo(unaAtraccion.getNombre(), unaAtraccion.getDescripcion(), unaAtraccion.getOcupantes());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setAtracciones(ArrayList<Atraccion> atracciones){
        datos.clear();
        datos.addAll(atracciones);
        notifyDataSetChanged();
    }
}
