// Package declaration
package Solution;

// Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaLookupApp
{
    // Main frame
    private final JFrame frame;
    // Components
    private final JComboBox<String> countryComboBox;
    private final JComboBox<String> townComboBox;
    private final JRadioButton phoneRadioButton;
    private final JRadioButton postalRadioButton;
    private final JButton submitButton;
    private final JButton exitButton;

    // Data handler
    private final CountryData countryData;

    // Constructor to set up the GUI
    public AreaLookupApp()
    {
        // Initialize the data handler
        countryData = new CountryData();
        
        // Initialize frame
        frame = new JFrame("Area Lookup Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        // Country selection combo box
        countryComboBox = new JComboBox<>(countryData.getCountries());
        countryComboBox.addActionListener(new CountrySelectionHandler());
        frame.add(createPanel("Select Country:", countryComboBox));

        // Town selection combo box
        townComboBox = new JComboBox<>();
        frame.add(createPanel("Select Town:", townComboBox));

        // Radio buttons for phone or postal code
        phoneRadioButton = new JRadioButton("Phone Code");
        postalRadioButton = new JRadioButton("Postal Code");
        ButtonGroup codeGroup = new ButtonGroup();
        codeGroup.add(phoneRadioButton);
        codeGroup.add(postalRadioButton);
        phoneRadioButton.setSelected(true);  // Default selection
        JPanel radioPanel = new JPanel();
        radioPanel.add(phoneRadioButton);
        radioPanel.add(postalRadioButton);
        frame.add(radioPanel);

        // Submit and exit buttons
        submitButton = createRoundedButton("Submit", Color.decode("#007AFF"));
        exitButton = createRoundedButton("Exit", Color.decode("#FF3B30"));
        submitButton.addActionListener(new SubmitHandler());
        exitButton.addActionListener(e -> System.exit(0)); // Exit application
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel);

        // Set frame visibility
        frame.setVisible(true);
    }

    // Utility method to create a panel with a label and component
    private JPanel createPanel(String labelText, JComponent component)
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel(labelText));
        panel.add(component);
        return panel;
    }

    // Create a rounded button
    private JButton createRoundedButton(String text, Color backgroundColor)
    {
        JButton button = new JButton(text)
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setMargin(new Insets(10, 20, 10, 20));
        return button;
    }

    // Handler for country selection, updates town combo box
    private class CountrySelectionHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String selectedCountry = (String) countryComboBox.getSelectedItem();
            if (selectedCountry != null)
            {
                // Update towns based on selected country
                townComboBox.setModel(new DefaultComboBoxModel<>(countryData.getTowns(selectedCountry)));
            }
        }
    }

    // Handler for submit button
    private class SubmitHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String selectedCountry = (String) countryComboBox.getSelectedItem();
            String selectedTown = (String) townComboBox.getSelectedItem();
            if (selectedCountry != null && selectedTown != null)
            {
                // Get the code based on radio button selection
                String code;
                if (phoneRadioButton.isSelected())
                {
                    code = countryData.getPhoneCode(selectedCountry, selectedTown);
                }
                else
                {
                    code = countryData.getPostalCode(selectedCountry, selectedTown);
                }
                JOptionPane.showMessageDialog(frame, "Code for " + selectedTown + ": " + code);
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(AreaLookupApp::new);
    }
}
