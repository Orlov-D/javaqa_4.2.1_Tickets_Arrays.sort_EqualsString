package ru.netology.repository;

import ru.netology.domain.FlyChoice;
import ru.netology.exception.NotFoundException;

public class FlyChoiceRepository {
    private FlyChoice[] items = new FlyChoice[0];

    public void save(FlyChoice item) {
        int length = items.length + 1;
        FlyChoice[] tmp = new FlyChoice[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FlyChoice[] findAll() {
        return items;
    }

    public FlyChoice findById(int id) {
        for (FlyChoice item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id = " + id + " не найден!");
        }
        int length = items.length - 1;
        FlyChoice[] tmp = new FlyChoice[length];
        int index = 0;
        for (FlyChoice item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}