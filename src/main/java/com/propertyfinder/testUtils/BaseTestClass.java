package com.propertyfinder.testUtils;

import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.core.injector.Injector;
import com.propertyfinder.utils.PropertiesLoader;
import com.propertyfinder.utils.WaitManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.propertyfinder.constants.CommonConsts.ESCAPE_PROPERTY;
import static com.propertyfinder.constants.CommonConsts.PATH_TO_CONFIGURATION_PROPERTIES;


@Listeners(TestListener.class)
public abstract class BaseTestClass {

    protected WaitManager waitManager = new WaitManager();

    protected PropertiesLoader propertiesLoader = new PropertiesLoader(PATH_TO_CONFIGURATION_PROPERTIES);

    protected TestLogger LOG;

    @BeforeClass
    public void browserInstantiate() {
        System.setProperty(ESCAPE_PROPERTY, "false");
    }

    public void step(String message) {
        LOG.info(message);
    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG = TestLogger.getLogger(method.getName(), method.getDeclaringClass().getSimpleName());
        createInstance();
    }

    @AfterMethod
    public void dropDriver() {
        LOG.drop();
        WebDriverManager.stop();
    }

    private void createInstance() {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Injector) {
                    try {
                        LOG.debug("Trying to create instance " + field.getType());
                        Object object = field.getType().newInstance();
                        field.setAccessible(true);
                        field.set(this, object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
