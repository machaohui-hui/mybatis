package com.powernode.junit.service;

import org.junit.Assert;
import org.junit.Test;

public class MathServiceTest {

    @Test
    public void testSum(){
        //单元测试中，有两个重要的概念，一个是实际值，一个是期望值
        MathService mathService = new MathService();
        int actual = mathService.sum(1, 2);
        int expected = 3;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSub(){

    }

}
