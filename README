Project Documentation for Test Client Application
Overview
The Test Client Application is a simple Java Swing-based graphical user interface (GUI) application that allows users to select various parameters related to courses, groups, exercises, and files. Based on these selections, the application constructs a URL and sends an HTTP GET request to a server. The server's response is then displayed in a text area within the GUI.
Components
Frontend Class
The main class of the application which extends JFrame and sets up the GUI components and their behaviors.
GUI Components
    • JComboBox: Drop-down lists for selecting courses, groups, exercises, and files.
    • JTextArea: A text area for displaying the server's response.
    • JButton: A button to trigger the sending of the constructed URL.
    • JPanel: A panel for organizing the components in a grid layout.
Initialization
The GUI components are initialized and added to the frame. The layout is set using a BorderLayout, and components are arranged in a grid using a JPanel with a GridLayout.
    • Combo Box Data
Static arrays are used to store data for courses, groups, exercises, and files. The files array is a two-dimensional array that corresponds to each exercise.
String[] courses = {"OOP"};
String[] groups = {"Group1", "Group2"};
String[] exercises = {"Exercise01", "Exercise02"};
String[][] files = {{"exercise01.txt", "data.txt"}, {"exercise02.txt", "data.txt"}};
    • JComboBox Initialization
The combo boxes are initialized with the data arrays. The exerciseComboBox has an action listener that updates the fileComboBox based on the selected exercise.
courseComboBox = new JComboBox<>(courses);
groupComboBox = new JComboBox<>(groups);
exerciseComboBox = new JComboBox<>(exercises);
fileComboBox = new JcomboBox<>();

    • Action Listener to Exercise Combobox
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
	Action Listener Registration:
    • The addActionListener method registers an action listener to exerciseComboBox. This means that whenever an action event (such as a user selecting an item) occurs on the exerciseComboBox, the actionPerformed method will be invoked.
Action Performed Method:
    • This method is triggered when an action event occurs on the exerciseComboBox.
      Retrieve Selected Index:
      int selectedExerciseIndex = exerciseComboBox.getSelectedIndex();
    • This line gets the index of the selected item in exerciseComboBox.
      Clear fileComboBox Items:
      fileComboBox.removeAllItems();
    • This line clears all items from fileComboBox, preparing it to be populated with new items.
      Populate fileComboBox with New Items:
    • The if statement checks if a valid index is selected (i.e., not -1).
    • The for loop iterates over the files associated with the selected exercise and adds each file to fileComboBox using fileComboBox.addItem(file);.
    • Initializing file combobox with files
if (exercises.length > 0) {
    for (String file : files[0]) {
        fileComboBox.addItem(file);
    }
}

	Populate fileComboBox with Initial Files:
    • The for loop iterates over the files associated with the first exercise (files[0]).
    • Each file is added to fileComboBox using fileComboBox.addItem(file);.

    • Action Listener to sent button
The sendButton has an action listener that constructs the URL from the selected values and sends an HTTP GET request. The server's response is read and displayed in the serverResponseArea.
sendButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Get selected values
        String course = (String) courseComboBox.getSelectedItem();
        String group = (String) groupComboBox.getSelectedItem();
        String exercise = (String) exerciseComboBox.getSelectedItem();
        String file = (String) fileComboBox.getSelectedItem();
	// Check if a file is selected
        if (file == null) {
            serverResponseArea.setText("Error: No file selected.");
            return;
        }
    	// Construct the URL
        String urlString = "http://localhost:8000/host/" + course + "/" + group + "/" + exercise + "/" + file;
         try {
            // Create URL object
            URL url = new URL(urlString);
	// Create HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	// Set request method to GET
            connection.setRequestMethod("GET");
	// Get response code
            int responseCode = connection.getResponseCode();
	// Read response from input stream
	BufferedReaderreader=newBufferedReader(new InputStreamReader 	(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);}
            reader.close();
	// Display server response
      	serverResponseArea.setText("Response code: " + responseCode + "\n" + 	response.toString());
	// Disconnect the connection
            connection.disconnect();
	} catch (IOException ex) {
            // Display error message if an exception occurs
            serverResponseArea.setText("Error: " + ex.getMessage());
        }
    }
});
    • Main Method
The main method runs the GUI application on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater.

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new Frontend().setVisible(true);
        }
    });
}


Dependencies
    • Java Development Kit (JDK) 8 or higher.
    • Internet connection for making HTTP requests.
Application Flow
    1. The user selects a course, group, exercise, and file from the drop-down lists.
    2. The user clicks the "Send URL" button.
    3. The application constructs a URL based on the selected values and sends an HTTP GET request.
    4. The server's response is displayed in the text area.
Error Handling
    • If no file is selected, an error message is displayed in the text area.
    • If an exception occurs during the HTTP request, the error message is displayed in the text area.
Future Enhancements
    • Add more courses, groups, exercises, and files to the combo boxes.
    • Implement dynamic data loading from a server or database.
    • Improve the error handling to cover more cases and provide more detailed messages.
    • Add functionality for other HTTP methods like POST, PUT, and DELETE.
    • Enhance the GUI with additional features and better styling.
This documentation provides an overview of the Test Client Application and guides you through its components, usage, and potential future improvements.

Resource

    • https://www.javatpoint.com/java-jlabel
    • https://chat.openai.com
      
