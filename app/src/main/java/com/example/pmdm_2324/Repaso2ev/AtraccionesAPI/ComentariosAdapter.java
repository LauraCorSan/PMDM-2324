package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Comentario;

import java.util.ArrayList;

public class ComentariosAdapter  extends RecyclerView.Adapter<ComentariosAdapter.ViewHolder> {

    private ArrayList<Comentario> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Comentario unComentario);
    }

    private ComentariosAdapter.ItemClickListener clickListener;

    public void setClickListener(ComentariosAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvComentario;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvComentario = (TextView) view.findViewById(R.id.tvTextoComentario);
            view.setOnClickListener(this);
        }

        public void setInfo(String comentario) {
            tvComentario.setText(comentario);
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
    public ComentariosAdapter(ArrayList<Comentario> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ComentariosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ver_comentarios_row, viewGroup, false);

        return new ComentariosAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ComentariosAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Comentario unComentario = datos.get(position);
        viewHolder.setInfo(unComentario.getTexto());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setComentarios(ArrayList<Comentario> comentarios){
        datos.clear();
        datos.addAll(comentarios);
        notifyDataSetChanged();
    }
}
