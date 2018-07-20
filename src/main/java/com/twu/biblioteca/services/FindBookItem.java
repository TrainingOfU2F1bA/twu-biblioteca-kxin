package com.twu.biblioteca.services;

import com.twu.biblioteca.BibliotecaScanner;
import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.model.User;

public class FindBookItem implements NewOptionalItem{
    private RecordService recordService;

    public FindBookItem(RecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public int run(User user) {
        System.out.println("Which Book do you want to find:");
        int i = new BibliotecaScanner().readInt();
        Record bookRecord = recordService.findBookRecord(i);
        if (bookRecord!=null) {
            System.out.println("BookId:"+bookRecord.getRentalGoods().getId()+"\r\nBookName:"+bookRecord.getRentalGoods().getName()+"\r\nUserName:"+bookRecord.getCustomer().getUserName());
        }else {
            System.out.println("Did not find the book record!");
        }
        return 5;
    }
}
