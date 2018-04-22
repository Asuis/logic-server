package com.real.logicserver.utils.tools;

import java.util.Date;

/**
 * @author asuis
 */
public class TimeUtils {
    public static Date getCurrentTIme() {
        return new Date(System.currentTimeMillis());
    }
}
