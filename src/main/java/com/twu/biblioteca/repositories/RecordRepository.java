package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Record;

import java.util.List;

public interface RecordRepository extends Repository<List<Record>>{
    public List<Record> findRecordsByAcconut(String account);

    void add(Record record);
}
