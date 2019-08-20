import junit.HelloWorld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHelloWorld {
    private HelloWorld h;

    @BeforeAll
    public void setUp() throws Exception
    {
        h = new HelloWorld();
    }

    @Test
    public void testHelloEmpty()
    {
        assertEquals(h.getName(),"");
        assertEquals(h.getMessage(),"Hello!");
    }

    @Test
    public void testHelloWorld()
    {
        h.setName("World");
        assertEquals(h.getName(),"World");
        assertEquals(h.getMessage(),"Hello World!");
    }
}
