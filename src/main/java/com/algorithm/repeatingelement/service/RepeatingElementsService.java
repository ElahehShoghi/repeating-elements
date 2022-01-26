package com.algorithm.repeatingelement.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RepeatingElementsService {

    /**
     * This method get an array to find repeating elements,
     * To do this goal, first iterate on the input array and then for each of the elements,
     * iterate on others to check if they are equal or not
     * the time complexity is o(n2) and there is no need to extra memory
     *
     * @param inputArray
     * @return
     */
    public List<Integer> getRepeatingElementsByTwoLoop(int[] inputArray) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] == inputArray[j]) {
                    result.add(inputArray[i]);
                }
            }
        }
        return result;
    }

    /**
     * This method get an array to find repeating elements,
     * To do this goal, just use of set data structure as does not allow to add duplicate elements
     * the time complexity is o(n) and extra memory is needed for storing unique elements in HashSet
     * so, the space complexity is o(n)
     *
     * @param inputArray
     * @return
     */
    public List<Integer> getRepeatingElementsBySet(int[] inputArray) {
        Set uniqueElements = new HashSet();
        return Arrays.stream(inputArray).filter(element -> !uniqueElements.add(element))
                .boxed()
                .collect(Collectors.toList());
    }


    /**
     * This method get an array to find repeating elements,
     * To do this goal, use of HashTable data structure to count elements of inputArray
     * put every unique element as a key and its count as a value in HashTable
     * the time complexity is o(n2), first iteration for putting elements in HashTAble and second for finding repeating elements
     * extra memory is needed for storing elements in HashTable
     * so, the space complexity is o(n)
     *
     * @param inputArray
     * @return
     */
    public List<Integer> getRepeatingElementsByHashTable(int[] inputArray) {
        Map<Integer, Integer> inputWithCount = new Hashtable();
        for (int i : inputArray) {
            Integer count = inputWithCount.get(i);
            if (count == null) {
                inputWithCount.put(i, 1);
            } else {
                inputWithCount.put(i, ++count);
            }
        }
        return inputWithCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
