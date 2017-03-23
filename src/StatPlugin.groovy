import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

/**
 * 项目名称：代码统计
 * 类描述：
 * 创建人：yzh
 * 创建时间：2017/3/23
 * 备注：
 */
class StatPlugin extends AnAction {

    @Override
    void actionPerformed(AnActionEvent e) {
        Project p =  e.getProject()
        System.out.println(p.getBasePath())
    }
}
