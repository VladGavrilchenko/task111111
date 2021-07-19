package Main;

import java.lang.reflect.Method;
import Annotations.Text;


class TestClass {
     @Text(a = 1 , b = 2)
    public void test(int a, int b) {
      System.out.println(a + " " + b);
    }

}

public class Main {

    public static void main(String[] args) {
        try {
            Class<?> cls = TestClass.class;
            Method method = cls.getMethod("test", int.class, int.class);

            if(method.isAnnotationPresent(Text.class)) {
               Text text = method.getAnnotation(Text.class);
               method.invoke(null , text.a() , text.b());
            }

        }
        catch (Exception ex) {
           System.out.println(ex.getMessage());
        }
    }
}


