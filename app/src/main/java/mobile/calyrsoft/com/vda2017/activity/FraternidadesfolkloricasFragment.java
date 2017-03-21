package mobile.calyrsoft.com.vda2017.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.MainActivity;
import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.adapter.FraternidadesfolkloricasAdapter;
import mobile.calyrsoft.com.vda2017.model.Fraternidadesfolkloricas;

/**
 * <p> The FraternidadesfolkloricasFragment class </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class FraternidadesfolkloricasFragment extends Fragment {
    FraternidadesfolkloricasAdapter adapter;
    ArrayList<Fraternidadesfolkloricas> ffList;
    ListView ffListView;

    public FraternidadesfolkloricasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getSupportActionBar().show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fraternidadesfolkloricas, container, false);

        ffList = new ArrayList<>();
        ffList.add(new Fraternidadesfolkloricas("Amor Serrano","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Caporales Impasa","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Caporales Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Caporales F. El Inka","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Chaco Esmeralda","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Diablada Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Diablada Coboce","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Jalkas Mercado Central","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Jalkas T.S.C.","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Llamerada Bolivar","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Morenada Central Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Morenada Real Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Morenada Trans Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Negritos 14 De Septiembre","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Negritos Sacaba V.Amparo","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Ovejitas Villa Obrajes","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Pujllay Jallalla Bolivia","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Pujllay I.Concepcion","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Pujllay Sonqoymanta","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Razon Kochala","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Salay Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Salay Linde","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Salay V.I.Concepcion","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Salay Virgen Del Carmen","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Saya Afro Simon Rodriguez","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Saya Afro Antofagasta","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Kullawada U.E.Boliviano Japones","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Sacaba","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Ulincate","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Renacer","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Huayllani","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Lero Leros","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tobas Santa Rosa De Lima","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Waka Tokoris Matarifes","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Masis","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Tinkus Sumaj Punchay","","","" ));
        ffList.add(new Fraternidadesfolkloricas("Caporales Bienestar Estudiantil","","","" ));




        adapter = new FraternidadesfolkloricasAdapter(container.getContext(),ffList);

        ffListView = (ListView) rootView.findViewById(R.id.ffListView);
        ffListView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
