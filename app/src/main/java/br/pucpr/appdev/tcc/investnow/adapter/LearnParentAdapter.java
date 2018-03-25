package br.pucpr.appdev.tcc.investnow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.model.LearnChild;
import br.pucpr.appdev.tcc.investnow.model.LearnParent;
import br.pucpr.appdev.tcc.investnow.viewHolder.LearnChildViewHolder;
import br.pucpr.appdev.tcc.investnow.viewHolder.LearnParentViewHolder;

public class LearnParentAdapter extends ExpandableRecyclerAdapter<LearnParent, LearnChild, LearnParentViewHolder, LearnChildViewHolder>{

    private LayoutInflater mInflater;

    public LearnParentAdapter(Context context, @NonNull List<LearnParent> parentList) {
        super(parentList);
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LearnParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View learnParentView = mInflater.inflate(R.layout.list_learn_parent, parentViewGroup, false);
        return new LearnParentViewHolder(learnParentView);
    }

    @NonNull
    @Override
    public LearnChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View learnChildView = mInflater.inflate(R.layout.list_learn_child, childViewGroup, false);
        return new LearnChildViewHolder(learnChildView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull LearnParentViewHolder parentViewHolder, int parentPosition, @NonNull LearnParent parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull LearnChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull LearnChild child) {
        childViewHolder.bind(child);
    }
}
