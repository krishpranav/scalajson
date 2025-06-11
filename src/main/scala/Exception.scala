package com.json

import com.json.JsonOps._

object Exceptions {

  class SystemException(val kind: String, val info: Json) extends Exception {
    override def toString(): String = kind + ":" + Compact(info)
  }

  class JsonParseException(val msg: String, val input: String, val line: Int, val char: Int)
    extends SystemException("JsonParse", JsonObject("msg" -> msg, "line" -> line, "char" -> char, "input" -> input)) {

    def shortString() = {
      "[" + jgetInt(info, "line") + "," + jgetInt(info, "char") + "] " + jgetString(info, "msg")

    }

    override def toString() = {
      shortString + " (" + jgetString(info, "input") + ")"
    }
  }
  
  case class MappingException(val msg: String, val path: String = "") extends SystemException("Mapping", JsonObject("msg" -> msg, "path" -> path))

}