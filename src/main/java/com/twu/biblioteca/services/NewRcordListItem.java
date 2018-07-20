package com.twu.biblioteca.services;

import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.User;

public class NewRcordListItem implements NewOptionalItem{

    private RecordService recordService;

    public NewRcordListItem(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public int run(User user) {
        recordService.displayRecordList((Customer) user);
        return 4;
    }
}
