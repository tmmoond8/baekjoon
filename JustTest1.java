/**
 * Created by moonti on 2016. 11. 11..
 */
public class JustTest1 {

    public static void main(String args[]) {
        V vInstance = new C();
        vInstance.a();
        vInstance.b();
        ((C)vInstance).c();
    }

    interface V {
        void a();
        void b();
    }

    static class C implements V {

        @Override
        public void a() {
            System.out.println("a");
        }

        @Override
        public void b() {
            System.out.println("b");

        }
        public void c() {
            System.out.println("c");
        }
    }
}
