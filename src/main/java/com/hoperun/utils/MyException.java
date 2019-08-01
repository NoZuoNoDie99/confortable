package com.hoperun.utils;

/**
 * @descriptiom:自定义异常类
 * @Author: 武政旭
 * @Date: 2019/7/31 16:02
 */
public class MyException extends Exception{

    public MyException() { }

    public MyException(String message) {
        super(message);
    }
}
