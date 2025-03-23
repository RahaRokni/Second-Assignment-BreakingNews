# Project Title: News API Integration

**Simple overview of use/purpose:** 
This project integrates the News API to fetch and display the latest news articles related to Tesla. It provides a command-line interface for users to browse and read news articles.

## Description

This project is a Java-based application that connects to the News API to retrieve news articles about Tesla. The application fetches the latest articles from the past day, parses the JSON response, and displays the articles in a user-friendly format. Users can select an article to view its details, including the title, author, description, source, URL, and publication date. The project demonstrates how to work with APIs, handle JSON data, and create a simple command-line interface in Java.

## Getting Started

### Dependencies

- **Java Development Kit (JDK):** Version 11 or higher.
- **Operating System:** Compatible with Windows, macOS, and Linux.
- **Libraries:** 
  - `java.net.http` for HTTP requests.
  - No external libraries are required for JSON parsing (manual parsing is implemented).

### Installing

1. **Download the Project:**
   - Clone the repository or download the source code files (`Infrastructure.java`, `Main.java`, and `News.java`).
   ```bash
  git clone https://github.com/RahaRokni/Second-Assignment-BreakingNews.git
  ```
  - **Modify the API Key**:
  Open the Main.java file and replace the APIKEY variable with your News API key.
  ```bash
  String APIKEY = "your_api_key_here";
  ```
  - **Compile the Program**:
  Navigate to the project directory and compile the Java files.
  ```bash
  javac AP/*.java
  ```

### Executing program

- **Run the Program**:
Execute the Main class to start the application.
    ```bash
  java AP.Main
 ```
- **Run the Program**:

* The program will display a list of news articles.

* Enter the number corresponding to the article you want to read.

*Enter 0 to exit the program.

## Help

If you encounter issues while running the program:

    * Ensure that your API key is valid and has access to the News API.

    * Check your internet connection, as the program requires an active connection to fetch data.

    * If the program crashes or behaves unexpectedly, verify that the JSON response from the API is in the expected format.

    * For additional help, you can run the program with debug information:
    ```bash
  java AP.Main --debug
 ```

## Authors

Contact: rharokni@gmail.com

GitHub: @RahaRokni

## Version History

* 0.2
    * Bug Fixes: Resolved issues with JSON parsing and improved error handling.

    * Enhanced User Interface: Added more detailed article display and better menu navigation.
* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)
