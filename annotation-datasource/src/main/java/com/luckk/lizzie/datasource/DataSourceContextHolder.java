package com.luckk.lizzie.datasource;

public class DataSourceContextHolder {

    private static ThreadLocal<String> dataSourceContextHolder = new ThreadLocal<>();

    public static String getDataSourceContextHolder() {
        return dataSourceContextHolder.get();
    }

    public static void setDataSourceContextHolder(String dataSourceName) {
        dataSourceContextHolder.set(dataSourceName);
    }

    public static void clearKey(){
        dataSourceContextHolder.remove();
    }

}
