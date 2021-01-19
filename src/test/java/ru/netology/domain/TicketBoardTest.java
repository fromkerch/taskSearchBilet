package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class TicketBoardTest {
    private TicketBoard first = new TicketBoard(1, 1500, "MOW", "LED", 90);
    private TicketBoard second = new TicketBoard(2, 890, "MOW", "VOZ", 60);
    private TicketBoard third = new TicketBoard(3, 2150, "MOW", "KRR", 120);
    private TicketBoard fourth = new TicketBoard(4, 890, "MOW", "VOZ", 60);
    private TicketBoard fifth = new TicketBoard( 5,860, "MOW", "ROV", 70);
    private TicketBoard sixth = new TicketBoard( 6,800, "MOW", "SIP", 80);
    private TicketBoard seventh = new TicketBoard( 7,700, "MOW", "OVB", 140);


    @Test
    public void shouldSortedByPrice() {
        TicketBoard[] expected = new TicketBoard[]{seventh, sixth, fifth, fourth, second, first, third};
        TicketBoard[] actual = new TicketBoard[]{seventh, sixth, fifth, fourth, second, first, third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}