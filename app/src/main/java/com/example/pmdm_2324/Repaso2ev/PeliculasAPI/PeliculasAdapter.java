package com.example.pmdm_2324.Repaso2ev.PeliculasAPI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;

import java.util.ArrayList;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder> {

    private ArrayList<Pelicula> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Pelicula unaPelicula);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvTitulo;
        private final TextView tvEstrellas;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvTitulo = (TextView) view.findViewById(R.id.tvTituloPelicula);
            tvEstrellas = (TextView) view.findViewById(R.id.tvEstrellasPeli);
            view.setOnClickListener(this);
        }

        public void setInfo(String titulo, String estrellas) {
            tvTitulo.setText(titulo);
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
    public PeliculasAdapter(ArrayList<Pelicula> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ver_peliculas_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Pelicula unaPelicula = datos.get(position);
        viewHolder.setInfo(unaPelicula.getNombre(), unaPelicula.getStringEstrellas());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas){
        datos.clear();
        datos.addAll(peliculas);
        notifyDataSetChanged();
    }
}
