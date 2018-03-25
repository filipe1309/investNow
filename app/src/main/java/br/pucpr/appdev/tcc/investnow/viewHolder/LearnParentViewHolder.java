package br.pucpr.appdev.tcc.investnow.viewHolder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.model.LearnParent;

public class LearnParentViewHolder extends ParentViewHolder{

    public TextView mLearnParenttextView;
    public ImageButton _imageButton;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public LearnParentViewHolder(@NonNull View itemView) {
        super(itemView);
        mLearnParenttextView = (TextView)itemView.findViewById(R.id.parent_title);
        _imageButton = (ImageButton) itemView.findViewById(R.id.expand_arrow);
    }

    public void bind(LearnParent learnParent) {
        mLearnParenttextView.setText(learnParent.getTitle());
    }
}
