package org.example.states;

import org.example.Game;
import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.gui.Window;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    private Game game;
    private long TIME_FIXED = 500;
    private long totalTime, pastTime;
    Window window;

    public GameState(Arena arena) throws Exception {
        super(arena);
        initialize();
    }

    public void initialize() throws Exception {
        totalTime = 0;
        pastTime = System.currentTimeMillis();
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
    public void update() throws Exception {
        for(Enemy enemy : getModel().getEnemies()){
            enemy.moveEnemies(enemy);
        }if(getModel().getTowers() != null){
            for(Towe enemy : getModel().getEnemies()){
                enemy.moveEnemies(enemy);
        }
    }
    @Override
    public void step(Game game, Window window, long time) throws Exception {
        totalTime += getTimePassed();
        while(totalTime >=TIME_FIXED){
            update();
            totalTime -= TIME_FIXED;
        }
        getViewer().draw(window);
    }
    public long getTimePassed() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - pastTime;
        pastTime = currentTime;
        return timePassed;
    }
}