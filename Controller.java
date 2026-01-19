public class Controller {
    IRadio radio;
    View view;

    public Controller(IRadio radio, View view) {
        this.radio = radio;
        this.view = view;
    }
    // Falata implementar la logica de este metodo para iniciar la aplicacion
    public void Start(){

    }

    private void togglePower(){
        if (radio.isOn()){
            radio.setPower(false);
            view.showMessage("la radio se ha apagado");
        } else {
            radio.setPower(true);
            view.showMessage("la radio se ha encendido");
        }   
        showCurrentStatus();
    }
    

    private void changeBand(){
        if (radio.isAm()){
            radio.setBand(false);
            view.showMessage("cambiando a FM");
        } else {
            radio.setBand(true);
            view.showMessage("cambiando a AM");
        }
        showCurrentStatus();
    }

    private void showCurrentStatus(){
        view.showStatus(radio.isOn(), radio.isAm(), radio.getFrequence());
    }

    private void nextStation(){
        if (!radio.isOn()){
            view.showMessage("la radio esta apagada, no se puede cambiar de emisora");
            return;
        }
        radio.next();
        view.showMessage("cambiando de emisora");
        showCurrentStatus();
    }

    private void saveStation(){
        if (!radio.isOn()){
            view.showMessage("la radio esta apagada, no se puede guardar emisora");
            return;
        }
        radio.save(view.getButton());
        view.showMessage("emisora guardada");
        showCurrentStatus();
    }
    // Falata implementar la logica de este metodo para 
    private void selecStation(){

    }

}

