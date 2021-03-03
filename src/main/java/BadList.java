import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BadList {

    public static void main(String[] args) {

        new BadList().generateBadList();

    }



    List<Integer> generateBadList() {
        // enter your code
        ArrayList<Integer> arrayList = new ArrayList(20);
        arrayList.ensureCapacity(10);


        int i = 0;
        int sum = 0;
        while (i < 20) {
            sum += arrayList.get(i);
            i++;
        }


        System.out.println(sum);

        return null;
    }

}
