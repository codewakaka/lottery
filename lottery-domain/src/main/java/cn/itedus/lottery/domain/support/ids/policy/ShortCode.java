package cn.itedus.lottery.domain.support.ids.policy;

import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @description
 * @date 2022/3/14
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public Long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        //打乱排序
        StringBuilder idStr = new StringBuilder();
        idStr.append(year - 2020);
        idStr.append(hour);
        idStr.append(String.format("%2d",week));
        idStr.append(day);
        idStr.append(String.format("%03d",new Random().nextInt(1000)));
        return Long.parseLong(idStr.toString());
    }
}
