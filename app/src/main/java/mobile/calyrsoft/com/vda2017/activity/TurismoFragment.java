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
import mobile.calyrsoft.com.vda2017.adapter.TurismoAdapter;
import mobile.calyrsoft.com.vda2017.model.Turismo;

/**
 * <p> The TurismoFragment class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class TurismoFragment extends Fragment {

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
    protected TurismoAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    // protected String[] mDataset;
    protected ArrayList<Turismo> mDataset;


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
        View rootView = inflater.inflate(R.layout.fragment_turismo, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.tuRecyclerView);

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
        mAdapter = new TurismoAdapter(mDataset);
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
        mDataset = new ArrayList<Turismo>();

        mDataset.add( new Turismo("PARQUE ECOTURÍSTICO SAN ISIDRO ", "El parque ecoturístico municipal “San Isidro”, es un proyecto integral de conservación de biodiversidad por sus características geomorfológicas. Está ubicado a 40 km. del municipio de Cercado y 27 km. del centro histórico de Sacaba (carretera Cochabamba-Santa Cruz).\n" +
                "Es una gran reserva natural con diversidad de fauna y flora, a una altura de 3.460 m.s.n.m. bajo un clima templado, su principal atractivo es una laguna que a la vista parece un espejo del cielo, zona naturalmente turística donde los visitantes podrán desarrollar actividades recreativas, como paseos en bote, kayak y catamaranes, además de realizar pesca deportiva. Se ofrece también paseos por eco-rutas en medio de pinos y eucaliptos, donde podrán realizar fotografía y video.\n " ,"Transportarse en taxi trufi Nº 222 en la Av. Barrientos, parada a Melga, frente al hospital México de Sacaba.", "Ropa cómoda y abrigada. ", R.drawable.sanisidro));

        mDataset.add( new Turismo("CENTRO ECOTURÍSTICO LA PAJCHA", "El centro ecoturístico “La Pajcha”, está ubicado a 20 km. del municipio de Cercado y a 7 km. del centro histórico de Sacaba.  Su principal atractivo es una cascada de aguas cristalinas de 80 m. de altura, tiene un microclima húmedo, rodeado de       eucaliptos y plantas típicas de la región. Su geografía permite desarrollar el turismo de aventura, actividades como rappel, escalada y trekking C y D, siendo el sendero de acceso de 3 km. por el cauce del rio desde la comunidad de Molino Blanco.  El visitante podrá realizar rutas fotográficas y de video, disfrutando de los imponentes paisajes y la diversidad de la flora y fauna.  El recorrido también ofrece una visita a los Molinos de Piedra declarados patrimonio histórico cultural del municipio, que además reflejan las cualidades culturales y gastronómicas de la comunidad." ,"Transportarse en trufi Nº 241 a Molino Blanco en la Av. Barrientos, frente al hospital México de Sacaba. ", "Ropa cómoda y  zapatillas con trilla.", R.drawable.pajcha));

        mDataset.add( new Turismo("PARQUE METROPOLITANO", "El parque “Metropolitano” es un área verde de conservación de biodiversidad, está ubicado en la zona de Arocagua, 1 km. al norte de la Av. Circunvalación  (Cementerio Parque de las Memorias).\n" +
                "Ofrece recorridos por bosques de eucaliptos situados a un lado del cauce del rio Wara Wara, conectándose a la cascada del mismo nombre a 1 ½ km. más al norte. Enfocado en la preservación del medio ambiente, brinda espacios de esparcimiento y recreación a jóvenes y familias, el parque cuenta con jardines y pahuichis. Se ofrece también paseos por eco-rutas, donde podrán realizar fotografía y video. \n " ,"Transportarse en trufi Nº 233 a Arocagua en la Av. Aroma del municipio de Cercado.", "Ropa cómoda y refrigerios.", R.drawable.metropolitano));
        mDataset.add( new Turismo("Casa consistorial", "Se encuentra ubicada en la plaza  6 de Agosto acera este del municipio de Sacaba. Su edificación se inició en 1902 y cuenta con una extensión aproximada de 226 m.2, es de  estilo contemporáneo republicano, su frontis externo presenta dos plantas de forma rectangular, balcones de hierro forjado, puertas rematadas en arcos de medio punto adosados entre las ventanas, el friso rematado por el escudo nacional de Bolivia.\n" +
                "\n" +
                "En el interior resalta el salón Rojo destinando a eventos de carácter público, así mismo reliquias culturales y retratos de notables sacabeños, de la misma forma se encuentran galerías formadas por columnas toscanas, arcos ojivales y de medio punto, columnas adosadas a los muros principales y una diversidad de motivos decorativos junto a  figuras zoomorfas esculpidas en yeso.\n " ,"Transportarse en cualquier trufi a Sacaba, que llegue a la plaza principal 6 de Agosto.", "", R.drawable.casa));

        mDataset.add( new Turismo("Virgen del Amparo", "La festividad de la Virgen del Amparo, es un importante referente cultural y turístico no solo de  Sacaba si no del resto del país. La historia dice que la virgen habría hecho su aparición en 1870  en inmediaciones del sector de Korihuma.  Esta advocación Mariana lleva un  nombre inspirado en las súplicas de sus creyentes, “Virgencita, ampáranos, mamita, ampáranos”.\n" +
                "Cuentan que aquellos tiempos, durante un día caluroso, se encontraba un trabajador realizando su faena. Una tormenta obligó al campesino a buscar cobijo y vio caer un rayo sobre una piedra que fue partida. En la piedra quedó estampada la imagen de la Virgen María con el niño Jesús.\n","Transportarse en cualquier trufi a Sacaba, que llegue a la plaza principal 6 de Agosto.", "", R.drawable.virgen));

    }
}
