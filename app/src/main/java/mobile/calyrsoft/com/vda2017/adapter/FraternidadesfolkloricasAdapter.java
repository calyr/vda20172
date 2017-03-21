package mobile.calyrsoft.com.vda2017.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.model.Fraternidadesfolkloricas;

/**
 * <p> The FraternidadesfolkloricasAdapter class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class FraternidadesfolkloricasAdapter extends ArrayAdapter<Fraternidadesfolkloricas> {
public FraternidadesfolkloricasAdapter(Context context, ArrayList<Fraternidadesfolkloricas> objects) {
        super(context, 0, objects);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        Fraternidadesfolkloricas ff = getItem(position);

        if(convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.fraternidadesfolkloricas_row,parent, false);
        }

        TextView categoria = (TextView)convertView.findViewById(R.id.ffCategoria);


        categoria.setText(ff.getCategoria());


        //return super.getView(position, convertView, parent);
        return convertView;
        }
        }
