package com.jude.beam.expansion;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.jude.beam.Beam;
import com.jude.beam.R;
import com.jude.beam.bijection.BeamAppCompatActivity;
import com.jude.beam.bijection.Presenter;
import com.jude.beam.expansion.overlay.ViewExpansionDelegate;

/**
 * Created by Mr.Jude on 2015/8/17.
 */
public class  BeamBaseActivity<T extends Presenter> extends BeamAppCompatActivity<T> {
    //如果使用了ToolBar则自动部署。没有则无影响。
    private Toolbar toolbar;

    /**
     *      视图结构
     *                    DecorView
     *                        |
     *                    LinearLayout
     *                    /         \
     *                   /           \
     *           FrameLayout       FrameLayout
     *            |             (mContentParent)
     *            |                   /      \
     *         TextView     FrameLayout    各种附加View
     *                      (mContent)
     *                  (在一开始就装入View树)
     *                          |
     *                      setContent()
     *                  (什么时候装入View不确定)
     *
     */
    private FrameLayout mContent;
    private FrameLayout mContentParent;

    @Override
    public void preCreatePresenter() {
        super.preCreatePresenter();
        initViewTree();
    }

    private void initViewTree(){
        mContentParent = (FrameLayout)findViewById(android.R.id.content);
        mContent = new FrameLayout(this);
        super.setContentView(mContent);
    }

    public FrameLayout getParentView(){
        return mContentParent;
    }

    @Override
    public void setContentView(int layoutResID) {
        this.setContentView(getLayoutInflater().inflate(layoutResID, mContent, false));
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContent.addView(view, params);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar!=null)
            onSetToolbar(toolbar);
    }

    public Toolbar getToolbar(){
        return toolbar;
    }

    public void onSetToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private ViewExpansionDelegate mDelegate;

    public ViewExpansionDelegate createViewExpansionDelegate() {
        return Beam.createViewExpansionDelegate(this);
    }

    public final ViewExpansionDelegate getExpansion() {
        if (mDelegate==null)mDelegate = createViewExpansionDelegate();
        return mDelegate;
    }

    @Nullable
    protected final <E extends View> E $(@NonNull View view,@IdRes int id){
        return (E)view.findViewById(id);
    }
    @Nullable
    protected final <E extends View> E viewId(@NonNull View view,@IdRes int id){
        return (E)view.findViewById(id);
    }
    @Nullable
    protected final <E extends View> E $(@IdRes int id){
        return (E)findViewById(id);
    }
    @Nullable
    protected final <E extends View> E viewId(@IdRes int id){
        return (E)findViewById(id);
    }



}
