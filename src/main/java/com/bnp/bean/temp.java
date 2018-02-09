package com.bnp.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTest {

    public String reverseString(String input) {
        if (StringUtils.isNotBlank(input)) {
            char[] inputCharArr = input.toCharArray();
            for (int startIdx = 0, endIdx = input.length() - 1; startIdx < input.length() / 2; startIdx++, endIdx--) {
                char temp = inputCharArr[startIdx];
                inputCharArr[startIdx] = inputCharArr[endIdx];
                inputCharArr[endIdx] = temp;
            }
            return String.valueOf(inputCharArr);
        } else {
            return input;
        }
    }

    @Test
    public void shouldReturnNullWhenReverseStringNull() throws Exception {
        // Given
        StringTest test = new StringTest();

        // When
        String result = test.reverseString(null);

        // Then
        assertEquals(null, result);
    }

    @Test
    public void shouldReverseString() throws Exception {
        // Given
        StringTest test = new StringTest();

        // When
        String result = test.reverseString("abcdef");

        // Then
        assertEquals("fedcba", result);
    }
}
