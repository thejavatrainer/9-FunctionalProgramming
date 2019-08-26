package functional.lambdas;

public class Numbers {
    public static void main(String[] args) {
        Number n = () -> 123;

        new Number() {
            @Override
            public int getNumber() {
                return 123;
            }
        }.getNumber();

        int x = n.getNumber();
        int y = getNumber();
    }

    static int getNumber() {
        return 123;
    }
}

interface Number {
    int getNumber();
}
