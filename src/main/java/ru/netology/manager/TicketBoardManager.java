package ru.netology.manager;

import ru.netology.domain.TicketBoard;
import ru.netology.repository.TicketBoardRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketBoardManager {
    private TicketBoardRepository repository;


    public TicketBoardManager(TicketBoardRepository repository) {
        this.repository = repository;
    }

    public void add(TicketBoard ticket) {
        repository.add(ticket);
    }


    public TicketBoard[] findAll(String from, String to) {
        TicketBoard[] result = new TicketBoard[0];

        for (TicketBoard ticket : repository.getAll()) {
            if (from.equals(ticket.getDeparture()) && to.equals(ticket.getArrival())) {

                TicketBoard[] tickets = new TicketBoard[result.length + 1];
                System.arraycopy(result, 0, tickets, 0, result.length);
                tickets[tickets.length - 1] = ticket;
                result = tickets;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketBoard[] findAll(String from, String to, Comparator<TicketBoard> comparator) {
        TicketBoard[] result = new TicketBoard[0];

        for (TicketBoard ticket : repository.getAll()) {
            if (from.equals(ticket.getDeparture()) && to.equals(ticket.getArrival())) {

                TicketBoard[] tickets = new TicketBoard[result.length + 1];
                System.arraycopy(result, 0, tickets, 0, result.length);
                tickets[tickets.length - 1] = ticket;
                result = tickets;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}