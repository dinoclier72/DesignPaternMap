package fr.ensim.dp.map.player;

public class Player implements IPlayer{
    IStatePlayer s;

    @Override
    public void play() {
        s.play(this);
    }

    @Override
    public void stop() {
        s.stop(this);
    }

    @Override
    public void pause() {
        s.pause(this);
    }

    @Override
    public void forward() {
        s.forward(this);
    }

    @Override
    public void backward() {
        s.backward(this);
    }

    @Override
    public void firechangeState(IStatePlayer state) {
        s = state;
    }
}
