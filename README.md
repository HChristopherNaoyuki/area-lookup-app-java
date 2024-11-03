# Area Lookup Application

A Java-based application that allows users to look up phone and postal codes based on selected countries and towns. Built using Swing, this application features a modern graphical user interface (GUI) for an intuitive user experience.

## Features

- **Country Selection**: Choose from a list of countries to view available towns.
- **Town Selection**: Dynamically updates towns based on the selected country.
- **Code Retrieval**: Retrieve either the phone code or postal code for the selected town.
- **User-Friendly Interface**: Modern design with rounded buttons and clear layout.

## Technologies Used

- **Java**: Core programming language.
- **Swing**: For building the GUI.
- **JUnit**: For potential unit testing (if applicable).

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your machine.
- An IDE (such as IntelliJ IDEA or Eclipse) or a text editor to run the Java application.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/area-lookup-app-java.git
   ```

2. Navigate to the project directory:
   ```bash
   cd area-lookup-app
   ```

3. Compile the Java files:
   ```bash
   javac src/Solution/*.java
   ```

4. Run the application:
   ```bash
   java -cp src Solution.AreaLookupApp
   ```

## Usage

1. Launch the application.
2. Select a country from the dropdown list.
3. Choose a town from the updated list.
4. Select either "Phone Code" or "Postal Code" using the radio buttons.
5. Click "Submit" to display the corresponding code.
