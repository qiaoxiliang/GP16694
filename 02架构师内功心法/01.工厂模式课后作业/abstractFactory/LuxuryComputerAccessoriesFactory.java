package abstractFactory;

public class LuxuryComputerAccessoriesFactory implements ComputerAccessoriesFactory {
    @Override
    public KeyBoard useKeyBoard() {
        return new LuxuryKeyBoard();
    }

    @Override
    public Mouse useMouse() {
        return new LuxuryMouse();
    }
}
