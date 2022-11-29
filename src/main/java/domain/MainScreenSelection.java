package domain;

import constant.ErrorMessage;
import controller.OrderController;
import controller.PaymentController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainScreenSelection {
    ONE(1, "주문등록", OrderController::run),
    TWO(2, "결제하기", PaymentController::run),
    THREE(3, "프로그램 종료", () -> {
    });
    private final int selection;
    private final String korean;
    private final Runnable nextAction;

    MainScreenSelection(int selection, String korean, Runnable nextAction) {
        this.selection = selection;
        this.korean = korean;
        this.nextAction = nextAction;
    }

    public static List<MainScreenSelection> findAllMainScreenSelection() {
        return Arrays.stream(MainScreenSelection.values())
                .collect(Collectors.toList());
    }

    public static MainScreenSelection findClassBySelection(int input) {
        return Arrays.stream(MainScreenSelection.values())
                .filter(mainScreenSelection -> mainScreenSelection.selection == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION));
    }

    public void doNextAction() {
        nextAction.run();
    }

    public int getSelection() {
        return selection;
    }

    public String getKorean() {
        return korean;
    }
}
