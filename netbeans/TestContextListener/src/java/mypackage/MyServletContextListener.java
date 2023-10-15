package mypackage;
/* ตัวสร้าง Action ที่เกิดขึ้น เมื่อมีคนลงทะเบียน */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override /* method นี้จะถูกเรียกใช้ เมื่อcontext ถูกสร้างขึ้น (Implement) */
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        /* อ่านค่า(value) ของContext */
        String dogBreed = sc.getInitParameter("breed");
        Dog d = new Dog(dogBreed);
        /* setAttribute ระดับContext, component ทุกตัวจะรู้จัก */
        sc.setAttribute("dog", d);
    }

    @Override /* method นี้จะถูกเรียกใช้ เมื่อcontext ถูกทำลาย (Default) */
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
