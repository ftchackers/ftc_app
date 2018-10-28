public class test1 {

    public static void main (String[] args) {
        boolean stoprun = false;
        int temp = 1;

        while (!stoprun) {
            if (temp%13==0 && (temp-1)%17 == 0) {
                System.out.println(temp);
                stoprun = true;
            }
            else {
                temp++;

            }
        }

    }
}
