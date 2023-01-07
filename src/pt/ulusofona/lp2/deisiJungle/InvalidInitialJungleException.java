package pt.ulusofona.lp2.deisiJungle;

public class InvalidInitialJungleException extends Exception {
    String message;
    boolean invalidPlayer;
    boolean invalidFood;

    public InvalidInitialJungleException(String message, boolean invalidPlayer, boolean invalidFood){
        this.message = message;
        this.invalidFood = invalidFood;
        this.invalidPlayer = invalidPlayer;
    }

    public String getMessage(){
        return message;
    }

    public boolean isInvalidPlayer(){
        return invalidPlayer;
    }

    public boolean isInvalidFood(){
        return invalidFood;
    }
}
