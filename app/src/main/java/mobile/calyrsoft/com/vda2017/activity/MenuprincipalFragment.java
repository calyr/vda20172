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
import mobile.calyrsoft.com.vda2017.adapter.MenuprincipalAdapter;
import mobile.calyrsoft.com.vda2017.model.Menuprincipal;

/**
 * <p> The MenuprincipalFragment class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class MenuprincipalFragment extends Fragment {

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
    protected MenuprincipalAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    // protected String[] mDataset;
    protected ArrayList<Menuprincipal> mDataset;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // if (getActionBar().isShowing()) getActionBar().hide();

        //  if (getActionBar().isShowing()) getActionBar().hide();


        //getActivity().getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        ((MainActivity) getActivity()).getSupportActionBar().hide();
        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menuprincipal, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.mpRecyclerView);

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
        // setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
        mAdapter = new MenuprincipalAdapter(mDataset);
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
        mDataset = new ArrayList<Menuprincipal>();

        mDataset.add( new Menuprincipal("Programa Festivo", R.drawable.ic_programa));

        mDataset.add( new Menuprincipal("Recorrido", R.drawable.ic_recorrido));

        mDataset.add( new Menuprincipal("Fraternidades Folklóricas", R.drawable.ic_fraternidades));

        mDataset.add( new Menuprincipal("Cajeros Automaticos", R.drawable.ic_cajeros));

        mDataset.add( new Menuprincipal("Plato Representativo", R.drawable.ic_gastronomia));

        mDataset.add( new Menuprincipal("Turismo", R.drawable.ic_turismo));

       // mDataset.add( new Menuprincipal("Teléfonos de Emergencias", R.drawable.ic_telefonos));

       // mDataset.add( new Menuprincipal("Ordenanzas y Leyes", R.drawable.ic_ordenanzas));

       // mDataset.add( new Menuprincipal("Mensaje del Alcalde", R.drawable.ic_mensaje));

       // mDataset.add( new Menuprincipal("Redes Sociales", R.drawable.ic_redes));


    }
}
