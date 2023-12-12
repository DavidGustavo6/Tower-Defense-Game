package org.example.model.game;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.*;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private List<Enemy> enemyList;

    private boolean waveCompleted;

    Level level ;
    public Wave(){
        this.enemyList= new ArrayList<>();
        this.waveCompleted=false;
    }

    public List<Enemy> spawn(int level){
        for (int i = 0; i < (5*level); i++) {
            int enemyTypeIndex = 1 + (int) (Math.random() * 3);
            Enemy enemy;
            switch (enemyTypeIndex) {
                case 1:
                    enemy = new Orc(i, 5);
                    break;
                case 2:
                    enemy = new Golem(i, 6);
                    break;
                case 3:
                    enemy = new Skeleton(i, 7);
                    break;
                default:
                    enemy = null;
                    break;
            }
            enemyList.add(enemy);
        }
        return enemyList;
    }


    public boolean isCompleted(){
        return waveCompleted;
    }
    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
