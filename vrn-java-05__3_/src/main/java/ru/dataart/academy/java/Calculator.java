package ru.dataart.academy.java;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Calculator {
    /**
     * @param firstNumber  - list for first number in reversed order (1 - 2 - 3 -> 321)
     * @param secondNumber - list for second number in reversed order (1 - 2 - 3 -> 321)
     * @return - sum of firstNumber + secondNumber
     */
    public Integer getSum(List<Integer> firstNumber, List<Integer> secondNumber) {
        //Task implementation
        int rank = 1;
        int result = 0;
        int first = 0 , second = 0, next = 0, sum = 0;
        int curr = 0;
        if (firstNumber.size() > secondNumber.size()) {
            for (int i = 0; i < secondNumber.size(); i++){
                first = firstNumber.get(i);
                second = secondNumber.get(i);
                sum = first + second + next;
                curr = sum % 10;
                if (sum > 9) {
                    next = 1;
                }
                else
                    next = 0;
                result += rank*curr;
                rank *= 10;
            }
            for (int i = secondNumber.size(); i < firstNumber.size(); i++){
                if (next == 1) {
                    curr = (firstNumber.get(i) + next);
                    if (curr > 9){
                        next = 1;
                        curr %= 10;
                    }
                    else
                        next = 0;
                }
                else
                    curr  = firstNumber.get(i);
                result += rank*curr;
                rank *= 10;
            }
        }
        else if (firstNumber.size() < secondNumber.size()) {
            for (int i = 0; i < firstNumber.size(); i++){
                first = firstNumber.get(i);
                second = secondNumber.get(i);
                sum = first + second + next;
                curr = sum % 10;
                if (sum > 9) {
                    next = 1;
                }
                else
                    next = 0;
                result += rank*curr;
                rank *= 10;
            }
            for (int i = firstNumber.size(); i < secondNumber.size(); i++){

                if (next == 1) {
                    curr = (secondNumber.get(i) + next);
                    System.out.println(curr);
                    if (curr > 9){
                        next = 1;
                        curr %= 10;
                    }
                    else
                        next = 0;
                }
                else
                    curr  = secondNumber.get(i);
                result += rank*curr;
                rank *= 10;
            }
        }
        else{
            for (int i = 0; i < secondNumber.size(); i++){
                first = firstNumber.get(i);
                second = secondNumber.get(i);
                sum = first + second + next;
                curr = sum % 10;
                if (sum > 9) {
                    next = 1;
                }
                else
                    next = 0;
                result += rank*curr;
                rank *= 10;
            }
            if (next == 1){
                result += next*rank;
            }
        }
        return result;
    }

    /**
     *
     * @param list - list of elements
     * @param <T> - type of element
     * @return - odd list elements
     * Example: [1, 22, 34] -> [1, 34]
     */
    public <T> List<T> getOddElements(List<T> list) {
        // Task implementation\
        int i = 0;
        LinkedList<T> resultList = new LinkedList<>();
        for (T el: list) {
            if (i % 2 == 0) {
                resultList.add(el);
            }
            i++;
        }
        if (list.equals(Collections.emptyList()))
            return Collections.emptyList();
        else
            return resultList;
    }

    /**
     *
     * @param list - list of elements
     * @param <T> - type of element
     * @return - first and last elements of the list
     * Example: [1, 2, 3] -> [1, 3]
     * [1, 2, 3 , 4] -> [1, 4]
     */
    public <T> List<T> getBounds(List<T> list) {
        // Task implementation
        LinkedList<T> resultList = new LinkedList<>();
        if (list.size() == 0)
            return Collections.emptyList();
        else {
            resultList.addFirst(list.get(0));
            if (list.size() > 1)
                resultList.addLast(list.get(list.size() - 1));
            return resultList;
        }
    }
}
