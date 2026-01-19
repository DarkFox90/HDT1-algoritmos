public class Controller {
    IRadio radio;
    View view;

    public Controller() {
        this.radio = new Radio();
        this.view = new View();
    }
    
    public void Start(){
        int option = 0;
        view.showStatus(radio.isOn(), radio.isAm(), radio.getFrequence());
        while (option != 6){
            view.showMenu();
            String entry =  view.askOption(option);

            //intenta convertir la entrada a numero, si el usuario escribe otra cosa asigna 0 para evitar cualquiqer error
            try {
                option = Integer.parseInt(entry.trim());
            } catch (NumberFormatException e) {
                option = 0;
            }

            switch (option){
                case 1:
                    togglePower();
                    break;
                case 2:
                    changeBand();
                    break;
                case 3:
                    nextStation();
                    break;
                case 4:
                    saveStation();
                    break;
                case 5:
                    selecStation();
                    break;
                case 6:
                    togglePower();
                    break;
                default:
                    view.showMessage("opcion no valida, vuelva a intentar");
            }
        }
           
        
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

