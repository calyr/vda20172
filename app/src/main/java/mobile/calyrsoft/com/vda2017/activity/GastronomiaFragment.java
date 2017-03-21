package mobile.calyrsoft.com.vda2017.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.MainActivity;
import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.adapter.GastronomiaAdapter;
import mobile.calyrsoft.com.vda2017.model.Gastronomia;

/**
 * <p> The GastronomiaFragment class </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class GastronomiaFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 10;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;



    protected RecyclerView mRecyclerView;
    protected GastronomiaAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    // protected String[] mDataset;
    protected ArrayList<Gastronomia> mDataset;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // if (getActionBar().isShowing()) getActionBar().hide();

        //  if (getActionBar().isShowing()) getActionBar().hide();


        //getActivity().getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        ((MainActivity) getActivity()).getSupportActionBar().show();
        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gastronomia, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.gaRecyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        //setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
        mAdapter = new GastronomiaAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new ArrayList<Gastronomia>();

        mDataset.add( new Gastronomia("PLATO REPRESENTATIVO CHICHARRÓN  ", "El chicharrón es un plato especial cuyo ingrediente principal es la carne de cerdo. El municipio de Sacaba demostró una vocación especializada en la preparación de este suculento manjar de los valles centrales de Cochabamba, es por ello que la tradicional feria del Chicharrón Sacabeño se lleva a cabo anualmente el segundo domingo del mes de junio y es reconocida a nivel departamental y nacional.\n" +
                "La comunidad de Tutimayu, ubicada a 26 km del municipio de cercado (carretera Cochabamba-Santa Cruz), ofrece a sus visitantes la posibilidad de degustar un exquisito chicharrón, escabeche y enrollado de cerdo, acompañado de una agradable chicha, todo preparado de forma tradicional en fogones de barro y a leña, de lunes a domingo.\n " ,"Transportarse en trufi Nº 241 a Tutimayu en la Av. Barrientos, frente al hospital México de Sacaba. ",  R.drawable.chicharon));


    }
}
