package ru.netology.manager;


import ru.netology.domain.FlyChoice;
import ru.netology.repository.FlyChoiceRepository;

import java.util.Arrays;
import java.util.Comparator;

public class FlyChoiceManager {
    private FlyChoiceRepository flyChoiceRepository;

    public FlyChoiceManager(FlyChoiceRepository flyChoiceRepository) {
        this.flyChoiceRepository = flyChoiceRepository;
    }

    public void add(FlyChoice flyChoice) {
        flyChoiceRepository.save(flyChoice);
    }

    public FlyChoice[] findAll(String from, String to, Comparator<FlyChoice> comparator) {
        FlyChoice[] result = new FlyChoice[0];
        for (FlyChoice flyChoice : flyChoiceRepository.findAll()) {
            if (flyChoice.getAirportFrom().equalsIgnoreCase(from) & flyChoice.getAirportTo().equalsIgnoreCase(to)) {
                FlyChoice[] tmp = new FlyChoice[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flyChoice;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
