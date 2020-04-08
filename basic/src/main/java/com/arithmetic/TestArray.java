package com.arithmetic;

import java.io.*;
import java.nio.file.Path;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/27 13:18
 * @since 2.0.7
 **/
public class TestArray {
  public static void main(String[] args) throws IOException {
      File file=new File("D:\\testArray\\tet.txt");

      try(BufferedReader reader = new BufferedReader(new FileReader(file))){
          reader.read();
      }
  }
}
