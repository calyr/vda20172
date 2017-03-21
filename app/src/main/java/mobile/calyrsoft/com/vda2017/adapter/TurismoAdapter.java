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
import mobile.calyrsoft.com.vda2017.model.Turismo;

/**
 * <p> The TurismoAdapter class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class TurismoAdapter extends RecyclerView.Adapter<TurismoAdapter.ViewHolder> {
    private static final String TAG = "TurismoAdapter";

    //private String[] mDataSet;
    private ArrayList<Turismo> mDataSet;
    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {



        private final TextView descripcion;
        private final ImageView imagenId;
        private final TextView comollegar;
        private final TextView quellevar;

        private final TextView quellevartexto;
        private final ImageView quellevartextoicon;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });


            descripcion = (TextView) v.findViewById(R.id.tuDescripcion);
            comollegar = (TextView) v.findViewById(R.id.tuComollegar);
            quellevar = (TextView) v.findViewById(R.id.tuQuellevar);
            imagenId = (ImageView) v.findViewById(R.id.tuId);
            quellevartexto = (TextView) v.findViewById(R.id.tuQuellevartexto);
            quellevartextoicon = (ImageView) v.findViewById(R.id.imageView7);
        }

        public TextView getComollegar() {

            return comollegar;
        }

        public TextView getQuellevartexto(){
            return quellevartexto;
        }
        public TextView getQuellevar() {
            return quellevar;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public ImageView getImagenId(){
            return imagenId;
        }


        public ImageView getQuellevartextoicon(){
            return quellevartextoicon;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public TurismoAdapter(ArrayList<Turismo> dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.turismo_row, viewGroup, false);

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
        Log.d(TAG, "Descripcionturismo (" + mDataSet.get(position).getQuellevar() + ") set.");
        //viewHolder.getTextView().setText(mDataSet.get(position).getDescripcion());
        viewHolder.getDescripcion().setText(mDataSet.get(position).getDescripcion());

        viewHolder.getImagenId().setImageResource(mDataSet.get(position).getImagenId());
        //      viewHolder.getImagenId().setBackgroundResource(mDataSet.get(position).getImagenId());
        viewHolder.getComollegar().setText(mDataSet.get(position).getComollegar());
        if(mDataSet.get(position).getQuellevar() == "" ){
            viewHolder.getQuellevar().setText(mDataSet.get(position).getQuellevar());

            viewHolder.getQuellevartexto().setVisibility(View.GONE);
            viewHolder.getQuellevartextoicon().setVisibility(View.GONE);



        }else{
            viewHolder.getQuellevar().setText(mDataSet.get(position).getQuellevar());
        }


//        viewHolder.getTextView().setText(mDataSet.get(position));

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
