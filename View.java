import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("1. encender la radio");
        System.out.println("2. cambiar AM a FM");
        System.out.println("3. cambiar frecuencia");
        System.out.println("4. guardar emisora");
        System.out.println("5. seleccionar emisora");
        System.out.println("6. apagar radio");
        return sc.nextInt();

    }

    public void showStatus(boolean on, boolean am, double frequence) {
        if (on == false) {
            System.out.println("la radio esta apagada");
        } else {
            System.out.println("radio encendida");
        }
        
        if (am == true) {
            System.out.println("emisora en AM");
        } else {
            System.out.println("emisora en FM");
        }
        
        System.out.println("frecuencia actual: " + frequence);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
