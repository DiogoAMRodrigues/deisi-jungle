package pt.ulusofona.lp2.deisiJungle;

class InitializationError{
    String message;

    public InitializationError(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}