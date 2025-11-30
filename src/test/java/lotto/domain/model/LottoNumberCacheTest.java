package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberCacheTest {
    
    @Test
    void lottoNumber를_입력하면_필요한_LottoNumber객체를_반환한다() {
        assertThat(LottoNumberCache.getLottoNumber(5))
            .isEqualTo(new LottoNumber(5));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호가_범위_밖이면_에러(int num) {
        assertThatThrownBy(() ->
            LottoNumberCache.getLottoNumber(num)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1~45사이 입력하시오");
    }
}