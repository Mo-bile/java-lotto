package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Rank;

public record Lotto(List<LottoNumber> numbers) {
    
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 46;
    public static final int INITIAL_MATCH_COUNT = 0;
    
    public Lotto() {
        this(generateLottoNumberByPay());
    }
    
    public Lotto(String lottoNumbers) {
        this(generateLottoNumberByInput(lottoNumbers));
    }
    
    public Lotto(int... ints) {
        this(getIntegers(ints));
    }
    
    private static List<LottoNumber> getIntegers(int[] ints) {
        return convertToLottoNumbers(Arrays.stream(ints).boxed().toList());
    }
    
    private static List<LottoNumber> generateLottoNumberByInput(String lottoNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for(String number: extractWinnerLottoNumber(lottoNumbers)) {
            numbers.add(new LottoNumber(number));
        }
        return numbers;
    }
    
    private static String[] extractWinnerLottoNumber(String winnerLottoNumber) {
        return winnerLottoNumber.replace(SPACE, EMPTY).split(COMMA);
    }
    
    private static List<LottoNumber> generateLottoNumberByPay() {
        return setUpLottoNumber(generateNumberList());
    }
    
    private static List<LottoNumber> setUpLottoNumber(List<Integer> numberList) {
        List<Integer> lottoNumbers = new ArrayList<>(numberList.subList(0, 6));
        Collections.sort(lottoNumbers);
        return convertToLottoNumbers(lottoNumbers);
    }
    
    private static List<LottoNumber> convertToLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::new)
            .toList();
    }
    
    private static List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for(int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList;
    }
    
    public List<Integer> numberValues() {
        return this.numbers.stream()
            .map(LottoNumber::value)
            .toList();
    }
    
    public int findMatchCount(Lotto winNumbers) {
        int matchCount = INITIAL_MATCH_COUNT;
        for(LottoNumber number: this.numbers) {
            if(winNumbers.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    
    public boolean isContain(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }
    
}
