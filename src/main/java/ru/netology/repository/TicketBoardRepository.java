package ru.netology.repository;


import ru.netology.domain.TicketBoard;

public class TicketBoardRepository {
    private TicketBoard[] ticketBoards = new TicketBoard[0];

    public void add(TicketBoard ticket) {
        int length = ticketBoards.length + 1;

        TicketBoard[] tickets = new TicketBoard[length];

        System.arraycopy(ticketBoards, 0, tickets, 0, ticketBoards.length);

        int lastIndex = tickets.length - 1;
        tickets[lastIndex] = ticket;

        ticketBoards = tickets;
    }

    public TicketBoard[] getAll() {
        return ticketBoards;
    }

    public void removeById(int id) {
        int length = ticketBoards.length - 1;
        TicketBoard[] tickets = new TicketBoard[length];

        int index = 0;
        for (TicketBoard ticket : ticketBoards) {
            if (ticket.getId() != id) {
                tickets[index] = ticket;
                index++;
            }
        }
        ticketBoards = tickets;
    }
}