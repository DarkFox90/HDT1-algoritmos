import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testPower(){
        Radio radio = new Radio();
        radio.setPower(true);
        assertTrue(radio.isOn());
        radio.setPower(false);
        assertFalse(radio.isOn());
    }

    @Test
    public void testNext(){
        Radio radio = new Radio();
        radio.setBand(true);
        radio.next();
        assertEquals(540, radio.getFrequence(), 0.1);
        radio.setBand(false);
        radio.next();
        assertEquals(88.1, radio.getFrequence(), 0.1);
    }
    
}
