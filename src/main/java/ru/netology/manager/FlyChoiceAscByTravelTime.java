package ru.netology.manager;

import ru.netology.domain.FlyChoice;

import java.util.Comparator;

public class FlyChoiceAscByTravelTime implements Comparator<FlyChoice> {
    public int compare(FlyChoice o1, FlyChoice o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
