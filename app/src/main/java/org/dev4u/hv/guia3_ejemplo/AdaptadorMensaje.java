package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Adalberto on 02/09/2017.
 */

public class AdaptadorMensaje extends ArrayAdapter<Mensaje>{

    public AdaptadorMensaje(Context context, List<Mensaje> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Mensaje mensaje = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblMensaje = (TextView) convertView.findViewById(R.id.lblMensaje);
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
        // mostrar los datos
        lblMensaje.setText(mensaje.mensaje);
        lblFecha.setText(mensaje.fecha);
        // Return la convertView ya con los datos

        return convertView;
    }
}
