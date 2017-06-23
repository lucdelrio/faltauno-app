package com.app.faltauno.activities;

/**
 * Created by lucas on 19/06/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.response.JugadorRespuesta;

import java.util.List;

public class Jugador extends RecyclerView.Adapter<Jugador.ViewHolder> {

    Context context;

    List<JugadorRespuesta> getJugadorRespuesta;

    private int indexPartido;

    public Jugador(List<JugadorRespuesta> getDataAdapter, Context context){

        super();

        this.getJugadorRespuesta = getDataAdapter;
        this.context = context;
    }

    @Override
    public int getItemCount() {

        return getJugadorRespuesta.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jugador, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        JugadorRespuesta jugadorRespuesta =  getJugadorRespuesta.get(position);


        holder.JugadorTextView.setText(jugadorRespuesta.getNombreJugador());

    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView JugadorTextView;


        public ViewHolder(View itemView) {

            super(itemView);

            JugadorTextView = (TextView) itemView.findViewById(R.id.output_jugadores);

        }

    }
}
