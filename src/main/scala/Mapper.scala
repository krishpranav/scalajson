package com.json

import JsonOps._
import com.json.{WriteCodec, ReadCodec}

object JsonMapper {

  def ToObject[T](j: Json)(implicit codec: ReadCodec[T]): T = codec.read(j)

  def ToJson[T](x: T)(implicit codec: WriteCodec[T]): Json = codec.write(x)
}

