package com.kc.expandablelistviewdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.kc.expandablelistviewdroid.adapters.TechnologyExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * The TechnologyListActivity program implements an Expandable List View application that
 * simply displays items as an expandable list view.A Test data is being generated from GenerateTestData class.
 *
 * @author  Khemchand Joshi
 * @version 1.0
 * @since   2017-03-31
 */

public class TechnologyListActivity extends AppCompatActivity {

    private final static String TAG = TechnologyListActivity.class.getSimpleName();
    private ExpandableListView mTechnologyExpandableListView;
    private TechnologyExpandableListAdapter mExpandableListAdapter;
    private List<String> mTechnologyHeaderList;
    private HashMap<String, List<String>> mTopicChildList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_list);
        //Initialize expendable List View
        mTechnologyExpandableListView = (ExpandableListView) findViewById(R.id.technology_list_ev);
        //Generate test data to display as expandable list as header and details.
        GenerateTestData testData = new GenerateTestData();
        //Pass test data abd content to Expandable List adapter which render the expandable view.
        mExpandableListAdapter = new TechnologyExpandableListAdapter(this, testData.generateTechnologyHeaderData(), testData.generateTopicChildList());
        mTechnologyExpandableListView.setAdapter(mExpandableListAdapter);

    }
}
