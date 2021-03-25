import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuggestService {

    List<String> names = new ArrayList<>();

    public SuggestService(List companyNames) {
        names = companyNames;
    }

    public List suggest(String input, Integer numberOfSuggest) {

       return names.stream().filter(s -> s.contains(input)).limit(numberOfSuggest).collect(Collectors.toList());
    }


    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("Nike");
//        names.add("Nikel");
//
//        SuggestService suggestService = new SuggestService(names);
//
//        List<String> subNames = suggestService.suggest("Ni", 10);
//        subNames.forEach(System.out::println);

        String string = "asdfghjkl";
        System.out.println(string.hashCode() & 15);;
        System.out.println(string.substring(2,4));
    }
}
