import java.io.FileNotFoundException;

public interface ExceptionMethods {
	public void voidIntException(int p1) throws Exception;
	public void voidIntFNFException(int p1) throws FileNotFoundException;
	public void voidIntIException(int p1) throws InterruptedException;
}

