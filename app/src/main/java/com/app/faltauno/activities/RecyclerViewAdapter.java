package com.app.faltauno.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.response.MatchDataAdapter;

import java.util.List;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;

    List<MatchDataAdapter> getMatchDataAdapter;

    public RecyclerViewAdapter(List<MatchDataAdapter> getDataAdapter, Context context){

        super();

        this.getMatchDataAdapter = getDataAdapter;
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

        MatchDataAdapter matchDataAdapter =  getMatchDataAdapter.get(position);

        holder.NameTextView.setText(matchDataAdapter.getOwnerName());

        holder.GenderTextView.setText(matchDataAdapter.getGender());

        holder.CityTextView.setText(matchDataAdapter.getCity());

    }

    @Override
    public int getItemCount() {

        return getMatchDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NameTextView;
        public TextView CityTextView;
        public TextView GenderTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            NameTextView = (TextView) itemView.findViewById(R.id.text_fecha) ;
            CityTextView = (TextView) itemView.findViewById(R.id.text_ciudad) ;
            GenderTextView = (TextView) itemView.findViewById(R.id.text_cancha_de) ;
        }
    }
}