package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.model.RentalGoods;

import java.util.List;

public interface RecordRepository extends Repository<List<Record>> {
    public List<Record> findRecordsByAcconut(String account);

    void add(Record record);

    Record findRecordOfGoods(Long l);

    void deleteRecord(String account, Long id);
}
