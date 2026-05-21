package Homework_2;

public class FunWithNumbers {
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static boolean sumToN(int[] a, int n) {
        for (int i = 0; i < a.length - 1; i++) {
            int sum = a[i] + a[i + 1];
            if (sum == n) {
                return true;
            }
        }
        return false;
    }

//    public static void main (String []argv) {
//        int[] inArr = new int[argv.length];
//        if (argv.length == 0) {
//            System.out.println("Usage: java FindLast v1 [v2] [v3] ... ");
//            return;
//        }
//
//        for (int i = 0; i < argv.length; i++) {
//            try {
//                inArr[i] = Integer.parseInt(argv[i]);
//            } catch (NumberFormatException e) {
//                System.out.println("Entry must be a integer. Quitting.");
//                return;
//            }
//        }
//        System.out.println("Enter an integer you want to find, or press Enter to sum the array: ");
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String inStr;
//
//        try {
//            inStr = in.readLine();
//        } catch (IOException e) {
//            System.out.println("Could not read input. Quitting.");
//            return;
//        }
//
//        if (inStr == null || inStr.isBlank()) {
//            int rtnInt = sum(inArr);
//            System.out.printf("Sum of array is: %s\n", rtnInt);
//        } else {
//            int inputInt;
//            try {
//                inputInt = Integer.parseInt(inStr);
//            } catch (NumberFormatException e) {
//                System.out.println("Entry must be a number. Quitting.");
//                return;
//            }
//
//            boolean rtnBool = sumToN(inArr, inputInt);
//            System.out.printf("Two integers that equal %s: %s\n", inputInt, rtnBool);
//        }
//    }
}
