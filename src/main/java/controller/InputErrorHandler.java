package controller;

import view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class InputErrorHandler {

    public static <T, R> R runUntilGetLegalArguments(Function<T, R> function, T parameter) {
        while (true) {
            try {
                return function.apply(parameter);
            } catch (IllegalArgumentException exception) {
                OutputView.printUserErrorMessage(exception.getMessage());
            }
        }
    }

    public static <T> T runUntilGetLegalArguments(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                OutputView.printUserErrorMessage(exception.getMessage());
            }
        }
    }
}
