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
    
}
