package com.sgaop.idea.codeinsight;

import com.intellij.codeHighlighting.Pass;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 306955302@qq.com
 * @date 2017/12/29  11:30
 */
public class JavaNutzLineMarkerProvider extends LineMarkerProviderDescriptor {

    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement bindingElement) {
        if (NutzLineUtil.isAtOk(bindingElement)) {
            return new LineMarkerInfo<>(bindingElement, bindingElement.getTextRange(), AllIcons.FileTypes.Jsp,
                    Pass.LINE_MARKERS, null, new NutzGutterIconNavigationHandler(),
                    GutterIconRenderer.Alignment.LEFT);
        }
        return null;
    }

    @Nullable
    @Override
    public String getName() {
        return "Nutz Ok navigate";
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> elements, @NotNull Collection<LineMarkerInfo> result) {
    }

}