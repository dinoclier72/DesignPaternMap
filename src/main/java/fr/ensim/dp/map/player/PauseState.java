package fr.ensim.dp.map.player;

public class PauseState extends IllegalStatePlayer{
    @Override
    public void play(IPlayer player){
        player.firechangeState(new PlayState());
    }
}
