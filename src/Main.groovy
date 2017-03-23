/**
 * 项目名称：代码统计
 * 类描述：
 * 创建人：yzh
 * 创建时间：2017/3/23
 * 备注：
 */
class Main {

    static void main(args) {
        def path = 'E:\\code\\dfws-manage\\' // 目录
        File f = new File(path)
        Result result = StatJava.stat(f)
        println("path:" + f.getPath())
        println(result.toString())
    }

}
