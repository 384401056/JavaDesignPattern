import org.apache.mina.core.buffer.IoBuffer;


public class MinaIoBuffer {

	
	public static void main(String[] args) {
		
		IoBuffer buffer = IoBuffer.allocate(10);
		
		for (int i = 0; i < 10; i++) {

			buffer.put("0".getBytes());
		}
	}
	
}
