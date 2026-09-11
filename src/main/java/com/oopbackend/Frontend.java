package com.oopbackend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;


public class Frontend extends JFrame
{
    //Declare JComboBox variables
    private final JTextArea serverResponseArea;
    private final JComboBox<String> courseComboBox;
    private final JComboBox<String> groupComboBox;
    private final JComboBox<String> exerciseComboBox;
    private final JComboBox<String> fileComboBox;

    public Frontend()
    {
        //title of the frame
        super("Test Client Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and Initialize components
        JPanel panel = new JPanel(new GridLayout(5, 2));
        serverResponseArea = new JTextArea();
        JButton sendButton = new JButton("Send URL");
        //change the place of the components in x,y direction & Set gaps between components
        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(80, 80, 80, 80); */


        //Data for demonstration
        String[] courses={"OOP"};
        String[] groups={"Group1","Group2"};
        String[] exercises={"Exercise01","Exercise02"};
        String[][] files={{"exercise01.txt","data.txt"},{"exercise02.txt","data.txt"}};

        // Initialize JComboBoxes
        courseComboBox = new JComboBox<>(courses);
        groupComboBox = new JComboBox<>(groups);
        exerciseComboBox = new JComboBox<>(exercises);
        fileComboBox = new JComboBox<>();

        // Add action listener to exerciseComboBox
        exerciseComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectedExerciseIndex = exerciseComboBox.getSelectedIndex();
                fileComboBox.removeAllItems();
                if (selectedExerciseIndex >= 0) {
                    for (String file : files[selectedExerciseIndex]) {
                        fileComboBox.addItem(file);
                    }
                }
            }
        });
        //initialize file combobox with files
        if (exercises.length > 0) {
            for (String file : files[0]) {
                fileComboBox.addItem(file);
            }
        }


        // Add components to panel
        /*gbc.gridx = 0;
          gbc.gridy = 0;
          panel.add(new JLabel("Course:"),gbc);
          gbc.gridx=1;
          panel.add(courseComboBox);
          */
        panel.add(new JLabel("Course:"));
        panel.add(courseComboBox);
        panel.add(new JLabel("Group:"));
        panel.add(groupComboBox);
        panel.add(new JLabel("Exercise:"));
        panel.add(exerciseComboBox);
        panel.add(new JLabel("File:"));
        panel.add(fileComboBox);
        panel.add(sendButton);


        // Add panel and server response area to frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(serverResponseArea), BorderLayout.CENTER);

        // Action listener for the send button
        sendButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Get the selected values from the combo boxes
                String course = (String) courseComboBox.getSelectedItem();
                String group = (String) groupComboBox.getSelectedItem();
                String exercise = (String) exerciseComboBox.getSelectedItem();
                String file = (String) fileComboBox.getSelectedItem();

                // Check if a file is selected
                if (file == null) {
                    serverResponseArea.setText("Error: No file selected.");
                    return;
                }

                // Get the URL from the text field
                //String urlString = "http://localhost:8000/host/OOP/Group1/Exercise01/exercise01.txt";
                String urlString = "http://localhost:8000/host/" + course + "/" + group + "/" + exercise + "/" + file;

                try
                {
                    // create URL object
                    URL url = new URL(urlString);

                    //create HttpURLConnection
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    //Set request mode to GET
                    connection.setRequestMethod("GET");

                    //get response code
                    int responseCode = connection.getResponseCode();

                    //Read response from input stream
                    BufferedReader reader = new BufferedReader(new InputStreamReader (connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    //Display server response
                    serverResponseArea.setText("Response code: " + responseCode + "\n" + response.toString());

                    // Disconnect the connection
                    connection.disconnect();

                } catch(IOException ex)
                {
                    //Display error message if an exception occurs
                    serverResponseArea.setText("Error: " + ex.getMessage());

                }

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frontend().setVisible(true);
            }
        });
    }
}
