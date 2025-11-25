package lotto.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.domain.Match;

public class Lotto {
    
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 46;
    public static final int INITIAL_MATCH_COUNT = 0;
    private final List<Integer> numbers;
    
    public Lotto() {
        this(generateLottoNumberByPay());
    }
    
    public Lotto(String lottoNumbers) {
        this(generateLottoNumberByInput(lottoNumbers));
    }
    
    public Lotto(int numA, int numB, int numC, int numD, int numE, int numF) {
        this(List.of(numA, numB, numC, numD, numE, numF));
    }
    
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    private static List<Integer> generateLottoNumberByInput(String lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for(String number: extractWinnerLottoNumber(lottoNumbers)) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
    
    private static String[] extractWinnerLottoNumber(String winnerLottoNumber) {
        return winnerLottoNumber.replace(SPACE, EMPTY).split(COMMA);
    }
    
    private static List<Integer> generateLottoNumberByPay() {
        return setUpLottoNumber(generateNumberList());
    }
    
    private static List<Integer> setUpLottoNumber(List<Integer> numberList) {
        List<Integer> lottoNumbers = new ArrayList<>(numberList.subList(0, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    
    private static List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for(int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList;
    }
    
    public List<Integer> getNumbers() {
        return this.numbers;
    }
    
    public Match match(Lotto winNumbers) {
        return Match.fromLottoNumber(findMatchCount(winNumbers.numbers));
    }
    
    public int findMatchCount(List<Integer> winNumbers) {
        int matchCount = INITIAL_MATCH_COUNT;
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
