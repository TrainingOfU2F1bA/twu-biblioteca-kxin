package com.twu.biblioteca.services;

import com.sun.javafx.binding.StringFormatter;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.model.RentalGoods;
import com.twu.biblioteca.repositories.RecordRepository;

public class RecordService {
    RecordRepository recordRepository;

    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void createRecord(RentalGoods rentalGoods, Customer customer) {
        recordRepository.add(new Record(customer, rentalGoods));
    }

    public void displayRecordList(Customer customer) {
        StringBuilder builder = new StringBuilder();
        recordRepository.findRecordsByAcconut(customer.getAccount()).forEach(record -> {
            builder.append(StringFormatter.format("UserName:" + record.getCustomer().getUserName() +
                    "\r\nRentalGood Name:" + record.getRentalGoods().getName() +
                    "\r\nGood Class:" + record.getRentalGoods().getClass().getName() +
                    "\r\n").getValue());
        });
        System.out.print(builder);
    }
}
