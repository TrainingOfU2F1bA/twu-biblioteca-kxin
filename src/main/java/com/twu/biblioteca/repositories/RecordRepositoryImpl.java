package com.twu.biblioteca.repositories;

import com.twu.biblioteca.model.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordRepositoryImpl implements RecordRepository {

    Map<String,List<Record>> map=new HashMap<>();

    @Override
    public List<Record> findRecordsByAcconut(String account) {
        return map.get(account);
    }

    @Override
    public List<List<Record>> list() {
        return new ArrayList<>(map.values());
    }

    @Override
    @Deprecated
    public List<Record> find(Long id) {
        throw new RuntimeException();
    }

    @Override
    @Deprecated
    public List<Record> findByName(String name) {
        throw new RuntimeException();
    }

    @Override
    public void add(Record record) {
        map.computeIfAbsent(record.getCustomer().getAccount(),value->new ArrayList<>()).add(record);
    }

    @Override
    public void add(List<Record> records) {
        records.forEach(record -> map.computeIfAbsent(record.getCustomer().getAccount(),value->new ArrayList<>()).add(record));

    }

    @Override
    @Deprecated
    public void delete(Long id) {
        throw new RuntimeException();
    }
}
