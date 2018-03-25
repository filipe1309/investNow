package br.pucpr.appdev.tcc.investnow.model;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class LearnParent implements Parent<LearnChild> {

    private List<LearnChild> mChildrenList;
    public String title;

    public LearnParent(String title, List<LearnChild> childrenList) {
        this.title = title;
        mChildrenList = childrenList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<LearnChild> getChildList() {
        return mChildrenList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
