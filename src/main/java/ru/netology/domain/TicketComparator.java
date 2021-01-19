
package ru.netology.domain;

import java.util.Comparator;

public class TicketComparator implements Comparator<TicketBoard> {
    public int compare(TicketBoard o1, TicketBoard o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}