package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FlyChoice implements Comparable<FlyChoice> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    public int compareTo(FlyChoice o) {
        return this.price - o.price;
    }
}
