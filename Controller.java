public class Controller {

    RadioInterface radio;
    View view;

    public Controller() {
        this.radio = new Radio();
        this.view = new View();
    }

    public void Start() {
        int option = 0;
        view.showStatus(radio.isOn(), radio.getBand().equals("AM"), radio.getCurrentStation());

        while (option != 6) {
            view.showMenu();
            String entry = view.askOption(option);

            // intenta convertir la entrada a numero, si el usuario escribe otra cosa asigna 0
            try {
                option = Integer.parseInt(entry.trim());
            } catch (NumberFormatException e) {
                option = 0;
            }

            switch (option) {
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
                    selectStation();
                    break;
                case 6:
                    togglePower();
                    break;
                default:
                    view.showMessage("opcion no valida, vuelva a intentar");
            }
        }
    }

    private void togglePower() {
        if (radio.isOn()) {
            radio.turnOff();
            view.showMessage("la radio se ha apagado");
        } else {
            radio.turnOn();
            view.showMessage("la radio se ha encendido");
        }
        showCurrentStatus();
    }

    private void changeBand() {
        if (radio.getBand().equals("AM")) {
            radio.switchBand("FM");
            view.showMessage("cambiando a FM");
        } else {
            radio.switchBand("AM");
            view.showMessage("cambiando a AM");
        }
        showCurrentStatus();
    }

    private void showCurrentStatus() {
        view.showStatus(radio.isOn(), radio.getBand().equals("AM"), radio.getCurrentStation());
    }

    private void nextStation() {
        if (!radio.isOn()) {
            view.showMessage("la radio esta apagada, no se puede cambiar de emisora");
            return;
        }
        radio.nextStation();
        view.showMessage("cambiando de emisora");
        showCurrentStatus();
    }

    private void saveStation() {
        if (!radio.isOn()) {
            view.showMessage("la radio esta apagada, no se puede guardar emisora");
            return;
        }

        String buttonF = String.valueOf(view.getButton());

        try {
            int button = Integer.parseInt(buttonF);
            if (button < 1 || button > 12) {
                view.showMessage("boton no valido, seleccione un boton entre 1 y 12");
            } else {
                radio.saveStation(buttonF);
                view.showMessage("Emisora guardada");
                showCurrentStatus();
            }
        } catch (NumberFormatException e) {
            view.showMessage("boton no valido, seleccione un boton entre 1 y 12");
        }
    }

    private void selectStation() {
        if (!radio.isOn()) {
            view.showMessage("la radio esta apagada, no se puede cambiar de emisora");
            return;
        }

        String buttonF = String.valueOf(view.getButton());

        try {
            int button = Integer.parseInt(buttonF);
            if (button < 1 || button > 12) {
                view.showMessage("boton no valido, seleccione un boton entre 1 y 12");
            } else {
                radio.selectStation(buttonF);
                view.showMessage("Emisora seleccionada");
                showCurrentStatus();
            }
        } catch (NumberFormatException e) {
            view.showMessage("boton no valido, seleccione un boton entre 1 y 12");
        }
    }
}



