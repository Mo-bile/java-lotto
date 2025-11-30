package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public record Lotto(List<LottoNumber> numbers) {
    
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 46;
    
    public Lotto() {
        this(generateLottoNumberByPay());
    }
    
    public Lotto(String lottoNumbers) {
        this(generateLottoNumberByInput(lottoNumbers));
    }
    
    public Lotto(int... ints) {
        this(getIntegers(ints));
    }
    
    public Lotto {
        lottoSizeValidate(numbers);
        validateUniqueNumbers(numbers);
    }
    
    private void lottoSizeValidate(List<LottoNumber> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리여야한다");
        }
    }
    
    private void validateUniqueNumbers(List<LottoNumber> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("로또번호는 서로 달라야한다");
        }
    }
    
    private static List<LottoNumber> getIntegers(int[] ints) {
        return convertToLottoNumbers(Arrays.stream(ints).boxed().toList());
    }
    
    private static List<LottoNumber> generateLottoNumberByInput(String lottoNumbers) {
        return Arrays.stream(extractWinnerLottoNumber(lottoNumbers))
            .map(LottoNumberCache::getLottoNumber)
            .toList();
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
    
    private static List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .forEach(numberList::add);
        Collections.shuffle(numberList);
        return numberList;
    }
    
    private static List<LottoNumber> convertToLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumberCache::getLottoNumber)
            .toList();
    }
    
    public List<Integer> numberValues() {
        return this.numbers.stream()
            .map(LottoNumber::value)
            .toList();
    }
    
    public int findMatchCount(Lotto winNumbers) {
        return (int) this.numbers.stream()
            .filter(winNumbers::isContain)
            .count();
    }
    
    public boolean isContain(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }
    
}
