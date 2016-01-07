package com.pinganfu.express.service;

import com.pinganfu.express.beans.ClassMethod;
import com.pinganfu.express.beans.ServiceMethod;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;

import java.util.List;
import java.util.Map;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public interface ExpressExecuor {
    void init() throws Exception;
    public void addOperator(String name,Operator op) throws Exception;


    public void addOperatorWithAlias(String keyWordName, String realKeyWordName) throws Exception;


    public void addFunctionOfClassMethod(String name, String aClassName,
                                         String aFunctionName, Class<?>[] aParameterClassTypes,
                                         String errorInfo) throws Exception;

    public void addFunctionOfServiceMethod(String name, Object aServiceObject,
                                           String aFunctionName, Class<?>[] aParameterClassTypes,
                                           String errorInfo) throws Exception;
    public Object execute(String expressString, IExpressContext<String,Object> context,
                          List<String> errorList, boolean isCache, boolean isTrace) throws Exception;




//    public void addOperator(String name,String aRefOpername,Operator op) throws Exception;

    /**
     *
     * 添加一个类的函数定义，例如：Math.abs(double) 映射为表达式中的 "取绝对值(-5.0)"
     * @param name 函数名称
     * @param aClassName 类名称
     * @param aFunctionName 类中的方法名称
     * @param aParameterClassTypes 方法的参数类型名称
     * @param errorInfo 如果函数执行的结果是false，需要输出的错误信息
     * @throws Exception
     */


    /**
     * 用于将一个用户自己定义的对象(例如Spring对象)方法转换为一个表达式计算的函数
     * @param name
     * @param aServiceObject
     * @param aFunctionName
     * @param aParameterClassTypes
     * @param errorInfo
     * @throws Exception
     */


    /**
     * 添加操作符和关键字的别名，同时对操作符可以指定错误信息。
     * 例如：addOperatorWithAlias("加","+",null)
     * @param keyWordName
     * @param realKeyWordName
     * @param errorInfo
     * @throws Exception
     */



    /**
     * 执行一段文本
     * @param expressString 程序文本
     * @param context 执行上下文
     * @param errorList 输出的错误信息List
     * @param isCache 是否使用Cache中的指令集
     * @param isTrace 是否输出详细的执行指令信息
     * @return
     * @throws Exception
     */










}
