/*team name: Ecommerce System

محمد علي محمد علي    51355
مصطفى ابراهيم السيد احمد	26911
يوسف سالم عبد الخالق محمد	26908
26992     مرام محمود مساعد هيبة
51363      اسماء خالد حسن حسنين
51405      اميره عاطف مبروك احمد
26949	  سلوي خالد محمد جادالله
زياد اسلام احمد مصطفى عطا	51416
احمد سامح محمد    	26987	   
51423    محمود يسري عاطف محمود 
*/



import java.awt.*;
import javax.swing.*;

public class EcommerceGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("🛒 Ecommerce System");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel label = new JLabel("Customer ID:");
        label.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(label, gbc);

        JTextField idField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(idField, gbc);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        JTextField nameField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(nameField, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(addressLabel, gbc);

        JTextField addressField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(addressField, gbc);

        JLabel numLabel = new JLabel("Number of  Products :");
        numLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(numLabel, gbc);

        JTextField numField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(numField, gbc);

        JButton submitButton = new JButton("Place Order");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        // Button logic
        submitButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText().trim();
                String address = addressField.getText().trim();
                int num = Integer.parseInt(numField.getText());

                cart cart = new cart(id, num);
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < num; i++) {
                    String[] options = {"Book", "Clothing", "Electronic"};
                    int choice = JOptionPane.showOptionDialog(
                            frame,
                            "Select product type #" + (i + 1),
                            "Choose Product",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    switch (choice) {
                        case 0:
                            BookProduct b1 = new BookProduct(3, "OOP", 39.99, "O’Reilly", "X Publications");
                            cart.addProduct(b1);
                            break;
                        case 1:
                            clothingProduct c3 = new clothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton");
                            cart.addProduct(c3);
                            break;
                        case 2:
                            ElectronicProduct e1 = new ElectronicProduct(1, "Smartphone", 599.99, "Samsung", 1);
                            cart.addProduct(e1);
                            break;
                        default:
                            i--;
                            continue;
                    }
                }

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Would you like to place the order?",
                        "Confirm Order",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    cart.placeOrder();
                    order o1 = new order(id, 1, cart.getProducts(), (float) cart.calculatePrice());
                    result.append("✔ Order placed successfully!\n");
                    result.append("Customer ID: ").append(id).append("\n");
                    result.append("Customer Name: ").append(name).append("\n");
                    result.append("Customer Address: ").append(address).append("\n");
                    result.append(o1.toString());
                } else {
                    result.append("❌ Order was canceled.\n");
                }

                resultArea.setText(result.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
