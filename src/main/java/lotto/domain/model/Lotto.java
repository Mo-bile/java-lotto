package lotto.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto() {
        this.numbers = generateLottoNumber();
    }
    
    private static List<Integer> generateLottoNumber() {
        return setUpLottoNumber(generateNumberList());
    }
    
    private static List<Integer> setUpLottoNumber(List<Integer> numberList) {
        List<Integer> lottoNumbers = numberList.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    
    private static List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 1; i < 46; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList;
    }
    
    public List<Integer> getNumbers() {
        return this.numbers;
    }
    
}
