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

public class Tarjeta extends RecyclerView.Adapter<Tarjeta.ViewHolder> {

    Context context;

    List<PartidoRespuesta> getPartidoRespuesta;

    private int indexPartido;

    public Tarjeta(List<PartidoRespuesta> getDataAdapter, Context context){

        super();

        this.getPartidoRespuesta = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PartidoRespuesta partidoRespuesta =  getPartidoRespuesta.get(position);

        setIndexPartido(position);

        holder.CiudadTextView.setText(partidoRespuesta.getCiudad());
        holder.FechaTextView.setText(partidoRespuesta.getFecha());
        holder.HoraTextView.setText(partidoRespuesta.getHora());
        holder.TamanioCanchaTextView.setText(partidoRespuesta.getTamanioDeCancha().toString());
        holder.GeneroTextView.setText(partidoRespuesta.getGenero());
        holder.NivelTextView.setText(partidoRespuesta.getNivel());
        holder.CupoTextView.setText(partidoRespuesta.getCupo());
        holder.IDTextView.setText(partidoRespuesta.getIdPartido().toString());

    }

    @Override
    public int getItemCount() {

        return getPartidoRespuesta.size();
    }

    public void setIndexPartido(int indexPartido) {

        this.indexPartido = indexPartido;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView CiudadTextView;
        public TextView FechaTextView;
        public TextView HoraTextView;
        public TextView TamanioCanchaTextView;
        public TextView GeneroTextView;
        public TextView NivelTextView;
        public TextView CupoTextView;
        public TextView IDTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            CiudadTextView = (TextView) itemView.findViewById(R.id.texto_ciudad);
            FechaTextView = (TextView) itemView.findViewById(R.id.texto_fecha);
            HoraTextView = (TextView) itemView.findViewById(R.id.texto_hora);
            TamanioCanchaTextView = (TextView) itemView.findViewById(R.id.texto_tamanio_cancha);
            GeneroTextView = (TextView) itemView.findViewById(R.id.texto_genero);
            NivelTextView = (TextView) itemView.findViewById(R.id.texto_nivel);
            CupoTextView = (TextView) itemView.findViewById(R.id.texto_cupo);
            IDTextView = (TextView) itemView.findViewById(R.id.item_id);
        }

    }
}