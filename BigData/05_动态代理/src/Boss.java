public class Boss implements IBoss {

    @Override
    public int yifu(String size) {
        System.err.println("老板给客户发衣服....");
        return Integer.parseInt(size) *200;
    }
}
