package com.twu.biblioteca;

public class BibliotecaSystemRelease2 extends BibliotecaSystem{


    @Override
    public void mainMenu() {
        System.out.println("1.List Books\r\n2.Return Books\r\n3.Checkout Books\r\n4.Record List\r\n5.Find books\r\n6.List Movie\r\n7.Checkout Movie");
    }

    @Override
    public int chooseItem() {
        final int index = getScanner().readInt();
        return 1;
    }
}
