package com.example.pmdm_2324.ut06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;

import java.util.ArrayList;
import java.util.Arrays;

public class u6a1DulceAdapter extends RecyclerView.Adapter<u6a1DulceAdapter.ViewHolder> {

    private ArrayList<DulcesNavideños> datos;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre, frutosSecos, calorias;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.u6a1tvListaNombre);
            frutosSecos = (TextView) view.findViewById(R.id.u6a1tvListaFrutosSecos);
            calorias= (TextView) view.findViewById(R.id.u6a1tvListaCalorias);
        }

        public TextView getTextNombre() {
            return nombre;
        }

        public TextView getTextFrutosSecos() {
            return frutosSecos;
        }
        public TextView getTextCalorias() {
            return calorias;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data_RickAndMorty to populate views to be used
     * by RecyclerView.
     */
    public u6a1DulceAdapter(DulcesNavideños[] dataSet) {
        datos = new ArrayList<DulcesNavideños>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    //Asocia el layout que le digas con el viewholder:
    @Override
    public u6a1DulceAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                //Usamos el layout que creamos aparte para ver como se veria cada uno de los listView
                .inflate(R.layout.u6a1_row_dulce, viewGroup, false);

        return new u6a1DulceAdapter.ViewHolder(view);
    }

    //DUDA IMPORTANTEEE
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(u6a1DulceAdapter.ViewHolder viewHolder, final int position) {


        //NOTA: Aqui se mostrara como tu quieras que se vea en cada fila
        viewHolder.getTextNombre().setText(" -> "+datos.get(position).nombre + " <- " );
        viewHolder.getTextCalorias().setText(datos.get(position).calorias+" cal.");
        viewHolder.getTextFrutosSecos().setText(datos.get(position).frutosSecos? " * Contiene Frutos Secos" : "");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(DulcesNavideños[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
