package abstractFactory;

public class CommonComputerAccessoriesFactory implements ComputerAccessoriesFactory {
    @Override
    public KeyBoard useKeyBoard() {
        return new CommonKeyBoard();
    }

    @Override
    public Mouse useMouse() {
        return new CommonMouse();
    }
}
