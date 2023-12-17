package org.example.model.game.elements.towers;
import org.example.model.game.Position;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.MageTower;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class MageTowerTest {

    @Test
    public void testAttack() {
        Enemy enemy = Mockito.mock(Enemy.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(2, 3));
        MageTower mageTower = new MageTower(1,1);
        if(mageTower.isInRange(enemy)){
            mageTower.attack(enemy);
        }
        verify(enemy).hurt(mageTower.dealDamage());
    }

    @Test
    public void testDealDamage() {
        MageTower mageTower = new MageTower(1,1);
        int damage = mageTower.dealDamage();
        assertEquals(25, damage);
    }

    @Test
    public void testUpgrade() {
        MageTower mageTower = new MageTower(1,1);

        mageTower.upgrade();
        assertEquals(2, mageTower.getLevel());
        assertEquals(14, mageTower.getRange());
        assertEquals(125, mageTower.getLife());
    }

    @Test
    public void testTripleUpgrade() {
        MageTower mageTower = new MageTower(1,1);
        mageTower.upgrade();
        mageTower.upgrade();
        mageTower.upgrade();
        assertEquals(4, mageTower.getLevel());
        assertEquals(22, mageTower.getRange());
        assertEquals(175, mageTower.getLife());
    }
    @Test
    public void testGetX() {
        MageTower mageTower = new MageTower(1,1);
        assertEquals(1, mageTower.getX());
    }

    @Test
    public void testGetY() {
        MageTower mageTower = new MageTower(1,1);
        assertEquals(1, mageTower.getY());
    }

    @Test
    public void testSetX() {
        MageTower mageTower = new MageTower(1,1);
        mageTower.setPosition(new Position(30,1));
        assertEquals(30, mageTower.getX());
    }

    @Test
    public void testSetY() {
        MageTower mageTower = new MageTower(1,1);
        mageTower.setPosition(new Position(1,40));
        assertEquals(40, mageTower.getY());
    }
}