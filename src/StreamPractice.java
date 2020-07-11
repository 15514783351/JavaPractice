/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/11 9:47   戴宗明       1.0         None
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流的联系
 */
public class StreamPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        Stream<String> stringStream = list.stream().
                filter((name) -> {
                    return name.length() <= 6;
                });
        stringStream.forEach(name -> System.out.println(name));

        System.out.println(list);

    }
}
