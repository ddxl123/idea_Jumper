import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.fileEditor.TextEditor;
import org.jetbrains.annotations.NotNull;

/**
 * @author 10338
 */
public class Listener implements FileEditorManagerListener {
    @Override
    public void selectionChanged(@NotNull FileEditorManagerEvent event) {
        FileEditorManagerListener.super.selectionChanged(event);
        LogicalPosition logicalPosition = JumpAction.logicalPosition;
        if (logicalPosition != null) {
            Editor editor = ((TextEditor) event.getNewEditor()).getEditor();
            editor.getCaretModel().moveToLogicalPosition(logicalPosition);
            editor.getScrollingModel().scrollToCaret(ScrollType.CENTER);
            JumpAction.logicalPosition = null;
        }
    }
}
