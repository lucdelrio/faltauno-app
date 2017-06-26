package com.app.faltauno.activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.response.PartidoRespuesta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;


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

        //Typeface allStar = Typeface.createFromAsset(context.getAssets(),"fonts/all_star_resort.ttf");
        //Typeface varsity = Typeface.createFromAsset(context.getAssets(),"fonts/varsity_regular.ttf");
        Typeface colleged = Typeface.createFromAsset(context.getAssets(),"fonts/colleged.ttf");
        //Typeface college_b = Typeface.createFromAsset(context.getAssets(),"fonts/college_b.ttf");
        Typeface athletic = Typeface.createFromAsset(context.getAssets(),"fonts/athletic.ttf");

        setIndexPartido(position);

        holder.TamanioYLugarView.setText("Futbol " + partidoRespuesta.getTamanioDeCancha().toString() +
                " en " + partidoRespuesta.getCiudad());
        holder.TamanioYLugarView.setTypeface(athletic);

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = format.parse(partidoRespuesta.getFecha());
            FechaALetra aLetra = new FechaALetra();

            holder.FechaYHoraTextView.setText(aLetra.getDia(fecha.getDay()) + " " +
                    partidoRespuesta.getFecha() + "   " +partidoRespuesta.getHora() + "hs.");

            holder.FechaYHoraTextView.setTypeface(athletic);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.LetraCupo.setTypeface(athletic);
        holder.GeneroNivelTextView.setText(partidoRespuesta.getGenero() + " / " + partidoRespuesta.getNivel());
        holder.GeneroNivelTextView.setTypeface(athletic);
        holder.IDTextView.setText(partidoRespuesta.getIdPartido().toString());
        holder.CupoTextView.setText(partidoRespuesta.getCupo().toString());
        holder.CupoTextView.setTypeface(colleged);
        holder.Tarjeta.setCardBackgroundColor(Color.WHITE);


        if(partidoRespuesta.getCupo().equals(0)){
            holder.CupoTextView.setText("√");
            holder.CupoTextView.setTextColor(holder.CupoTextView.getContext().getResources().getColor(R.color.colorAccentGreen));
            holder.Tarjeta.setCardBackgroundColor(Color.LTGRAY);
        }


        if(partidoRespuesta.getCupo().equals(1)) {
            holder.Tarjeta.setCardBackgroundColor(Color.RED);
            holder.CupoTextView.setTextColor(holder.CupoTextView.getContext().getResources().getColor(R.color.colorWhite));
            holder.TamanioYLugarView.setTextColor(holder.TamanioYLugarView.getContext().getResources().getColor(R.color.colorWhite));
            holder.FechaYHoraTextView.setTextColor(holder.FechaYHoraTextView.getContext().getResources().getColor(R.color.colorWhite));
            holder.GeneroNivelTextView.setTextColor(holder.GeneroNivelTextView.getContext().getResources().getColor(R.color.colorWhite));
            holder.LetraCupo.setTextColor(holder.LetraCupo.getContext().getResources().getColor(R.color.colorWhite));
        }
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
        public CardView Tarjeta;
        public TextView LetraCupo;

        public ViewHolder(View itemView) {

            super(itemView);

            FechaYHoraTextView = (TextView) itemView.findViewById(R.id.texto_fecha_y_hora);
            TamanioYLugarView = (TextView) itemView.findViewById(R.id.texto_tamanio_y_lugar);
            GeneroNivelTextView = (TextView) itemView.findViewById(R.id.texto_genero_nivel);
            CupoTextView = (TextView) itemView.findViewById(R.id.texto_cupo);
            IDTextView = (TextView) itemView.findViewById(R.id.item_id);
            Tarjeta = (CardView) itemView.findViewById(R.id.cardview_partido);
            LetraCupo = (TextView) itemView.findViewById(R.id.cupo_letra);
        }

    }
}