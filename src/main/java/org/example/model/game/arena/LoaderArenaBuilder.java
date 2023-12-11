package org.example.model.game.arena;

import org.example.controller.game.EnemyController;
import org.example.model.game.Position;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.Path;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.enemys.Orc;
import org.example.model.game.elements.enemys.Skeleton;
import org.example.model.game.elements.towers.Tower;
import org.example.model.game.elements.enemys.Golem;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class LoaderArenaBuilder extends ArenaBuilder {
    private final List<String> lines;
    private Arena arena;

    public LoaderArenaBuilder() throws IOException {

        URL resource = LoaderArenaBuilder.class.getResource( "/map");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                else if(line.charAt(x) == '|') walls.add(new Wall(x, y));
                else if(line.charAt(x)== '-') walls.add(new Wall(x,y));
        }
        return walls;
    }
    @Override
    protected List<Path> createPaths() {
        List<Path> paths = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') paths.add(new Path(x, y));
        }
        return paths;
    }
    @Override
    protected Chest createChest() {
        Chest chest = null;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'C') return new Chest(x,y);
                }
        return null;
    }
    @Override
    public List<Enemy> createEnemies(Arena arena) {
        List<Enemy> enemies = new ArrayList<>();
        for(int i = 0; i<5; i++){
            Orc orc = new Orc(0+i,5);
            enemies.add(orc);
            Golem golem = new Golem(0+i,6);
            enemies.add(golem);
            Skeleton skeleton = new Skeleton(0+i,7);
            enemies.add(skeleton);
        }
        return enemies;
    }
}