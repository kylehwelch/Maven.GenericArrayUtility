package com.zipcodewilmington.arrayutility;



public class ArrayUtility<T> {
    private T[] inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T value){
        Integer count = 0;
        for (T thing : inputArray) {
            if (thing == value)
                count++;
        }
        return count;
    }

    public T[] removeValue(T remove){
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == remove) {
                inputArray[i] = null;
            }
        }
        int nullLength = notNullCount(inputArray);
        T[] newArray;
        if (remove instanceof Integer) {
            newArray = (T[]) new Integer[nullLength];
        } else if (remove instanceof  Long) {
            newArray = (T[]) new Long[nullLength];
        } else if (remove instanceof String) {
            newArray = (T[]) new String[nullLength];
        }else {
            newArray = (T[]) new Object[nullLength];
        }
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != null) {
                newArray[count] = inputArray[i];
                count++;
            }
        }
        return newArray;
    }

    public Integer countDuplicatesInMerge(T[] array, T value){
        Integer count = 0;
        T[] newArray;
        if (value instanceof Integer) {
            newArray = (T[]) new Integer[inputArray.length + array.length];
        } else if (value instanceof  Long) {
            newArray = (T[]) new Long[inputArray.length + array.length];
        } else if (value instanceof String) {
            newArray = (T[]) new String[inputArray.length + array.length];
        } else {
            newArray = (T[]) new Object[inputArray.length + array.length];
        }
        int mergecount = 0;
        for (int i = 0; i < array.length; i++) {
            newArray[mergecount] = array[i];
            mergecount++;
        }
        for (int i = 0; i < inputArray.length; i++) {
            newArray[mergecount] = inputArray[i];
            mergecount++;
        }
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == value) count++;
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] array){
        T[] newArray;
        if (array[0] instanceof Integer) {
            newArray = (T[]) new Integer[inputArray.length + array.length];
        } else if (array[0] instanceof  Long) {
            newArray = (T[]) new Long[inputArray.length + array.length];
        } else if (array[0] instanceof String) {
            newArray = (T[]) new String[inputArray.length + array.length];
        } else {
            newArray = (T[]) new Object[inputArray.length + array.length];
        }
        int mergecount = 0;
        for (int i = 0; i < array.length; i++) {
            newArray[mergecount] = array[i];
            mergecount++;
        }
        for (int i = 0; i < inputArray.length; i++) {
            newArray[mergecount] = inputArray[i];
            mergecount++;
        }
        int loopcount = 0;
        int highcount = 0;
        T popular = null;

        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (newArray[i] == newArray[j]) {
                    loopcount++;
                    if (loopcount > highcount) {
                        highcount = loopcount;
                        popular = newArray[i];
                    }
                }
            }
        }
        return popular;
    }

    public Integer notNullCount(T[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        return count;
    }
}
