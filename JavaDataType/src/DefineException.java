/**
 * 自定义异常示例。
 */
public class DefineException {
    public static void main(String[] args) {
        String str[] = {"-1", "20"};
        ExceptionClass ec = new ExceptionClass(Integer.parseInt(str[0]));
    }
}


class ExceptionClass{
    public ExceptionClass(int fun){
        try {
            if(fun < 0){
                throw new ArraySizeException();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

/**
 * 自定义异常类ArraySizeException,继承自NegativeArraySizeException
 */
class ArraySizeException extends NegativeArraySizeException{
    public ArraySizeException(){
        super("数组不正确.");
    }
}