package service;

import java.util.List;

public class DataValidator {

    public static void validateNullOrEmpty(List<?> tables) {
        if (tables == null) {
            throw new NullPointerException("null인 정보를 조회할 수 없습니다.");
        }
        if (tables.isEmpty()) {
            throw new NullPointerException("등록된 정보가 없습니다.");
        }
    }
}
