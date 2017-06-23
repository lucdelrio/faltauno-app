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

        holder.TamanioYLugarView.setText("Fútbol " + partidoRespuesta.getTamanioDeCancha().toString() +
                " en " + partidoRespuesta.getCiudad());
        holder.FechaYHoraTextView.setText(partidoRespuesta.getFecha() + " " + partidoRespuesta.getHora() + "hs.");
        holder.GeneroNivelTextView.setText(partidoRespuesta.getGenero() + " / " + partidoRespuesta.getNivel());
        holder.IDTextView.setText(partidoRespuesta.getIdPartido().toString());
        holder.CupoTextView.setText(partidoRespuesta.getCupo().toString());

    }

    @Override
    public int getItemCount() {

        return getPartidoRespuesta.size();
    }

    public void setIndexPartido(int indexPartido) {

        this.indexPartido = indexPartido;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView FechaYHoraTextView;
        public TextView TamanioYLugarView;
        public TextView GeneroNivelTextView;
        public TextView CupoTextView;
        public TextView IDTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            FechaYHoraTextView = (TextView) itemView.findViewById(R.id.texto_fecha_y_hora);
            TamanioYLugarView = (TextView) itemView.findViewById(R.id.texto_tamanio_y_lugar);
            GeneroNivelTextView = (TextView) itemView.findViewById(R.id.texto_genero_nivel);
            CupoTextView = (TextView) itemView.findViewById(R.id.texto_cupo);
            IDTextView = (TextView) itemView.findViewById(R.id.item_id);
        }

    }
}