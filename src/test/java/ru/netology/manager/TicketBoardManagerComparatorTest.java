package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketBoard;
import ru.netology.domain.TicketComparator;
import ru.netology.repository.TicketBoardRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketBoardManagerComparatorTest {
    private TicketBoardRepository repository = new TicketBoardRepository();
    TicketBoardManager manager = new TicketBoardManager(repository);
    private TicketBoard first = new TicketBoard(1, 1500, "MOW", "LED", 90);
    private TicketBoard second = new TicketBoard(2, 890, "MOW", "VOZ", 60);
    private TicketBoard third = new TicketBoard(3, 2150, "MOW", "KRR", 130);
    private TicketBoard fourth = new TicketBoard(4, 890, "MOW", "VOZ", 60);
    private TicketBoard fifth = new TicketBoard(5, 2500, "MOW", "KRR", 100);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldComparatorSort() {

        TicketBoard[] actual = manager.findAll("MOW", "KRR", new TicketComparator());
        TicketBoard[] expected = new TicketBoard[]{fifth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldComparatorSortNotExist() {

        TicketBoard[] actual = manager.findAll("VOZ", "KRR", new TicketComparator());
       TicketBoard[] expected = new TicketBoard[]{};

        assertArrayEquals(expected, actual);
    }

}