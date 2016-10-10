package proyecto;

import sun.net.www.content.text.Generic;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Dao {

    private String getMethod(String m) {
        m = m.substring(0, 1).toUpperCase() + m.substring(1);
        return "get" + m;
    }

    public void insert() {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ").append(this.getClass().getSimpleName());
        System.out.println(sb.toString());


        Field[] fields = this.getClass().getFields();

        sb.append(" (");
        int atrib = 0;
        for (Field f : fields) {
            System.out.println(f.getName());
            sb.append(f.getName()).append(",");
            atrib++;
        }

        sb.replace(sb.length() - 1, sb.length(), ") VALUES (");
        for (Field ff : fields) {
            sb.append("?,");
        }
        sb.replace(sb.length() - 1, sb.length(), ") ");

        System.out.println("QUERY: " + sb.toString());

        for (Field f : fields) {

            try {
                Method m = this.getClass().getMethod(getMethod(f.getName()), null);
                Object ret = m.invoke(this, null);
                if (ret instanceof String) {

                    System.out.println("res : " + ret.toString());
                }
                if (ret instanceof Integer) {
                    int id = (int) ret;
                    System.out.println("res : " + id);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    abstract Generic select();

    abstract void update();

    abstract void delete();
}