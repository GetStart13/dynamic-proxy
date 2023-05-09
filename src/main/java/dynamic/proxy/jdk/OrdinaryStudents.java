package dynamic.proxy.jdk;

/**
 * 小韭菜，能跑，能吃，能写作文。
 */
public class OrdinaryStudents implements Student {
    @Override
    public void eat() {
        System.out.println("普通学生：我在吃饭！");
    }

    @Override
    public void run() {
        System.out.println("普通学生：我在跑步！");
    }

    @Override
    public void write() {
        System.out.println("普通学生：我在写作文!");
    }
}
