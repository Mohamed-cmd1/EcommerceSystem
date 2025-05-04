import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EcommerceGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ecommerce System");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Please Enter your ID: ");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JTextField idField = new JTextField();
        idField.setBounds(220, 20, 200, 25);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Please Enter your Name: ");
        nameLabel.setBounds(10, 60, 200, 25);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(220, 60, 200, 25);
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Please Enter your Address: ");
        addressLabel.setBounds(10, 100, 200, 25);
        panel.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(220, 100, 200, 25);
        panel.add(addressField);

        JLabel numLabel = new JLabel("How many products you want to add: ");
        numLabel.setBounds(10, 140, 250, 25);
        panel.add(numLabel);

        JTextField numField = new JTextField();
        numField.setBounds(220, 140, 200, 25);
        panel.add(numField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 180, 150, 30);
        panel.add(submitButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 220, 450, 180);
        resultArea.setEditable(false);
        panel.add(resultArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String address = addressField.getText();
                    int num = Integer.parseInt(numField.getText());

                    cart cart = new cart(id, num);
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < num; i++) {
                        String productChoice = JOptionPane.showInputDialog(
                            frame, "What type of product you want to add?\n1. Book\n2. Clothing\n3. Electronic");
                        int choice = Integer.parseInt(productChoice);

                        switch (choice) {
                            case 1:
                                BookProduct b1 = new BookProduct(3, "OOP", 39.99, "O’Reilly", "X Publications");
                                cart.addProduct(b1);
                                break;
                            case 2:
                                clothingProduct c3 = new clothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton");
                                cart.addProduct(c3);
                                break;
                            case 3:
                                ElectronicProduct e1 = new ElectronicProduct(1, "Smartphone", 599.99, "Samsung", 1);
                                cart.addProduct(e1);
                                break;
                            default:
                                JOptionPane.showMessageDialog(frame, "Invalid product choice.");
                                i--; 
                        }
                    }

                    String orderChoice = JOptionPane.showInputDialog(
                        frame, "Would you like to place an order?\n1. Yes\n2. No");

                    if ("1".equals(orderChoice)) {
                        cart.placeOrder();
                        order o1 = new order(id, 1, cart.getProducts(), (float) cart.calculatePrice());
                        result.append(o1.toString());
 
                    } else {
                        result.append("Your order has been canceled.\n");
                    }

                    resultArea.setText(result.toString());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}
