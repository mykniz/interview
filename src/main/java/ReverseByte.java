public class ReverseByte {
    public static void main(String[] args) {
        int X = 0xa912cbd4;
        System.out.printf("0x%08X%n", X);


        int Y = ((X >>> 24) | (((X>>16)<<24)>>16) | (((X<<16)>>>24)<<16) | (X<<24));
        int Y1 = (X >>> 24);
        int Y2 = (((X>>16)<<24)>>16);
        int Y3 = (((X<<16)>>>24)<<16);
        int Y4 =  (X<<24);

        System.out.printf("Y = 0x%08X%n", Y);

        System.out.printf("Y1 = 0x%08X%n", Y1);
        System.out.printf("Y2 = 0x%08X%n", Y2);
        System.out.printf("Y3 = 0x%08X%n", Y3);
        System.out.printf("Y4 = 0x%08X%n", Y4);
    }
}
