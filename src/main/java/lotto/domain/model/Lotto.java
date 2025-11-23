package lotto.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto() {
        this(generateLottoNumber());
    }
    
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
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
    
    public int findMatchNumbers(List<Integer> winNumbers) {
        int matchCount = 0;
        for(Integer number: this.numbers) {
            if(winNumbers.contains(number)) {
                matchCount ++;
            }
        }
        return matchCount;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
