/*▸ Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов
        ▸ Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр
        ▸ Подсчет слов должен выполняться без учета регистра
        ▸ Выводите слова в нижнем регистре
        ▸ Если в тексте меньше 10 уникальных слов, то выводите сколько есть
        ▸ Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке
        ▸ Написать используя stream api*/

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s: new Scanner(System.in, StandardCharsets.UTF_8).nextLine()
                .replaceAll("\\p{Punct}", "")
                .toLowerCase()
                .split(" ")) {
            hashMap.put(s, hashMap.get(s) == null ? 1 : hashMap.get(s) + 1);
        }
        hashMap.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }
}