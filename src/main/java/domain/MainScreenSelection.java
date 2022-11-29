package domain;

import constant.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainScreenSelection {
    ONE(1, "주문등록"),
    TWO(2, "결제하기"),
    THREE(3, "프로그램 종료");

    private final int selection;
    private final String korean;

    MainScreenSelection(int selection, String korean) {
        this.selection = selection;
        this.korean = korean;
    }

    public static void validateInput(int input) {
        Arrays.stream(MainScreenSelection.values())
                .filter(mainScreenSelection -> mainScreenSelection.selection == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_TABLE));
    }

    public static List<MainScreenSelection> findAllMainScreenSelection() {
        return Arrays.stream(MainScreenSelection.values())
                .collect(Collectors.toList());
    }

    public int getSelection() {
        return selection;
    }

    public String getKorean() {
        return korean;
    }
}
