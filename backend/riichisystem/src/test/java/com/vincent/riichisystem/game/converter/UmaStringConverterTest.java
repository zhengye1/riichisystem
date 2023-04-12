package com.vincent.riichisystem.game.converter;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UmaStringConverterTest {

    UmaStringConverter umaStringConverter;

    @BeforeEach
    public void init() {
        umaStringConverter = new UmaStringConverter();
    }

    @Test
    void convertToDatabaseColumn() {
        List<Integer> umas = Arrays.asList(30, 10, -10, -30);
        String result = umaStringConverter.convertToDatabaseColumn(umas);
        Assertions.assertEquals("30,10,-10,-30", result);
    }

    @Test
    void convertToEntityAttribute() {
        String umaString = "15,5,-5,-15";
        List<Integer> umas = umaStringConverter.convertToEntityAttribute(umaString);
        Assertions.assertIterableEquals(Arrays.asList(15, 5 , -5, -15), umas);
    }
}