package maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> productsMap = new HashMap<>();
        productsMap.put(1000, "notebook");
        productsMap.put(2000, "phone");
        productsMap.put(3000, "keyboard");
        System.out.println(productsMap);
        productsMap.put(1000, "mouse");
        System.out.println(productsMap);


        System.out.println(productsMap.get(2000));
        productsMap.remove(1000);
        System.out.println(productsMap);

        productsMap.putIfAbsent(3000, "mouse");
        System.out.println(productsMap.get(3000));

        //System.out.println(productsMap.keySet());
        for (Integer code : productsMap.keySet()) {
            System.out.println(productsMap.get(code));
        }


        for (String productName : productsMap.values()) {
            System.out.println(productName);
        }


        for(Map.Entry<Integer,String> entry : productsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Set<String>> synonyms = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        set1.add("mirobolant");
        set1.add("extraordinar");
        synonyms.put("frumos", set1);

        Set<String> set2 = new HashSet<>();
        set2.add("perspicace");
        set2.add("iute");
        synonyms.put("rapid", set2);

        Set<String> set3 = new HashSet<>();
        set3.add("facil");
        set3.add("lejer");
        synonyms.put("simplu", set3);

        System.out.println(synonyms);


        String newString= "a";
        String newKey = "k";
        if(!synonyms.containsKey(newKey)) {
            Set<String> value = new HashSet<>();
            value.add(newString);
            synonyms.put(newKey, value);
        }else {
            synonyms.get(newKey).add(newString);
        }

        System.out.println(synonyms);

    }
}
