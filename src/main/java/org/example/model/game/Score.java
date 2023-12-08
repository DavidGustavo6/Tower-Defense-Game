package org.example.model.game;

import org.example.viewer.game.GameViewer;

public class Score{
    private int score;
    private GameViewer gameViewer;
    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore(int points) {
        score += points;
    }


    // Outros métodos relacionados ao modelo de score, se necessário
}
