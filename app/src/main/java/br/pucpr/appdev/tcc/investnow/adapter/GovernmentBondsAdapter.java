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
import br.pucpr.appdev.tcc.investnow.model.GovernmentBond;

public class GovernmentBondsAdapter extends RecyclerView.Adapter<GovernmentBondsAdapter.GovernmentBondViewHolder>{

    private List<GovernmentBond> governmentBonds;
    private int rowLayout;
    private Context context;
    //public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    public GovernmentBondsAdapter(List<GovernmentBond> governmentBonds, int rowLayout, Context context) {
        this.governmentBonds = governmentBonds;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class GovernmentBondViewHolder extends RecyclerView.ViewHolder {
        LinearLayout governmentBondLayout;
        TextView governmentBondTitle;
        TextView dueDate;
        TextView rateReturn;
        TextView minimumValue;
        TextView unitPrice;

        public GovernmentBondViewHolder(View v) {
            super(v);
            governmentBondLayout = (LinearLayout) v.findViewById(R.id.government_bonds_layout);
            governmentBondTitle = (TextView) v.findViewById(R.id.title_government_bonds);
            dueDate = (TextView) v.findViewById(R.id.due_date_government_bonds);
            rateReturn = (TextView) v.findViewById(R.id.rate_return_government_bonds);
            minimumValue = (TextView) v.findViewById(R.id.minimum_value_government_bonds);
            unitPrice = (TextView) v.findViewById(R.id.unit_price_government_bonds);
        }
    }


    @Override
    public GovernmentBondsAdapter.GovernmentBondViewHolder onCreateViewHolder(ViewGroup parent,
                                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new GovernmentBondViewHolder(view);

    }

    @Override
    public void onBindViewHolder(GovernmentBondViewHolder holder, final int position) {
        /*String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);*/
        holder.governmentBondTitle.setText(governmentBonds.get(position).getTitle());
        holder.dueDate.setText(governmentBonds.get(position).getDueDate());
        holder.rateReturn.setText(governmentBonds.get(position).getRateReturn().toString());
        holder.minimumValue.setText(governmentBonds.get(position).getMinimumValue().toString());
        holder.unitPrice.setText(governmentBonds.get(position).getUnitPrice().toString());
    }

    @Override
    public int getItemCount() {
        return governmentBonds.size();
    }
}
