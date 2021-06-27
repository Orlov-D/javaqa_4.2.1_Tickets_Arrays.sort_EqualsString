package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlyChoice;
import ru.netology.repository.FlyChoiceRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlyChoiceManagerTest {

    FlyChoiceRepository flyChoiceRepository = new FlyChoiceRepository();
    FlyChoiceManager flyChoiceManager = new FlyChoiceManager(flyChoiceRepository);

    FlyChoice likeTicket1 = new FlyChoice(0, 1000, "SvN", "BGN", 60);
    FlyChoice likeTicket2 = new FlyChoice(1, 1500, "svn", "THG", 112);
    FlyChoice likeTicket3 = new FlyChoice(2, 780, "GFH", "FRD", 78);
    FlyChoice likeTicket4 = new FlyChoice(3, 900, "SVN", "BGN", 90);
    FlyChoice likeTicket5 = new FlyChoice(4, 1200, "BGN", "SVN", 100);
    FlyChoice likeTicket6 = new FlyChoice(5, 2000, "SVN", "BGN", 120);

    @Test
    void findAllMany() {
        flyChoiceManager.add(likeTicket1);
        flyChoiceManager.add(likeTicket2);
        flyChoiceManager.add(likeTicket3);
        flyChoiceManager.add(likeTicket4);
        flyChoiceManager.add(likeTicket5);
        flyChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{likeTicket4, likeTicket1, likeTicket6}, flyChoiceManager.findAll("svn", "bgn"));
    }

    @Test
    void findAllOne() {
        flyChoiceManager.add(likeTicket1);
        flyChoiceManager.add(likeTicket2);
        flyChoiceManager.add(likeTicket3);
        flyChoiceManager.add(likeTicket4);
        flyChoiceManager.add(likeTicket5);
        flyChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{likeTicket3}, flyChoiceManager.findAll("gfH", "Frd"));
    }

    @Test
    void findAllNothing() {
        flyChoiceManager.add(likeTicket1);
        flyChoiceManager.add(likeTicket2);
        flyChoiceManager.add(likeTicket3);
        flyChoiceManager.add(likeTicket4);
        flyChoiceManager.add(likeTicket5);
        flyChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{}, flyChoiceManager.findAll("bbb", "aaa"));
    }
}