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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

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

            NameTextView = (TextView) itemView.findViewById(R.id.textView4) ;
            CityTextView = (TextView) itemView.findViewById(R.id.textView6) ;
            GenderTextView = (TextView) itemView.findViewById(R.id.textView8) ;
        }
    }
}