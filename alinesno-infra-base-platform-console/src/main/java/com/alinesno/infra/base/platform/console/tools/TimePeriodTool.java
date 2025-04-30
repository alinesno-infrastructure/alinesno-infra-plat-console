package com.alinesno.infra.base.platform.console.tools;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

/**
 * 控制台时间工具类
 */
@Slf4j
public class TimePeriodTool {

    /**
     * 时间段
     */
    public enum TimePeriod {
        MORNING("早上", LocalTime.MIDNIGHT, LocalTime.NOON),
        AFTERNOON("中午", LocalTime.NOON, LocalTime.of(18, 0)),
        EVENING("晚上", LocalTime.of(18, 0), LocalTime.MIDNIGHT),
        NIGHT("凌晨", LocalTime.MIDNIGHT, LocalTime.MIDNIGHT);

        @Getter
        private String displayName;
        private LocalTime startTime;
        private LocalTime endTime;

        TimePeriod(String displayName, LocalTime startTime, LocalTime endTime) {
            this.displayName = displayName;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public static TimePeriod getTimePeriod(LocalTime time) {
            for (TimePeriod period : TimePeriod.values()) {
                if (time.isAfter(period.startTime) && time.isBefore(period.endTime)) {
                    return period;
                }
            }
            return null;
        }

    }

    /**
     * 获取到当前段
     * @return
     */
    public static String getTimePeriod() {
        LocalTime currentTime = LocalTime.now();
        TimePeriod timePeriod = TimePeriod.getTimePeriod(currentTime);
        
        if (timePeriod != null) {
            log.debug("当前时间段是：" + timePeriod.getDisplayName());
        } else {
            log.debug("未知时间段");
        }

        assert timePeriod != null;
        return timePeriod.getDisplayName() ;
    }
}
