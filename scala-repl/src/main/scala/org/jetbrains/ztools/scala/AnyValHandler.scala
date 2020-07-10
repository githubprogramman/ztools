/**
 * Copyright 2020 Jetbrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.ztools.scala

import org.jetbrains.ztools.core.Loopback
import org.jetbrains.bigdataide.shaded.org.json.JSONObject

class AnyValHandler extends AbstractTypeHandler {
  override def accept(obj: Any): Boolean =
    obj match {
      case _: Byte => true
      case _: Short => true
      case _: Boolean => true
      case _: Char => true
      case _: Int => true
      case _: Long => true
      case _: Float => true
      case _: Double => true
      case _ => false
    }

  override def handle(obj: Any, id: String, loopback: Loopback): JSONObject =
    withJsonObject {
      json =>
        json.put("value", obj)
    }
}
