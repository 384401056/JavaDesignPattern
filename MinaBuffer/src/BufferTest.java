import java.nio.ByteBuffer;

/**
 * Apache Mina在IoFilter中使用IoBuffer做为数据缓冲对象， 而IoBuffer的实现来自于java.nio.Buffer
 * 
 * 在Buffer类当中有以下四个重要的属性：
 * mark：标记位，用于reset（）时把position恢复到原来的位置，调用mark（）方法使position的值赋与mark
 * position：表示Buffer中第一个可以被读取或写入的数据的位置
 * ，每次调用put（）方法时,把写入的数据放到position位置，然后position的值就会加1
 * limit：表示buffer中第一个不可被读取或写入的数据的位置，也即停止位，数据操作到此为止 capacity：初始化时调用allocate(int
 * size)为buffer分配的空间大小，不可变
 * 
 * @author Gaoyanbin
 *
 */
public class BufferTest {

	public static void main(String[] args) {

		int capacity = 10;
		ByteBuffer buffer = ByteBuffer.allocate(capacity);

		for (int i = 0; i < 9; i++) {

			buffer.put((byte) i);

		}

//		for (int i = 0; i < 8; i++) {
//
//			System.out.println(buffer.get(i));
//
//		}

		System.out.println("pos:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("cap:" + buffer.capacity());

		buffer.flip();// 将position置为0，limit还是当前位置,如果mark标记被定义则丢弃。
		System.out.println("=======after flip========");
		System.out.println("pos:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("cap:" + buffer.capacity());

		buffer.mark();
		System.out.println("=======after mark========");
		System.out.println("pos:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("cap:" + buffer.capacity());

		buffer.reset();// 将position置为0，limit还是当前位置。
		System.out.println("=======after reset========");
		System.out.println("pos:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("cap:" + buffer.capacity());

//		for (int i = 0; i < 8; i++) {
//
//			System.out.println(buffer.get(i));
//
//		}

		buffer.clear();//// 将position置为0，limit置为cap.数据还在.
		System.out.println("=======after clear========");
		System.out.println("pos:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("cap:" + buffer.capacity());

//		for (int i = 0; i < 10; i++) {
//
//			System.out.println(buffer.get(i));
//
//		}

	}

}
