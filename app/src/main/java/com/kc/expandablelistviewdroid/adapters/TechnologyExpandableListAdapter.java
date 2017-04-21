package com.kc.expandablelistviewdroid.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.kc.expandablelistviewdroid.R;

import java.util.HashMap;
import java.util.List;

/**
 * The TechnologyExpandableListAdapter is a adapter which take input as group and child data and render according to views defined.
 * @author  Khemchand Joshi
 * @version 1.0
 * @since   2017-03-31
 */

public class TechnologyExpandableListAdapter extends BaseExpandableListAdapter {

    private final static String TAG = TechnologyExpandableListAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mTechnologyHeaderList;
    private HashMap<String, List<String>> mTopicChildList;

    public TechnologyExpandableListAdapter(Context _context, List<String> _technologyHeaderList, HashMap<String, List<String>> _topicChildList) {
        this.mContext = _context;
        this.mTechnologyHeaderList = _technologyHeaderList;
        this.mTopicChildList = _topicChildList;
    }
    @Override
    public int getGroupCount() {
        return mTechnologyHeaderList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mTopicChildList.get(mTechnologyHeaderList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mTechnologyHeaderList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
       return mTopicChildList.get(mTechnologyHeaderList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String listTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.technology_header_item, null);
            }
            TextView listTitleTextView = (TextView) convertView
                    .findViewById(R.id.technology_item);
            listTitleTextView.setTypeface(null, Typeface.BOLD);
            listTitleTextView.setText(listTitle);
            return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       final String childText = (String) getChild(groupPosition, childPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.topic_child_item, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.child_item);
        expandedListTextView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
