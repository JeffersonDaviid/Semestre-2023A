// package Proyecto;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// public class CustomPanelExample {
// public static void main(String[] args) {

// JFrame frame = new JFrame("Custom Panel Example");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// CustomPanel customPanel = new CustomPanel();
// frame.add(customPanel);

// frame.setLocationRelativeTo(null);
// frame.setVisible(true);

// }
// }

// class CustomPanel extends JPanel {
// private Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
// private int currentColorIndex = 0;

// public CustomPanel() {
// addMouseListener(new MouseAdapter() {
// @Override
// public void mouseClicked(MouseEvent e) {
// if (SwingUtilities.isLeftMouseButton(e)) {
// changeBackgroundColor();
// } else if (SwingUtilities.isRightMouseButton(e)) {
// changeBackgroundColor();
// }
// }
// });
// }

// private void changeBackgroundColor() {
// currentColorIndex = (currentColorIndex + 1) % colors.length;
// setBackground(colors[currentColorIndex]);
// repaint();
// }

// @Override
// protected void paintComponent(Graphics g) {
// super.paintComponent(g);
// // Puedes agregar aquí el código para dibujar cualquier otro contenido
// // personalizado en el panel.
// }
// }
