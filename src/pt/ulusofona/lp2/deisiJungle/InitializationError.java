package pt.ulusofona.lp2.deisiJungle;

class InitializationError{
    String mensagem;

    public InitializationError(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMessage(){
        return mensagem;
    }
}

/*public enum InitializationError{
    //Player and board checks
    WRONGPLAYERAMOUNT, REPEATEDPLAYER, ILLEGALNAME , WRONGJUNGLESIZE, NEGATIVEID,
    WRONGTYPEID, ILLEGALANIMAL, TOOMANYTARZAN, GOODPLAYERATTRIBUTES, THISPLAYERSINFOISNULL, PLAYERINFOISNULL,

    //FoodChecks
    FOODSINFOISNULL, WRONGFOODARRAYDIMENSIONS, FOODOUTSIDETABULEIRO, ILLEGALFOOD
};
/* No clue where to go
public String getMessage(String message){
        return "";
}
 */