package br.pucpr.appdev.tcc.investnow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import br.pucpr.appdev.tcc.investnow.MainCard;
import br.pucpr.appdev.tcc.investnow.R;

public class MainAdapter extends ArrayAdapter<MainCard> {
    private static final String TAG = MainAdapter.class.getSimpleName();

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView title;
        ImageView image;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public MainAdapter(Context context, int resource, ArrayList<MainCard> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String title = getItem(position).getTitle();
        String imgUrl = getItem(position).getImgURL();

            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_main, null);
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.cardImage);
                holder.title = (TextView) convertView.findViewById(R.id.cardTitle);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }


            holder.title.setText(title);

            int defaultImage = mContext.getResources().getIdentifier("@drawable/indicadores",null,mContext.getPackageName());

            //fetching your data object with the current position
            //Example example = mExamples[position];

            //String img_url = "tete";//example.get(i).img;

            Picasso.with(mContext).load(imgUrl).error(R.drawable.indicadores).into(holder.image);
            //Picasso.with(mContext).load(R.drawable.indicadores).error(R.drawable.indicadores).into(holder.image);

            return convertView;
    }
}
