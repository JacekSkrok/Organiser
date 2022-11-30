package io.github.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private HelloService SUT = new HelloService();
    @Test
    public void test_prepareGreeting_null_returnsGreetingWithFallbackValue()  {
        //given + when
        var result = SUT.prepareGreeting(null);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME, result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName()  {
        //given + when

        String name = "testname";

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name , result);
    }
}
