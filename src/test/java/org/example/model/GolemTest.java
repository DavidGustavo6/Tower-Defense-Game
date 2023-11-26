package org.example.model;

import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Golem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GolemTest {
    @Test
    public void testHurt() {
        Golem golem = new Golem(1,1);
        golem.hurt(30);
        assertEquals(970, golem.getActHP());
    }
    @Test
    public void testGetX() {
        Golem golem = new Golem(1,1);
        assertEquals(1, golem.getX());
    }

    @Test
    public void testGetY() {
        Golem golem = new Golem(1,1);
        assertEquals(1, golem.getY());
    }

    @Test
    public void testSetX() {
        Golem golem = new Golem(1,1);
        golem.setPosition(new Position(30,1));
        assertEquals(30, golem.getX());
    }

    @Test
    public void testSetY() {
        Golem golem = new Golem(1,1);
        golem.setPosition(new Position(1,40));
        assertEquals(40, golem.getY());
    }
}
