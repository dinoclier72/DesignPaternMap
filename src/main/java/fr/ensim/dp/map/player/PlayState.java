package fr.ensim.dp.map.player;

public class PlayState extends IllegalStatePlayer{
    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StopState());
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new BackwradState());
    }

    @Override
    public void pause(IPlayer player) {
        player.firechangeState(new PauseState());
    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(new ForwardState());
    }
}
