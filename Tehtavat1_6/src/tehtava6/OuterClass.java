package tehtava6;
public class OuterClass {
    private String outerField = "Outer Field";

    public class InnerClass {
        private String innerField = "Inner Field";

        public void display() {
            System.out.println("Outer Field: " + outerField);
            System.out.println("Inner Field: " + innerField);
        }
    }

    public void useInnerClass() {
        InnerClass inner = new InnerClass();
        inner.display();
    }

    public static void main(String[] args) {

        OuterClass outer = new OuterClass();
        outer.useInnerClass();

        AnonymousClassExample anonymousExample = new AnonymousClassExample();
        anonymousExample.createAnonymousClass();
    }
}

// AnonymousClassExample.java
class AnonymousClassExample {
    interface Greeting {
        void greet();
    }

    public void createAnonymousClass() {
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello from the anonymous inner class!");
            }
        };
        greeting.greet();
    }
}
