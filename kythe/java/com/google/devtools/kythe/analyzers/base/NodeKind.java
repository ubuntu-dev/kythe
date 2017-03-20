/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.kythe.analyzers.base;

import com.google.common.base.Optional;
import javax.annotation.Nullable;

/** Schema-defined Kythe node kinds. */
public enum NodeKind {
  // Core kinds
  ABS("abs"),
  ABS_VAR("absvar"),
  ANCHOR("anchor"),
  CONSTANT("constant"),
  DOC("doc"),
  FILE("file"),
  FUNCTION("function"),
  INTERFACE("interface"),
  NAME("name"),
  PACKAGE("package"),
  PROCESS("process"),
  TAPPLY("tapp"),
  TBUILTIN("tbuiltin"),

  // Sub-kinds
  FUNCTION_CONSTRUCTOR("function", "constructor"),
  RECORD_CLASS("record", "class"),
  SUM_ENUM_CLASS("sum", "enumClass"),
  VARIABLE_EXCEPTION("variable", "local/exception"),
  VARIABLE_FIELD("variable", "field"),
  VARIABLE_LOCAL("variable", "local"),
  VARIABLE_PARAMETER("variable", "local/parameter"),
  VARIABLE_RESOURCE("variable", "local/resource");

  private final String kind;
  @Nullable
  private final String subkind;

  NodeKind(String kind) {
    this(kind, null);
  }

  NodeKind(String kind, @Nullable String subkind) {
    this.kind = kind;
    this.subkind = subkind;
  }

  /** Returns the node's kind Kythe GraphStore value. */
  public final String getKind() {
    return kind;
  }

  /** Returns the node's subkind Kythe GraphStore value (or {@code null}). */
  public final Optional<String> getSubkind() {
    return Optional.fromNullable(subkind);
  }

  @Override
  public String toString() {
    return kind + (subkind == null ? "" : "/" + subkind);
  }
}
