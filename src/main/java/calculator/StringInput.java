package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringInput {
    
    String input;
    
    public StringInput(String input) {
        validate(input);
        symbolValidate(input);
        this.input = input;
    }
    
    public List<String> extractArithmeticQueue() {
        return new ArrayList<>(Arrays.asList(this.input.split(" ")));
    }
    
    private void validate(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자");
        }
    }
    
    private void symbolValidate(String input) {
        if(input.matches("[0-9+\\-*/\\s]+")) {
            return;
        }
        throw new IllegalArgumentException("숫자, 공백, 사칙연산만 포함해야 합니다.");
    }
    
}
