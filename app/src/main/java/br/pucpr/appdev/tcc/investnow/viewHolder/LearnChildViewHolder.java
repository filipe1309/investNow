package br.pucpr.appdev.tcc.investnow.viewHolder;


import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.model.LearnChild;

public class LearnChildViewHolder extends ChildViewHolder{

    public TextView option1, option2;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public LearnChildViewHolder(@NonNull View itemView) {
        super(itemView);

        option1 = (TextView)itemView.findViewById(R.id.option1);
        option2 = (TextView)itemView.findViewById(R.id.option2);
    }

    public void bind(LearnChild learnChild) {
        option1.setText(learnChild.getOption1());
        option2.setText(learnChild.getOption2());
    }
}
