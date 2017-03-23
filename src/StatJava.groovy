/**
 * 项目名称：代码统计
 * 类描述：统计 java groovy
 * 创建人：yzh
 * 创建时间：2017/3/23
 * 备注：
 */
class StatJava {

    /**
     * 统计入口
     * @param f
     * @return
     */
    static Result stat(File f) {
        def result = new Result()
        loop(f,result)
        result
    }

    /**
     * 循环遍历
     * @param f
     * @param result
     */
    static void loop(File f,Result result) {
        File[] childs = f.listFiles()
        for (int i = 0; i < childs.length ;i++) {
            File file = childs[i]
            if (!file.isDirectory()) {
                if (file.getName().toLowerCase().endsWith(".java")
                        || file.getName().toLowerCase().endsWith(".groovy")) {
                    result.classcount++
                    BufferedReader br = null
                    boolean comment = false
                    br = new BufferedReader(new FileReader(file))
                    String line = ""

                    while ((line = br.readLine()) != null) {
                        line = line.trim()

                        if (line.startsWith("/*") && line.endsWith("*/")) {
                            result.commentLines++
                        } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                            result.commentLines++
                            comment = true
                        } else if (comment) {
                            result.commentLines++
                            if (line.endsWith("*/")) {
                                comment = false
                            }
                        } else if (line.startsWith("//")) {
                            result.commentLines++
                        } else if (line == "") {
                            result.blankLines++
                        } else {
                            result.codeLines++
                        }
                    }
                    if (br != null) {
                        br.close()
                        br = null
                    }
                }
            } else {
                loop(childs[i],result)
            }
        }

        result
    }

}
