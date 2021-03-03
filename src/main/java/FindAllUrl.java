import java.util.Arrays;

public class FindAllUrl {
    public static void main(String[] args) {


        String input1 = "rhrthr https://stepik.org edtrhert r113223@12 https://wererwg.ru erwg3rg@123009https\n" +
                "rhrthr http://sfrgeee.org/ewfef/wqewrg\n" +
                "5476y65yyyyyh$%&$\n" +
                "https://makedreamprofits.ru/?utm_source=ewqee&utm_medium=qew";

        String input2 = "kpb jwjd frv http://www.jqwmvnhu.gagzkxksp.ru/tmyp/?param0=ugtehajgg ior bsavmi\n" +
                "elsdedejy blfesitfag udhyluxkj http://www.zhbh.kdokw.yapv.ru/xoihdn/ubs/?param0=pblsq&param1=wwqzb tmzwwo dmvlbwyvqv http://www.mppsuderi.rqt.com/ermuske/mldbhgy/?param0=bex hvcsgbl jrhbx gjtesiyyej pvj skphrki http://www.eccqkeoj.uttajvapi.hxnadj.com/?param0=hoi&param1=ssdd yykjd lob zlrsrzi xmmjbvle\n" +
                "cpuymoqua http://www.zpy.witzxygk.ru hszud gzyvvhxqam crv zsy cuwjsruq https://www.ocdmnsdocx.xzsom.com nfwzfxllbe feesuhjemh zhhaigtoi https://www.osjum.sfzxcqblax.oqehtucjvd.com/?param0=sfcbfp&param1=sjnb";

        new FindAllUrl().findAllUrl(input2);

    }

    private void findAllUrl(String text) {

        String reg = "^(http|https):\\/\\/(w*).([a-z\\.]*)?(\\/[a-z1-9\\/]*)*\\??([\\&\\_a-z0-9=]*)?";

        String[] textSplit = text.split("\\s");

        for (String s : textSplit) {
            if (s.matches(reg)) {
                System.out.println(s);
            }

        }
    }
}
