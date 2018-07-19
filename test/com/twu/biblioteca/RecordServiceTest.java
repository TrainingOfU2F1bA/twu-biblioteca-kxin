package com.twu.biblioteca;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Record;
import com.twu.biblioteca.repositories.RecordRepository;
import com.twu.biblioteca.services.RecordService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RecordServiceTest {

    private RecordService recordService;
    private List<Record> tomRecords;
    private List<Record> marryRecords;
    private Customer tom;
    private Customer marry;
    private RecordRepository recordRepository;

    @Before
    public void setUp() {
        recordRepository = Mockito.mock(RecordRepository.class);
        Movie movie = new Movie(1l, "Titan X", "James Chou", "A", new Date(1996, 1, 1));
        Book book = new Book(2l, "The Wealth of the Nations", "Adam Smith", new Date(2012, 1, 1));
        tom = new Customer(2l, "Tom", "010-8888", 18, "123", "2312423", "dasdsa@123.com");
        marry = new Customer(1l, "Marry", "010-7777", 18, "123", "2312423", "dasdsa@123.com");
        tomRecords = Arrays.asList(
                new Record(tom, book)
        );
        marryRecords = Arrays.asList(
                new Record(marry, movie)
        );
        Mockito.when(recordRepository.findRecordsByAcconut("010-8888")).thenReturn(tomRecords);
        Mockito.when(recordRepository.findRecordsByAcconut("010-7777")).thenReturn(marryRecords);
        recordService = new RecordService();
        recordService.setRecordRepository(recordRepository);
    }

    @Test
    public void testCreateRecord() {
        Book book = new Book(3l, "The Wealth of the Nations", "Adam Smith", new Date(2012, 1, 1));
        recordService.createRecord(book,tom);
        Mockito.verify(recordRepository,Mockito.times(1)).add(Mockito.any(Record.class));
    }

    @Test
    public void testRecordList() {
        ByteArrayBuffer out = new ByteArrayBuffer();
        System.setOut(new PrintStream(out));
        recordService.displayRecordList(tom);
        Assert.assertEquals(out.toString(),"UserName:Tom\r\n" +
                "RentalGood Name:The Wealth of the Nations\r\n" +
                "Good Class:com.twu.biblioteca.model.Book\r\n");
    }

    @Test
    public void testDeleteGoodsRentRecord() {
        recordService.deteleGoodsRentRecord(tom.getAccount(),3l);
        Mockito.verify(recordRepository,Mockito.times(1)).deleteRecord(tom.getAccount(),3l);
    }

    @Test
    public void testFindGoodsRecord() {
        Book book = new Book(3l, "The Wealth of the Nations", "Adam Smith", new Date(2012, 1, 1));
        Record record = new Record(tom, book);
        Mockito.when(recordRepository.findRecordOfGoods(3l)).thenReturn(record);
    }
}
