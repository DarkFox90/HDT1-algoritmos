import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testPower() {
        Radio radio = new Radio();
        radio.turnOn();
        assertTrue(radio.isOn());       
        radio.turnOff();
        assertFalse(radio.isOn());
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();
        radio.turnOn();
        radio.switchBand("AM");
        radio.nextStation();
        assertEquals(540.0, radio.getCurrentStation(), 0.1);
        radio.switchBand("FM");
        radio.nextStation();
        assertEquals(88.1, radio.getCurrentStation(), 0.1);
    }

    @Test
    public void testSaveAndSelect() {
        Radio radio = new Radio();
        radio.turnOn();
        radio.switchBand("AM");
        radio.nextStation(); 
        double frecuenciaOriginal = radio.getCurrentStation();
        radio.saveStation("1");
        radio.nextStation();
        radio.selectStation("1");
        assertEquals(frecuenciaOriginal, radio.getCurrentStation(), 0.1);
    }
}