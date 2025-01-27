package gui;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class ProcesadorTexto {

    public static void main(String[] args) {

        MarcoProcesador myFrame = new MarcoProcesador();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoProcesador extends JFrame {

    public MarcoProcesador() {
        setBounds(600, 300, 550, 400);
        PanelProcesador myPanel = new PanelProcesador();
        add(myPanel);
        setVisible(true);
    }
}

class PanelProcesador extends JPanel {

    JTextPane textPanel;

    JMenu font, style, size;

    JButton boldButton, italicButton, underlineButton, redButton,
            blueButton, yellowButton, leftButton, centerButton, rightButton, justifyButton;

    JToolBar toolBar;


    public PanelProcesador() {
        setLayout(new BorderLayout());

        /* Menu */
        JPanel menuPanel = new JPanel();
        JMenuBar menuBar = new JMenuBar();

        /* Font submenu **/
        font = new JMenu("Fuente");
        menuConfig("Arial", "Fuente", "Arial", 9, 10, "");
        menuConfig("Courier", "Fuente", "Courier", 9, 10, "");
        menuConfig("Verdana", "Fuente", "Verdana", 9, 10, "");


        /* Style submenu **/
        style = new JMenu("Estilo");
        menuConfig("Negrita", "Estilo", "", Font.BOLD, 1, "./src/gui/bold.png");
        menuConfig("Cursiva", "Estilo", "", Font.ITALIC, 1, "./src/gui/italic.png");
        /* deprecated
        JCheckBoxMenuItem bold = new JCheckBoxMenuItem("Negrita", new ImageIcon("./src/gui/bold.png"));
        JCheckBoxMenuItem italic = new JCheckBoxMenuItem("Cursiva", new ImageIcon("./src/gui/italic.png"));
        style.add(bold);
        style.add(italic);
        bold.addActionListener(new StyledEditorKit.BoldAction());
        italic.addActionListener(new StyledEditorKit.ItalicAction());
        */


        /* Size submenu **/
        size = new JMenu("Tamaño");
        /* deprecated
        menuConfig("12", "Tamaño", "", 9, 12, "");
        menuConfig("16", "Tamaño", "", 9, 16, "");
        menuConfig("20", "Tamaño", "", 9, 20, "");
        menuConfig("24", "Tamaño", "", 9, 24, "");
        */

        ButtonGroup fontSize = new ButtonGroup();
        JRadioButtonMenuItem size12 = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem size16 = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem size20 = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem size24 = new JRadioButtonMenuItem("24");
        fontSize.add(size12);
        fontSize.add(size16);
        fontSize.add(size20);
        fontSize.add(size24);
        size.add(size12);
        size.add(size16);
        size.add(size20);
        size.add(size24);
        size12.addActionListener(new StyledEditorKit.FontSizeAction("Change size", 12));
        size16.addActionListener(new StyledEditorKit.FontSizeAction("Change size", 16));
        size20.addActionListener(new StyledEditorKit.FontSizeAction("Change size", 20));
        size24.addActionListener(new StyledEditorKit.FontSizeAction("Change size", 24));

        /* Adding some keybindings */
        size24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));

        /* Text Panel */

        textPanel = new JTextPane();


        /* Adding all to the interface */

        menuBar.add(font);
        menuBar.add(style);
        menuBar.add(size);

        menuPanel.add(menuBar);

        add(menuPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        /* Popup menu */

        JPopupMenu popup = new JPopupMenu();

        JMenuItem popupBold = new JMenuItem("Negrita", new ImageIcon("./src/gui/bold.png"));
        JMenuItem popupItalic = new JMenuItem("Cursiva", new ImageIcon("./src/gui/italic.png"));
        popup.add(popupBold);
        popup.add(popupItalic);
        popupBold.addActionListener(new StyledEditorKit.BoldAction());
        popupItalic.addActionListener(new StyledEditorKit.ItalicAction());

        textPanel.setComponentPopupMenu(popup);

        /* Toolbar */

        /* DEPRECATED
        JToolBar toolBar = new JToolBar("Barra de herramientas", JToolBar.VERTICAL);


        JButton boldButton = new JButton(new ImageIcon("./src/gui/bold.png"));
        boldButton.addActionListener(new StyledEditorKit.BoldAction());
        toolBar.add(boldButton);

        JButton italicButton = new JButton(new ImageIcon("./src/gui/italic.png"));
        italicButton.addActionListener(new StyledEditorKit.ItalicAction());
        toolBar.add(italicButton);

        JButton underlineButton = new JButton(new ImageIcon("./src/gui/underline.png"));
        underlineButton.addActionListener(new StyledEditorKit.UnderlineAction());
        toolBar.add(underlineButton);

        JButton blueButton = new JButton(new ImageIcon("./src/gui/blue.png"));
        blueButton.addActionListener(new StyledEditorKit.ForegroundAction("blue", Color.BLUE));
        toolBar.add(blueButton);

        JButton yellowButton = new JButton(new ImageIcon("./src/gui/yellow.png"));
        yellowButton.addActionListener(new StyledEditorKit.ForegroundAction("yellow", Color.YELLOW));
        toolBar.add(yellowButton);

        JButton redButton = new JButton(new ImageIcon("./src/gui/red.png"));
        redButton.addActionListener(new StyledEditorKit.ForegroundAction("red", Color.RED));
        toolBar.add(redButton);


        JButton leftButton = new JButton(new ImageIcon("./src/gui/left.png"));
        leftButton.addActionListener(new StyledEditorKit.AlignmentAction("left", StyleConstants.ALIGN_LEFT));
        toolBar.add(leftButton);

        JButton centerButton = new JButton(new ImageIcon("./src/gui/center.png"));
        centerButton.addActionListener(new StyledEditorKit.AlignmentAction("center", StyleConstants.ALIGN_CENTER));
        toolBar.add(centerButton);

        JButton rightButton = new JButton(new ImageIcon("./src/gui/right.png"));
        rightButton.addActionListener(new StyledEditorKit.AlignmentAction("right", StyleConstants.ALIGN_RIGHT));
        toolBar.add(rightButton);

        JButton justifyButton = new JButton(new ImageIcon("./src/gui/justify.png"));
        justifyButton.addActionListener(new StyledEditorKit.AlignmentAction("justify", StyleConstants.ALIGN_JUSTIFIED));
        toolBar.add(justifyButton);

        */

        toolBar = new JToolBar("Barra de herramientas", JToolBar.VERTICAL);

        toolBarConfig("./src/gui/bold.png").addActionListener(new StyledEditorKit.BoldAction());
        toolBarConfig("./src/gui/italic.png").addActionListener(new StyledEditorKit.ItalicAction());
        toolBarConfig("./src/gui/underline.png").addActionListener(new StyledEditorKit.UnderlineAction());
        toolBar.addSeparator();
        toolBarConfig("./src/gui/red.png").addActionListener(new StyledEditorKit.ForegroundAction("Red", Color.RED));
        toolBarConfig("./src/gui/blue.png").addActionListener(new StyledEditorKit.ForegroundAction("Blue", Color.BLUE));
        toolBarConfig("./src/gui/yellow.png").addActionListener(new StyledEditorKit.ForegroundAction("Yellow", Color.YELLOW));
        toolBar.addSeparator();
        toolBarConfig("./src/gui/left.png").addActionListener(new StyledEditorKit.AlignmentAction("left", StyleConstants.ALIGN_LEFT));
        toolBarConfig("./src/gui/center.png").addActionListener(new StyledEditorKit.AlignmentAction("center", StyleConstants.ALIGN_CENTER));
        toolBarConfig("./src/gui/right.png").addActionListener(new StyledEditorKit.AlignmentAction("right", StyleConstants.ALIGN_RIGHT));
        toolBarConfig("./src/gui/justify.png").addActionListener(new StyledEditorKit.AlignmentAction("justify", StyleConstants.ALIGN_JUSTIFIED));

        add(toolBar, BorderLayout.WEST);
    }

    public JButton toolBarConfig(String route) {
        JButton button = new JButton(new ImageIcon(route));
        toolBar.add(button);
        return button;
    }

    public void menuConfig(String title, String menu, String font, int style, int size, String icon) {
        JMenuItem menuItem = new JMenuItem(title, new ImageIcon(icon));
        switch (menu) {
            case "Fuente" -> {
                this.font.add(menuItem);

                if (Objects.equals(font, "Arial")) {
                    menuItem.addActionListener(new StyledEditorKit.FontFamilyAction("Change size", "Arial"));
                } else if (Objects.equals(font, "Verdana")) {
                    menuItem.addActionListener(new StyledEditorKit.FontFamilyAction("Change size", "Verdana"));
                } else if (Objects.equals(font, "Courier")) {
                    menuItem.addActionListener(new StyledEditorKit.FontFamilyAction("Change size", "Courier"));
                }
            }
            case "Estilo" -> {
                this.style.add(menuItem);
                if (style == Font.BOLD) {
                    menuItem.addActionListener(new StyledEditorKit.BoldAction());
                    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
                } else if ((style == Font.ITALIC)) {
                    menuItem.addActionListener(new StyledEditorKit.ItalicAction());
                    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK));
                }
            }
            /* Sustituído con el JRadioMenuItem
            case "Tamaño" -> {
                this.size.add(menuItem);
                menuItem.addActionListener(new StyledEditorKit.FontSizeAction("Change size", size));
            } */
        }
    }
}