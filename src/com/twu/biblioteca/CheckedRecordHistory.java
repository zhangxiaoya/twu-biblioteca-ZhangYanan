package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanzhang on 8/6/16.
 */
public class CheckedRecordHistory {
    private List<CheckedRecod> RecordHistory;

    public CheckedRecordHistory(){
        RecordHistory = new ArrayList<CheckedRecod>();
    }

    public List<CheckedRecod> getRecordHistory(){
        return RecordHistory;
    }
}
