package br.pucpr.appdev.tcc.investnow.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.model.GovernmentBond;

public class GovernmentBondsAdapter extends RecyclerView.Adapter<GovernmentBondsAdapter.GovernmentBondViewHolder>{

    public List<GovernmentBond> governmentBonds;
    private int rowLayout;
    public Context context;
    //public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    public GovernmentBondsAdapter(List<GovernmentBond> governmentBonds, int rowLayout, Context context) {
        this.governmentBonds = governmentBonds;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public class GovernmentBondViewHolder extends RecyclerView.ViewHolder {
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

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Log.d("Click", "pos: " + pos);
                        GovernmentBond clickedDataItem = governmentBonds.get(pos);
                        Log.d("Click", "You clicked " + clickedDataItem.getTitle());
                        //Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(view.getContext(), "You clicked " + clickedDataItem.getTitle(), Toast.LENGTH_SHORT).show();

                        // 1. Instantiate an AlertDialog.Builder with its constructor
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                        //builder.setCancelable(true);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                return;
                            }
                        });

                        // 2. Chain together various setter methods to set the dialog characteristics
                        String message = "Rendimento anual: " + clickedDataItem.getRateReturn().toString() + "\n"
                                + "Vencimento: " + clickedDataItem.getDueDate() + "\n"
                                + "Valor mínimo: " + clickedDataItem.getMinimumValue() + "\n"
                                + "Preço unitário: " + clickedDataItem.getUnitPrice() + "\n";
                        builder.setMessage(message)
                                .setTitle(clickedDataItem.getTitle());

                        // 3. Get the AlertDialog from create()
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            });
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
