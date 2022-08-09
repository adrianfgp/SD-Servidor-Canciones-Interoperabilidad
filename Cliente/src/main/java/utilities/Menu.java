package utilities;

/**
 *
 * @author jhonfer
 */
public abstract class Menu {
    private String title;
    private String[] menuOptions;
    protected int option;
    private int optionExit;

    public Menu(String title, String[] menuOptions) {
        this.title = title;
        this.menuOptions = menuOptions;
        this.optionExit = menuOptions.length + 1;
    }

    protected void repeatedMenu() {
        do {
            this.showMenu();
            this.readOption();
            this.processOption();
        } while (this.option != this.optionExit);
    }

    private void showMenu() {
        Console.writeJumpLine(title, false);
        Console.writeJumpLine(menuOptions, false);
        Console.writeJumpLine(optionExit + ".Salir...", false);
    }

    private void readOption() {
        this.option = 0;
        option = Console.read("Ingrese la opción deseada: ", this.option, false);
        if (option < 1 || option > optionExit) {
            Console.writeJumpLine("Opción invalida", false);
        }
    }

    public abstract void processOption();
}