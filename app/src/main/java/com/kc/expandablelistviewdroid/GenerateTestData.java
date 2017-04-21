package com.kc.expandablelistviewdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * The GenerateTestData is a program to generate test data as header and details for Expandable List View.
 *
 * @author  Khemchand Joshi
 * @version 1.0
 * @since   2017-03-31
 */

public class GenerateTestData {
    private List<String> mTechnologyHeaderList;
    private HashMap<String, List<String>> mTopicChildList;

    public GenerateTestData() {
        mTechnologyHeaderList = new ArrayList<String>();
        mTopicChildList = new HashMap<>();
    }

    /**
     * This is the method generate test data to display as header in expandable List View
     * @return List<String>.
     */

    public List<String> generateTechnologyHeaderData() {
        mTechnologyHeaderList.add("JAVA");
        mTechnologyHeaderList.add("PHP");
        mTechnologyHeaderList.add("Android");
        mTechnologyHeaderList.add("iOS");
        return mTechnologyHeaderList;
    }
    /**
     * This is the method generate test data to display as details when user tap on header in expandable List View
     * @return List<String>.
     */
    public HashMap<String, List<String>> generateTopicChildList() {
        List javaTopics = new ArrayList();
        javaTopics.add("Basics");
        javaTopics.add("String");
        javaTopics.add("Loops");
        javaTopics.add("Arrays");
        javaTopics.add("Collections");

        List phpTopics = new ArrayList();
        phpTopics.add("Basics");
        phpTopics.add("String");
        phpTopics.add("Loops");
        phpTopics.add("Arrays");
        phpTopics.add("Collections");

        List androidTopics = new ArrayList();
        androidTopics.add("Basics");
        androidTopics.add("String");
        androidTopics.add("Loops");
        androidTopics.add("Arrays");
        androidTopics.add("Collections");

        List iOSTopics = new ArrayList();
        iOSTopics.add("Basics");
        iOSTopics.add("String");
        iOSTopics.add("Loops");
        iOSTopics.add("Arrays");
        iOSTopics.add("Collections");

        mTopicChildList.put(mTechnologyHeaderList.get(0), javaTopics);
        mTopicChildList.put(mTechnologyHeaderList.get(1), phpTopics);
        mTopicChildList.put(mTechnologyHeaderList.get(2), androidTopics);
        mTopicChildList.put(mTechnologyHeaderList.get(3), iOSTopics);
        return mTopicChildList;
    }
}