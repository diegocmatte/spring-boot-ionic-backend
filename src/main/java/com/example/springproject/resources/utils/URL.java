package com.example.springproject.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    public static List<Integer> decodeIntList(String s){

        /*
        String[] vetor = s.split(",");
        List<Integer> list = new ArrayList<>();

        for (String value : vetor) {
            list.add(Integer.parseInt(value));
        }
        return list;
         */

        return Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public static String decodeParam(String s){
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }
}
