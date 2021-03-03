public class StackOverflowError {
    public static void main(String[] args) {

        //   new StackOverflowError().generateStackOverflowError();
        new StackOverflowError().generateOutOfMemoryError();


    }

    void generateStackOverflowError() {

        generateStackOverflowError();

    }

    void generateOutOfMemoryError() {
        //enter your code
        final int SIZE=1024*1024*1024;
        int[] arr = new int[SIZE];

    }


}




