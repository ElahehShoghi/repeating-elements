package com.algorithm.repeatingelement.controller;

import com.algorithm.repeatingelement.service.RepeatingElementsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repeating-elements")
@AllArgsConstructor
@NoArgsConstructor
public class RepeatingElementsController {

    private RepeatingElementsService repeatingElementsService;

    @GetMapping("/by-two-loop")
    public List<Integer> getRepeatingElementsByTwoLoop(
            @RequestParam(name = "inputArray") int[] inputArray) {
        return repeatingElementsService.getRepeatingElementsByTwoLoop(inputArray);
    }

    @GetMapping("/by-set")
    public List<Integer> getRepeatingElementsBySet(
            @RequestParam(name = "inputArray") int[] inputArray) {
        return repeatingElementsService.getRepeatingElementsBySet(inputArray);
    }

    @GetMapping("/by-hashtable")
    public List<Integer> getRepeatingElementsByHashTable(
            @RequestParam(name = "inputArray") int[] inputArray) {
        return repeatingElementsService.getRepeatingElementsByHashTable(inputArray);
    }
}

