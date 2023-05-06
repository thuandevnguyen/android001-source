package demo_access_modifier;

public class PublicDemoClass1 {
    private DemoInnerClass inner;
    private DemoStaticNestedClass staticNested;

    public PublicDemoClass1() {
        inner = new DemoInnerClass();
        staticNested = new DemoStaticNestedClass();
    }

    //region Instance methods
    public void outerPublicMethod() {

    }

    protected void outerProtectedMethod() {

    }

    private void outerPrivateMethod() {

    }
    //endregion

    //region Static methods
    public static void outerPublicStaticMethod() {
    }

    private static void outerPrivateStaticMethod() {
    }

    protected static void outerProtectedStaticMethod() {
    }
    //endregion

    // đây là 1 inner class, hay còn gọi là non-static nested class
    private class DemoInnerClass {
        void demoMethod() {
            // truy cap duocx mọi methods và properies (instance/static)
            PublicDemoClass1.this.inner.toString();
            PublicDemoClass1.this.outerPublicMethod();
            PublicDemoClass1.this.outerProtectedMethod();
            PublicDemoClass1.this.outerPrivateMethod();

            PublicDemoClass1.outerPrivateStaticMethod();
            PublicDemoClass1.outerPublicStaticMethod();
            PublicDemoClass1.outerProtectedStaticMethod();
        }
    }

    // đây là static nested class
    private static class DemoStaticNestedClass {
        void demoMethod() {
            // chỉ truy cập được static methods & properties.
            PublicDemoClass1.outerPrivateStaticMethod();
            PublicDemoClass1.outerPublicStaticMethod();
            PublicDemoClass1.outerProtectedStaticMethod();
        }
    }
}

//
//class MainActivity {
//
//    class Xyz {
//        void run() {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    MainActivity activity = MainActivity.this;
//                }
//            }).start();
//        }
//    }
//}