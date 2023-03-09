package fr.ensim.dp.map.player;

public class BackwradState extends IllegalStatePlayer {
    @Override
    public void forward(IPlayer player) {
        player.firechangeState(new ForwardState());
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StopState());
    }
}
