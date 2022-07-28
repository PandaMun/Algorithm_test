import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class multiple{
    public static void main(String[] args){
        IntStream number = IntStream.of(11, 22, 33, 44);

        System.out.println(number.anyMatch(i ->  i < 10));
    }
}