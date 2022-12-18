package pt.ulusofona.lp2.deisiJungle;

class InitializationError{
    private String mensagem;

    public InitializationError(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMessage(){
        return mensagem;
    }
}
