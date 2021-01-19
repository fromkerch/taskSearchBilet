package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketBoard;
import ru.netology.repository.TicketBoardRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketBoardManagerTest {
    private TicketBoardRepository repository = new TicketBoardRepository();
    TicketBoardManager manager = new TicketBoardManager(repository);
    private TicketBoard first = new TicketBoard(1, 1500, "MOW", "LED", 90);
    private TicketBoard second = new TicketBoard(2, 890, "MOW", "VOZ", 60);
    private TicketBoard third = new TicketBoard(3, 2150, "MOW", "KRR", 130);
    private TicketBoard fourth = new TicketBoard(4, 890, "MOW", "VOZ", 60);
    private TicketBoard fifth = new TicketBoard(5, 2500, "MOW", "KRR", 130);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    public void shouldSearchLine() {
        TicketBoard[] expected = new TicketBoard[]{first};
        TicketBoard[] actual = manager.findAll("MOW", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineAndSort() {
        TicketBoard[] expected = new TicketBoard[]{third, fifth};
        TicketBoard[] actual = manager.findAll("MOW", "KRR");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineNotExist() {
        TicketBoard[] expected = new TicketBoard[]{};
        TicketBoard[] actual = manager.findAll("VOZ", "KRR");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineEqualsPrice() {
        TicketBoard[] expected = new TicketBoard[]{second, fourth};
        TicketBoard[] actual = manager.findAll("MOW", "VOZ");

        assertArrayEquals(expected, actual);
    }

}