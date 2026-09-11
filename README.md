# Test Client Application

## Overview

The Test Client Application is a simple Java Swing GUI that allows users to select a course, group, exercise, and file. Based on the selected values, the application constructs a URL and sends an HTTP GET request to the file server.

The server response is then displayed in the application.

---

## Features

- Select a course from a drop-down list.
- Select a group.
- Select an exercise.
- Select a file related to the selected exercise.
- Automatically update the available files when an exercise is selected.
- Construct a server URL from the selected values.
- Send HTTP GET requests to the server.
- Display the server response and HTTP response code.
- Display error messages when a request cannot be completed.

---

## Technologies Used

- **Java**
- **Java Swing** for the graphical user interface
- **HTTP GET requests** for communication with the server
- **HttpURLConnection** for connecting to the server

---

## Components

### Frontend Class

The main application is implemented in the `Frontend` class, which extends `JFrame`.

The class is responsible for:

- Creating the graphical user interface.
- Managing the combo boxes.
- Handling user interactions.
- Constructing the server URL.
- Sending HTTP requests.
- Displaying the server response.

### GUI Components

The application uses several Swing components:

- `JComboBox` – used for selecting courses, groups, exercises, and files.
- `JTextArea` – used to display the server response.
- `JButton` – used to send the request.
- `JPanel` – used to organize the GUI components.

---

## Initialization

The application initializes the GUI components and arranges them using Swing layouts.

The available courses, groups, exercises, and files are stored in arrays.

### Example Data

```java
String[] courses = {"OOP"};
String[] groups = {"Group1", "Group2"};
String[] exercises = {"Exercise01", "Exercise02"};

String[][] files = {
    {"exercise01.txt", "data.txt"},
    {"exercise02.txt", "data.txt"}
};
```

The file list is associated with each exercise. When the user selects an exercise, the corresponding files are displayed.

---

## Exercise and File Selection

The application uses an action listener on the exercise combo box.

When the user selects a different exercise:

1. The selected exercise index is retrieved.
2. The existing files are removed from the file combo box.
3. The files associated with the selected exercise are added.
4. The user can then select one of the available files.

This allows the available files to change automatically depending on the selected exercise.

---

## Sending a Request

When the user clicks the **Send URL** button, the application retrieves the selected course, group, exercise, and file.

These values are used to construct the server URL.

For example:

```java
String urlString =
    "http://localhost:8000/host/" +
    course + "/" +
    group + "/" +
    exercise + "/" +
    file;
```

The resulting URL follows this structure:

```text
http://localhost:8000/host/{course}/{group}/{exercise}/{file}
```

For example:

```text
http://localhost:8000/host/OOP/Group1/Exercise01/exercise01.txt
```

---

## HTTP Communication

The application uses `HttpURLConnection` to communicate with the file server.

The request uses the **GET** method.

The application:

1. Creates the URL.
2. Opens an HTTP connection.
3. Sets the request method to `GET`.
4. Sends the request to the server.
5. Retrieves the HTTP response code.
6. Reads the server response.
7. Displays the response in the text area.
8. Closes the connection.

---

## Server Response

After receiving the response from the server, the application displays:

- The HTTP response code.
- The content returned by the server.

For example:

```text
Response code: 200
[Server response]
```

---

## Error Handling

The application handles common errors during the request process.

### No File Selected

If no file is selected, the application displays:

```text
Error: No file selected.
```

### Connection Error

If an error occurs while communicating with the server, the application displays the corresponding error message.

---

## Application Flow

1. Start the Test Client Application.
2. Select a **Course**.
3. Select a **Group**.
4. Select an **Exercise**.
5. Select a **File**.
6. Click **Send URL**.
7. The application constructs the server URL.
8. An HTTP GET request is sent to the server.
9. The server processes the request.
10. The response is displayed in the application.

---

## Server URL Structure

The client communicates with the server using the following URL structure:

```text
http://localhost:8000/host/{course}/{group}/{exercise}/{file}
```

| Parameter | Description |
|---|---|
| `course` | The selected course |
| `group` | The selected group |
| `exercise` | The selected exercise |
| `file` | The selected file |

---

## Requirements

- **Java Development Kit (JDK) 8 or higher**
- A running instance of the file server application
- Network access to the server

---

## Running the Application

### 1. Start the Server

Make sure the file server application is running and available at:

```text
http://localhost:8000
```

### 2. Start the Test Client

Run the `Frontend` class.

The Swing GUI will open.

### 3. Select the Required Information

Choose:

- Course
- Group
- Exercise
- File

### 4. Send the Request

Click the **Send URL** button.

The application will send the request to the server and display the response.

---

## Future Enhancements

Possible improvements include:

- Add more courses, groups, exercises, and files.
- Load data dynamically from the server or a database.
- Improve error handling.
- Add support for POST, PUT, and DELETE requests.
- Improve the graphical user interface.
- Add request history.
- Allow the server address and port to be configured by the user.

---

## References

- [Java JLabel - Javatpoint](https://www.javatpoint.com/java-jlabel)
- [ChatGPT](https://chat.openai.com)
