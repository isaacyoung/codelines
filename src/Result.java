/**
 * 项目名称：代码统计
 * 类描述：统计结果
 * 创建人：yzh
 * 创建时间：2017/5/16
 * 备注：
 */
public class Result {
    private long classcount = 0; // 类数
    private long blankLines = 0; // 空行
    private long commentLines = 0; // 注释行
    private long codeLines = 0; // 代码行

    public long getClasscount() {
        return classcount;
    }

    public void setClasscount(long classcount) {
        this.classcount = classcount;
    }

    public long getBlankLines() {
        return blankLines;
    }

    public void setBlankLines(long blankLines) {
        this.blankLines = blankLines;
    }

    public long getCommentLines() {
        return commentLines;
    }

    public void setCommentLines(long commentLines) {
        this.commentLines = commentLines;
    }

    public long getCodeLines() {
        return codeLines;
    }

    public void setCodeLines(long codeLines) {
        this.codeLines = codeLines;
    }

    public String toString() {
        return "class:" + classcount + "\n" +
                "blankLines:" + blankLines + "\n" +
                "commentLines:" + commentLines + "\n" +
                "codeLines:" + codeLines + "\n";
    }
}
