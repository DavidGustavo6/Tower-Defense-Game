package org.example.viewer;

import org.example.gui.Window;
import org.example.model.game.Position;
import org.example.model.menu.Leaderboard;
import org.example.viewer.menu.LeaderboardViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LeaderboardViewerTest {

    @Test
    void drawElements() {
        Leaderboard leaderboard = new Leaderboard(); // You need to create an instance of Leaderboard with some entries
        LeaderboardViewer leaderboardViewer = new LeaderboardViewer(leaderboard);

        Window window = Mockito.mock(Window.class);
        leaderboardViewer.drawElements(window);
        Mockito.verify(window, Mockito.times(leaderboard.getNumberEntries())).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
