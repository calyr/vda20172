package mobile.calyrsoft.com.vda2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.model.Gastronomia;

/**
 * <p> The GastronomiaAdapter class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class GastronomiaAdapter extends RecyclerView.Adapter<GastronomiaAdapter.ViewHolder> {
    private static final String TAG = "GastronomiaAdapter";

    //private String[] mDataSet;
    private ArrayList<Gastronomia> mDataSet;
    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView comollegar;
        //private final TextView titulo;
        private final TextView descripcion;
        private final ImageView imagenId;
        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            comollegar = (TextView) v.findViewById(R.id.gaComollegar);
            //titulo = (TextView) v.findViewById(R.id.gatitulo);
            descripcion = (TextView) v.findViewById(R.id.gadescripcion);
            imagenId = (ImageView) v.findViewById(R.id.gaId);
        }

        public TextView getComollegar() {
            return comollegar;
        }
        /* public TextView getTitulo() {
             return titulo;
         }*/
        public TextView getDescripcion() {
            return descripcion;
        }

        public ImageView getImagenId(){
            return imagenId;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public GastronomiaAdapter(ArrayList<Gastronomia> dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gastronomia_row, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
//        viewHolder.getTextView().setText(mDataSet.[position]);
        Log.d(TAG, "Descripcion " + mDataSet.get(position).getDescripcion() + " set.");
        viewHolder.getComollegar().setText(mDataSet.get(position).getComollegar());
        viewHolder.getDescripcion().setText(mDataSet.get(position).getDescripcion());
        //  viewHolder.getTitulo().setText(mDataSet.get(position).getTitulo());
        viewHolder.getImagenId().setImageResource(mDataSet.get(position).getImagenId());

//        viewHolder.getTextView().setText(mDataSet.get(position));

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
