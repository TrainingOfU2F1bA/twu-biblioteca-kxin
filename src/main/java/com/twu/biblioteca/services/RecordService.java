package com.twu.biblioteca.services;

import com.sun.javafx.binding.StringFormatter;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.model.RentalGoods;
import com.twu.biblioteca.repositories.RecordRepository;

import java.util.List;

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
        List<Record> records = recordRepository.findRecordsByAcconut(customer.getAccount());
        if (records!=null){
            records.forEach(record -> {
                builder.append(StringFormatter.format("UserName:" + record.getCustomer().getUserName() +
                        "\r\nRentalGood Name:" + record.getRentalGoods().getName() +
                        "\r\nGood Class:" + record.getRentalGoods().getClass().getName() +
                        "\r\n").getValue());
            });
            System.out.print(builder);
        }else {
            System.out.println("No Record!");
        }
    }

    public void deteleGoodsRentRecord(String account, Long id) {
        recordRepository.deleteRecord(account,id);
    }

    public Record findBookRecord(long id) {
        Record recordOfGoods = recordRepository.findRecordOfGoods(id);
        if (recordOfGoods!=null&&recordOfGoods.getRentalGoods() instanceof Book) return recordOfGoods;
        return null;
    }
}
