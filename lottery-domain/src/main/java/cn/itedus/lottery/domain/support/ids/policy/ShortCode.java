package cn.itedus.lottery.domain.support.ids.policy;

import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2022/3/14
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public Long nextId() {
        return null;
    }
}
