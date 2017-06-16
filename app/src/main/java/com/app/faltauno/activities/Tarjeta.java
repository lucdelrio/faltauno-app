package com.app.faltauno.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.response.PartidoRespuesta;

import java.util.List;

/**
 * Created by JUNED on 6/16/2016.
 */
public class Tarjeta extends RecyclerView.Adapter<Tarjeta.ViewHolder> {

    Context context;

    List<PartidoRespuesta> getPartidoRespuesta;

    public Tarjeta(List<PartidoRespuesta> getDataAdapter, Context context){

        super();

        this.getPartidoRespuesta = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_items, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PartidoRespuesta partidoRespuesta =  getPartidoRespuesta.get(position);

        holder.NameTextView.setText(partidoRespuesta.getNombreOrganizador());

        holder.GenderTextView.setText(partidoRespuesta.getGenero());

        holder.CityTextView.setText(partidoRespuesta.getCiudad());

    }

    @Override
    public int getItemCount() {

        return getPartidoRespuesta.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NameTextView;
        public TextView CityTextView;
        public TextView GenderTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            NameTextView = (TextView) itemView.findViewById(R.id.text_organizador) ;
            CityTextView = (TextView) itemView.findViewById(R.id.text_ciudad) ;
            GenderTextView = (TextView) itemView.findViewById(R.id.text_genero) ;
        }
    }
}