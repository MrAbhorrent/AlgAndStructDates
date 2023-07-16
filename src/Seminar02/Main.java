package src.Seminar02;

public class Main {

    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    private static int RIGHT(int i) {
        return (2 * i + 2);
    }


    private static void swap(int[] sortArr, int i, int j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }

    private static void heapify(int[] sortArr, int i, int size) {

        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;
        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;
        if (largest != i) {
            swap(sortArr, i, largest);
            heapify(sortArr, largest, size);
        }
    }

    public static int pop(int[] sortArr, int size) {

        if (size <= 0) {
            return -1;
        }
        int top = sortArr[0];
        sortArr[0] = sortArr[size-1];
        heapify(sortArr, 0, size - 1);
        return top;
    }

    //функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapSort(int[] sortArr) {

        int n = sortArr.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortArr, i--, n);
        }
        while (n > 0) {
            sortArr[n - 1] = pop(sortArr, n);
            n--;
        }
    }

    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        System.out.println("Оригинальный массив");
        PrintArray(sortArr);
        heapSort(sortArr);
        System.out.println("После сортировки");
        PrintArray(sortArr);
    }

    public static void PrintArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
        System.out.println();
    }
}
