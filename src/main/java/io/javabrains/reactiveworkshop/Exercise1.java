package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Example 1");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Example 2");
        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Example 3");
        StreamSources.intNumbersStream().filter(number -> number < 5).skip(1).limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Example 4");
        System.out.println(StreamSources.intNumbersStream().filter(number -> number < 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        System.out.println("Example 5");
        StreamSources.userStream().map(name -> name.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Example 6");
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(integer -> user.getId() == integer))
                .map(user -> user.getFirstName()).forEach(System.out::println);
        System.out.println("Example 6");
        StreamSources.intNumbersStream().flatMap(integer -> StreamSources.userStream().filter(user -> integer.equals(user.getId()))).map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

}
