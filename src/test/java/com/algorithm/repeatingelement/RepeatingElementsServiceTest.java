package com.algorithm.repeatingelement;

import com.algorithm.repeatingelement.service.RepeatingElementsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepeatingElementsServiceTest {

    @Autowired
    private RepeatingElementsService repeatingElementsService;

    @Test
    public void testRepeatingElementsByTwoLoop() {
        int[] inputArray = new int[]{1, 1, 3, 0, 2, 3};
        List<Integer> result = repeatingElementsService.getRepeatingElementsByTwoLoop(inputArray);
        assert Objects.equals(result, Arrays.asList(1, 3));
        result.forEach(System.out::println);
    }

    @Test
    public void testRepeatingElementsBySet() {
        int[] inputArray = new int[]{1, 1, 3, 0, 2, 3};
        List<Integer> result = repeatingElementsService.getRepeatingElementsBySet(inputArray);
        assert Objects.equals(result, Arrays.asList(1, 3));
        result.forEach(System.out::println);
    }

    @Test
    public void testRepeatingElementsByHashTable() {
        int[] inputArray = new int[]{1, 1, 3, 0, 2, 3};
        List<Integer> result = repeatingElementsService.getRepeatingElementsByHashTable(inputArray);
        assert Objects.equals(result, Arrays.asList(3, 1));
        result.forEach(System.out::println);
    }

}
