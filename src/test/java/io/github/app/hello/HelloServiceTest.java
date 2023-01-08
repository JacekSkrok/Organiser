package io.github.app.hello;

import io.github.app.hello.HelloService;
import io.github.app.lang.Lang;
import io.github.app.lang.LangRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private static final String WELCOME_MSG = "Hello";
    private static final String FALLBACK_ID_WELCOME = "Hola";
    @Test
    public void test_prepareGreeting_nullName_returnsGreetingWithFallbackName()  {
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        // when
        var result = SUT.prepareGreeting(null, "-1");

        //then
        assertEquals(WELCOME_MSG + " " + HelloService.FALLBACK_NAME, result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName()  {
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        String name = "testname";

        //when
        var result = SUT.prepareGreeting(name, "-1");

        //then
        assertEquals(WELCOME_MSG +" " + name , result);
    }

    @Test
    public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackIdLang()  {
        //given
        var mockRepository = fallbackLangIdRepository();
        var SUT = new HelloService(mockRepository);
        String name = "testname";

        //when
        var result = SUT.prepareGreeting(null, "abc");

        //then
        assertEquals(FALLBACK_ID_WELCOME +" " + HelloService.FALLBACK_NAME , result);
    }

    @Test
    public void test_prepareGreeting_textLang_returnsGreetingWithFallbackIdLang()  {
        //given
        var mockRepository = fallbackLangIdRepository();
        var SUT = new HelloService(mockRepository);

        //when
        var result = SUT.prepareGreeting(null, null);

        //then
        assertEquals(FALLBACK_ID_WELCOME +" " + HelloService.FALLBACK_NAME , result);
    }
    @Test
    public void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackIdLang() throws Exception  {
        //given
        var mockRepository = fallbackNonExistingLangRepository();
        var SUT = new HelloService(mockRepository);

        //when
        var result = SUT.prepareGreeting(null, "-1");

        //then
        assertEquals(HelloService.FALLBACK_LANG.getWelcomeMsg() +" " + HelloService.FALLBACK_NAME , result);
    }

    private LangRepository fallbackNonExistingLangRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findByID(Integer id) {
                return Optional.empty();
            }
        };
    }

    private  LangRepository fallbackLangIdRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findByID(Integer id) {
                if (id.equals(HelloService.FALLBACK_LANG.getId())) {
                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }
        };
    }


    private static LangRepository alwaysReturningHelloRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findByID(Integer id) {
                return Optional.of(new Lang(777, WELCOME_MSG, null));
            }
        };
    }

}
