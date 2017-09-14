package com.mark;

import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mark on 2017/9/5.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();

        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        InputStream filepy = new FileInputStream("D:\\\\workspace\\\\spring_boot_demo\\\\src\\\\main\\\\resources\\\\learning.py");
        interpreter.execfile(filepy);  ///执行python py文件
        filepy.close();
//        PythonInterpreter pythonInterpreter=new PythonInterpreter();
//
//        pythonInterpreter.execfile("D:\\workspace\\spring_boot_demo\\src\\main\\resources\\learning.py");
//        PyFunction func = (PyFunction)pythonInterpreter.get("adder",PyFunction.class);
    }
}
