package br.pucpr.appdev.tcc.investnow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.model.Indicator;

public class IndicatorsAdapter extends RecyclerView.Adapter<IndicatorsAdapter.IndicatorViewHolder>{

    private List<Indicator> indicators;
    private int rowLayout;
    private Context context;
    //public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    public IndicatorsAdapter(List<Indicator> indicators, int rowLayout, Context context) {
        this.indicators = indicators;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class IndicatorViewHolder extends RecyclerView.ViewHolder {
        LinearLayout indicatorLayout;
        TextView indicatorTitle;
        TextView dataUpdate;
        TextView rateValue;

        public IndicatorViewHolder(View v) {
            super(v);
            indicatorLayout = (LinearLayout) v.findViewById(R.id.indicators_layout);
            indicatorTitle = (TextView) v.findViewById(R.id.title);
            dataUpdate = (TextView) v.findViewById(R.id.date_update);
            rateValue = (TextView) v.findViewById(R.id.rate_value);
        }
    }


    @Override
    public IndicatorsAdapter.IndicatorViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new IndicatorViewHolder(view);

    }

    @Override
    public void onBindViewHolder(IndicatorViewHolder holder, final int position) {
        /*String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);*/
        holder.indicatorTitle.setText(indicators.get(position).getTitle());
        holder.dataUpdate.setText(indicators.get(position).getDateUpdateFormatted());
        holder.rateValue.setText(indicators.get(position).getRateValue().toString());
    }

    @Override
    public int getItemCount() {
        return indicators.size();
    }
}
