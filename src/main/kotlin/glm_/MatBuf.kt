package glm_

import kool.bufferBig
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer

interface MatBuf { // TODO rename ToBuffer?

    fun toBufferStack(): ByteBuffer = to(MemoryStack.stackGet().malloc(size()), 0)
    infix fun toBuffer(stack: MemoryStack): ByteBuffer = to(stack.malloc(size()), 0)
    fun toBuffer(): ByteBuffer = to(bufferBig(size()), 0)
    infix fun to(buf: ByteBuffer): ByteBuffer = to(buf, 0)

    fun to(buf: ByteBuffer, offset: Int): ByteBuffer

    fun size(): Int
}