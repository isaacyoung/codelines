/**
 * 项目名称：代码统计
 * 类描述：统计结果
 * 创建人：yzh
 * 创建时间：2017/3/23
 * 备注：
 */
class Result {
    long classcount = 0 // 类数
    long blankLines = 0 // 空行
    long commentLines = 0 // 注释行
    long codeLines = 0 // 代码行

    String toString() {
        "class:" + classcount + "\n" +
        "blankLines:" + blankLines + "\n" +
        "commentLines:" + commentLines + "\n" +
        "codeLines:" + codeLines + "\n"
    }
}
