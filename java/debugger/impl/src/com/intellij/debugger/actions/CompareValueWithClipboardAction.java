/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.debugger.actions;

import com.intellij.debugger.impl.DebuggerContextImpl;
import com.intellij.debugger.ui.impl.watch.DebuggerTreeNodeImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.diff.DiffDialogHints;
import com.intellij.openapi.util.diff.DiffManager;
import com.intellij.openapi.util.diff.DiffRequestFactory;
import com.intellij.openapi.util.diff.requests.DiffRequest;

/**
 * @author Jeka
 */
public class CompareValueWithClipboardAction extends BaseValueAction {
  protected void processText(final Project project, final String text, DebuggerTreeNodeImpl node, DebuggerContextImpl debuggerContext) {
    DiffRequest request = DiffRequestFactory.getInstance().createClipboardVsValue(text);
    DiffManager.getInstance().showDiff(project, request, DiffDialogHints.DEFAULT);
  }
}