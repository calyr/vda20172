package mobile.calyrsoft.com.vda2017.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.MainActivity;
import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.adapter.ProgramafestivoAdapter;
import mobile.calyrsoft.com.vda2017.model.Programafestivo;

/**
 * <p> The ProgramafestivoFragment class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class ProgramafestivoFragment extends Fragment {
    ProgramafestivoAdapter adapter;
    ArrayList<Programafestivo> pfList;
    ListView pfListView;

    public ProgramafestivoFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_programafestivo, container, false);

        pfList = new ArrayList<>();
        pfList.add(new Programafestivo("Proyección del Documental Virgen del Amparo 2014","Teatro Parroquial","Del Lunes 12 al Jueves 15  de octubre de 2015","09:00 a.m. 15:00 p.m." ));

        adapter = new ProgramafestivoAdapter(container.getContext(),pfList);

        pfListView = (ListView) rootView.findViewById(R.id.pfListView);
        pfListView.setAdapter(adapter);
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
