package fr.ensim.dp.map.player;

public class ForwardState extends IllegalStatePlayer{
    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new BackwradState());
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StopState());
    }
}
