package com.alinesno.infra.plat.console.api.tools;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 操作每日签到的信息和记录
 */
public class CheckinUtils {
    
    // 模拟签到记录的存储，可以根据实际情况使用数据库或其他持久化方式
    private static final Set<LocalDate> checkinRecords = new HashSet<>();
    
    /**
     * 获取签到天数
     */
    public static int getCheckinDays() {
        return checkinRecords.size();
    }
    
    /**
     * 执行签到操作
     */
    public static void checkin() {
        LocalDate today = LocalDate.now();
        if (!checkinRecords.contains(today)) {
            checkinRecords.add(today);
            // 可以在这里记录签到信息到数据库或文件等持久化方式
        } else {
            System.out.println("今天已经签到过了！");
        }
    }
    
    /**
     * 重置签到记录（用于测试或特殊情况）
     */
    public static void resetCheckinRecords() {
        checkinRecords.clear();
    }
}
