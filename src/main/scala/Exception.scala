package com.scalajson

object Exception {
  class SystemException(val kind: String, val Info: Json) extends Exception {
    override def toString(): String = kind + ":" + Compact(ino)
  }

  class JsonParseException(val msg: String, val input: String) {
    
  }
}