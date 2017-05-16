import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * 项目名称：代码统计
 * 类描述：
 * 创建人：yzh
 * 创建时间：2017/5/16
 * 备注：
 */
public class StatJavaTest {
    @Test
    public void stat() throws Exception {
        String path = "E:\\code\\dfws-manage\\"; // 目录
        File f = new File(path);
        Result result = StatJava.stat(f);
        System.out.println("path:" + f.getPath());
        System.out.println(result.toString());
    }

}