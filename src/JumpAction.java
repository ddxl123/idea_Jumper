import com.intellij.ide.actions.OpenFileAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.SelectionModel;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author 10338
 */
public class JumpAction extends AnAction {

    /**
     * 为空则不跳转到行。
     */
    public static LogicalPosition logicalPosition;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (null == editor) {
            return;
        }
        SelectionModel model = editor.getSelectionModel();
        final String selectedText = model.getSelectedText();


        // 必须先执行下面：
        logicalPosition = new LogicalPosition(3, 3);
        // 后执行下面。
        OpenFileAction.openFile(Objects.requireNonNull(Objects.requireNonNull(e.getProject()).getProjectFilePath()), e.getProject());
    }

}

