package mobile.calyrsoft.com.vda2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.MainActivity;
import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.model.Menubancos;

/**
 * <p> The MenubancosAdapter class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class MenubancosAdapter extends RecyclerView.Adapter<MenubancosAdapter.ViewHolder> {
    private static final String TAG = "MenubancosApdater";

    //private String[] mDataSet;
    private ArrayList<Menubancos> mDataSet;
    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagenId;
        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int valor =  getPosition() + 31;
                    try {
                        ((MainActivity)v.getContext()).displayView(valor);
                    } catch (Exception e) {
                        // ignore
                    }


                    //Log.d(TAG, "ElementBancos " + valor + " clicked.");



                }
            });



            imagenId = (ImageView) v.findViewById(R.id.mbImagenView);
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
    public MenubancosAdapter(ArrayList<Menubancos> dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menubancos_row, viewGroup, false);

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
        Log.d(TAG, "Descripcion " + mDataSet.get(position).getImagenId() + " set.");

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
