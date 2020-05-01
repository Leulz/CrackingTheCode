public class StackProblems {

    public static void main(String[] args) {
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

//        System.out.println(ats.pop(0));
//        System.out.println(ats.pop(1));
//        System.out.println(ats.pop(2));
    }
}
