package com.example.pmdm_2324.Repaso2ev.PeliculasAPI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Actor;

import java.util.ArrayList;
import java.util.Arrays;

public class ActoresAdapter extends RecyclerView.Adapter<ActoresAdapter.ViewHolder> {

    private ArrayList<Actor> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Actor unActor);
    }

    private ActoresAdapter.ItemClickListener clickListener;

    public void setClickListener(ActoresAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvNombre = (TextView) view.findViewById(R.id.tvNombreActor);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre) {
            tvNombre.setText(nombre);
        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null)
                clickListener.onClick(view, getAdapterPosition(), datos.get(getAdapterPosition()));
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data_RickAndMorty to populate views to be used
     *                by RecyclerView.
     */
    public ActoresAdapter(ArrayList<Actor> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActoresAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ver_actores_row, viewGroup, false);

        return new ActoresAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ActoresAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Actor unActor = datos.get(position);
        viewHolder.setInfo(unActor.getNombre());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setActores(Actor[] actores) {
        datos.clear();
        datos.addAll(Arrays.asList(actores));
        notifyDataSetChanged();
    }
}
