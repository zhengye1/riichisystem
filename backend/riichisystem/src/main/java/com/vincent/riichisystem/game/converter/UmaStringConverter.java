package com.vincent.riichisystem.game.converter;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
@Slf4j
public class UmaStringConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> uma) {

        if (uma != null) {
            return uma.stream().map(String::valueOf).collect(Collectors.joining(","));
        }
        return "";
    }

    @Override
    public List<Integer> convertToEntityAttribute(String umaString) {
        if (umaString != null){
            return Arrays.stream(umaString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        }else{
            return null;
        }

    }
}
