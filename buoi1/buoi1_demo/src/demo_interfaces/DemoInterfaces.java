package demo_interfaces;

interface IAdd {
    int add(int a, int b);
}

interface ISubtract {
    int subtract(int a, int b);
}

interface IMultiply {
    int multiply(int a, int b);
}

class BaseCalculator {
    int add(int a, int b) {
        return a + b;
    }
}

class DemoCalculator
        extends BaseCalculator
        implements IAdd, ISubtract, IMultiply {

    @Override
    public int add(int a, int b) {
        return super.add(a, b);
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DemoInterfaces {
    static <T extends IAdd> void callAdd(T cal) {
        cal.add(1, 2);
    }

    static <T extends IAdd & ISubtract> void callAddAndSubtract(T cal) {
        cal.add(1, 2);
        cal.subtract(1, 2);
    }

    public static void main(String[] args) {
        DemoCalculator demoCalculator = new DemoCalculator();
        demoCalculator.add(1, 2);
        demoCalculator.multiply(1, 2);
        demoCalculator.subtract(1, 2);

        callAdd(demoCalculator);
        callAddAndSubtract(demoCalculator);
    }
}
