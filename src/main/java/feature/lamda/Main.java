package feature.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * just refer the doc of lamda
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/11/22
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<List<String>> lists = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("1");
        strings1.add("2");
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("3");
        strings2.add("4");
        lists.add(strings1);
        lists.add(strings2);

        List<String> collect = lists.stream().flatMap(s -> {
            System.out.println(s);
            return s.stream();
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

}
