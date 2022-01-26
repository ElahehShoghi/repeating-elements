package com.algorithm.repeatingelement.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, inputArray.length)
                .flatMap(i -> IntStream.range(i + 1, inputArray.length)
                        .filter(j -> inputArray[i] == inputArray[j])
                        .map(j -> inputArray[j]))
                .boxed()
                .collect(Collectors.toList());
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
        Arrays.stream(inputArray)
                .forEach(i ->
                        {
                            Integer count = inputWithCount.get(i);
                            inputWithCount.put(i, count == null ? 1 : ++count);
                        }
                );
        return inputWithCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
