import stacks.ArrayThreeStacks.ArrayThreeStacks;
import stacks.MinStack.MinStack;
import stacks.SetOfStacks.SetOfStacks;

public class StackProblems {

    private static void ArrayThreeStacksProblem() {
        ArrayThreeStacks ats = new ArrayThreeStacks(100);
        ats.push(0, 10);
        ats.push(0, 11);
        ats.push(0, 12);
        ats.push(2, 5);
        ats.push(0, 15);
        ats.push(2, 6);
        ats.push(1, 99);
        ats.push(1, 33);


        while (true) {
            Integer d = ats.pop(0);
            if (d == null) {
                break;
            }
            System.out.println(d);
        }

        System.out.println("----------------");

        while (true) {
            Integer d = ats.pop(1);
            if (d == null) {
                break;
            }
            System.out.println(d);
        }

        System.out.println("----------------");

        while (true) {
            Integer d = ats.pop(2);
            if (d == null) {
                break;
            }
            System.out.println(d);
        }

        System.out.println(ats.pop(0));
        System.out.println(ats.pop(1));
        System.out.println(ats.pop(2));
    }

    private static void MinStackProblems() {
        MinStack ms = new MinStack();

        ms.push(22);
        ms.push(22);
        ms.push(22);
        ms.push(21);
        ms.push(22);
        ms.push(22);

        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
    }

    private static void SetOfStacksProblem() {
        SetOfStacks sos = new SetOfStacks(3);
        sos.push(10);
        sos.push(11);
        sos.push(12);
        sos.push(13);
        sos.push(14);
        sos.push(15);
        sos.push(16);

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }

    public static void main(String[] args) {
        SetOfStacksProblem();
    }
}
