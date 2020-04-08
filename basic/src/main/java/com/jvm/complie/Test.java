package com.jvm.complie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/1 15:42
 * @since 2.0.7
 */
public class Test {
  public static void main(String[] args) {
    List<String> arr = new ArrayList<>(3);
    arr.add("1");
    arr.add("2");
    arr.add("3");
    arr.add("4");
    Optional<AccountConfig> optAc = Optional.of(new AccountConfig());
    if (!optAc.map(AccountConfig::getBillAutoRecognize).orElse(false)) {
      System.out.println(1211);
    }
  }

  public static void foo(Object obj) {

    int sum = 0;
    //        for (int i = 0; i < 200; i++) {
    //            sum += i;
    //        }
    if (sum == 0) {
      System.out.println("12");
    } else {
      System.out.println("11");
    }
  }
}
