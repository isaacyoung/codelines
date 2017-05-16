import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 项目名称：代码统计
 * 类描述：统计 java
 * 创建人：yzh
 * 创建时间：2017/5/16
 * 备注：
 */
public class StatJava {
    /**
     * 统计入口
     * @param f
     * @return
     */
    static Result stat(File f) {
        Result result = new Result();
        loop(f,result);
        return result;
    }

    /**
     * 循环遍历
     * @param f
     * @param result
     */
    static void loop(File f,Result result) {
        try {
            File[] childs = f.listFiles();
            for (int i = 0; i < childs.length; i++) {
                File file = childs[i];
                if (!file.isDirectory()) {
                    if (file.getName().toLowerCase().endsWith(".java")) {
                        result.setClasscount(result.getClasscount() + 1);
                        BufferedReader br = null;
                        boolean comment = false;
                        br = new BufferedReader(new FileReader(file));
                        String line = "";

                        while ((line = br.readLine()) != null) {
                            line = line.trim();

                            if (line.startsWith("/*") && line.endsWith("*/")) {
                                result.setCommentLines(result.getCommentLines() + 1);
                            } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                                result.setCommentLines(result.getCommentLines() + 1);
                                comment = true;
                            } else if (comment) {
                                result.setCommentLines(result.getCommentLines() + 1);
                                if (line.endsWith("*/")) {
                                    comment = false;
                                }
                            } else if (line.startsWith("//")) {
                                result.setCommentLines(result.getCommentLines() + 1);
                            } else if ("".equals(line)) {
                                result.setBlankLines(result.getBlankLines() + 1);
                            } else {
                                result.setCodeLines(result.getCodeLines() + 1);
                            }
                        }
                        if (br != null) {
                            br.close();
                            br = null;
                        }
                    }
                } else {
                    loop(childs[i], result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
