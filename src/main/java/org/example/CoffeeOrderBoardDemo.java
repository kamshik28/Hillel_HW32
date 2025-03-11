package org.example;


/**
 * Приклад використання CoffeeOrderBoard.
 */
public class CoffeeOrderBoardDemo {

    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Alen");
        board.add("Yoda");
        board.add("Obi-van");
        board.add("John Snow");

        board.draw();

        System.out.println("Deliver FIFO: " + board.deliver());

        System.out.println("Deliver by number (33): " + board.deliver(33));

        board.add("Arya Stark");

        board.draw();
    }
}

