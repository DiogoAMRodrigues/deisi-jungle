package pt.ulusofona.lp2.deisiJungle;

public enum InitializationError{
    //Player and board checks
    WRONGPLAYERAMOUNT, REPEATEDPLAYER, ILLEGALNAME , WRONGJUNGLESIZE, NEGATIVEID,
    WRONGTYPEID, ILLEGALANIMAL, TOOMANYTARZAN, GOODPLAYERATTRIBUTES, THISPLAYERSINFOISNULL, PLAYERINFOISNULL,

    //FoodChecks
    FOODSINFOISNULL, WRONGFOODARRAYDIMENSIONS, FOODOUTSIDETABULEIRO, ILLEGALFOOD;

    public String getMessage(String message){
        String msg = "";
        if (message != null && !message.equals("")){
            msg = message;
        }else {
            return "Ilegal";
        }
        return msg;
    }
}




