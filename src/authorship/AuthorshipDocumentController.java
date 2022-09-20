package authorship;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.util.ArrayList;

public class AuthorshipDocumentController {

    @FXML
    private ResourceBundle resources;

    private Book yoBook;
    private Book mysBook;
    private Book loadBook;
    private int part = 0;
    private double averageWordLength = 0.0;

    Author Austen = new Author();
    Author Dickens = new Author();
    Author Grisham = new Author();
    Author King = new Author();
    Author Melville = new Author();
    Author Shakespeare = new Author();
    Author Tolstoy = new Author();
    Author Twain = new Author();

    ArrayList<Double> austenSignature = new ArrayList<>();
    ArrayList<Double> dickensSignature = new ArrayList<>();
    ArrayList<Double> grishamSignature = new ArrayList<>();
    ArrayList<Double> kingSignature = new ArrayList<>();
    ArrayList<Double> melvilleSignature = new ArrayList<>();
    ArrayList<Double> shakespeareSignature = new ArrayList<>();
    ArrayList<Double> tolstoySignature = new ArrayList<>();
    ArrayList<Double> twainSignature = new ArrayList<>();

    @FXML
    private URL location;

    @FXML
    private Button daBook;

    @FXML
    private TextArea words;

    @FXML
    private TextField authorText;

    //@FXML
    //private Button authorButton;
    @FXML
    private TextArea authorLibrary;

    @FXML
    private TextArea bookLibrary;

    @FXML
    private TextArea mysteryBookText;

    @FXML
    private TextField mysteryAuthorText;

    @FXML
    private Button mysteryAuthorButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;

    @FXML
    void saveSig(ActionEvent event) throws FileNotFoundException {

        try (PrintWriter save = new PrintWriter("Signatures_" + part + ".txt")) {
            save.println(bookLibrary.getText());
        }
        part++;
    }

    @FXML
    void loadSig(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("View Files");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Text Files",
                        "*.txt"),
                new FileChooser.ExtensionFilter(
                        "All Files",
                        "*.*"));
        fc.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File selectedFile = fc.showOpenDialog(null);
        String alllines = "";
        Path path = Paths.get(selectedFile.getAbsolutePath());
        try {
            alllines = new String(Files.readAllBytes(path));
        } catch (IOException e) {

        }
        //System.out.println(alllines);
        bookLibrary.setText(alllines);
        loadBook.setAllWords(alllines);

    }

    @FXML
    void readAuthor(ActionEvent event) {

    }

    @FXML
    void readMystery(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("View Files");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Text Files",
                        "*.txt"),
                new FileChooser.ExtensionFilter(
                        "All Files",
                        "*.*"));
        fc.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File selectedFile = fc.showOpenDialog(null);
        String alllines = "";
        Path path = Paths.get(selectedFile.getAbsolutePath());
        try {
            alllines = new String(Files.readAllBytes(path));
        } catch (IOException e) {

        }
        //System.out.println(alllines);
        mysteryBookText.setText(alllines);
        mysBook.setAllWords(alllines);

    }

    @FXML
    void readBook(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("View Files");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Text Files",
                        "*.txt"),
                new FileChooser.ExtensionFilter(
                        "All Files",
                        "*.*"));
        fc.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File selectedFile = fc.showOpenDialog(null);
        String alllines = "";
        Path path = Paths.get(selectedFile.getAbsolutePath());
        try {
            alllines = new String(Files.readAllBytes(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Book b = new Book("test", alllines);
        averageWordLength = b.getAverageWordLength();
        //System.out.println(b.getAverageWordLength());
        //System.out.println(alllines);
        //System.out.format("getFileName: %s%n", path.getFileName());
        String titleText = path.getFileName().toString();
        //bookLibrary.appendText(titleText + "\n");
        words.setText(alllines);
        yoBook.setAllWords(alllines);

        String authorInfo = authorText.getText();

        authorLibrary.appendText(titleText + " by " + authorInfo + " \n");
        String typedAuthor = authorText.getText();
        if ("Austen".equals(typedAuthor)) {
            double totalBook = Austen.getTitle().size() + 1;
            //System.out.println(totalBook);
            Austen.setTitle(titleText);
            Austen.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            austenSignature.clear();
            austenSignature.add(totalBook);
            austenSignature.add(averageWordLength);
            //austenSignature.add(typeToken);
            //austenSignature.add(hapax);
            //austenSignature.add(avgWordPerSentence);
            //austenSignature.add(complex);

        }
        if ("Dickens".equals(typedAuthor)) {
            double totalBook = Dickens.getTitle().size() + 1;
            //System.out.println(totalBook);
            Dickens.setTitle(titleText);
            Dickens.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            dickensSignature.clear();
            dickensSignature.add(totalBook);
            dickensSignature.add(averageWordLength);
            //dickensSignature.add(typeToken);
            //dickensSignature.add(hapax);
            //dickensSignature.add(avgWordPerSentence);
            //dickensSignature.add(complex);
            
        }
        if ("Grisham".equals(typedAuthor)) {
            double totalBook = Grisham.getTitle().size() + 1;
            //System.out.println(totalBook);
            Grisham.setTitle(titleText);
            Grisham.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            grishamSignature.clear();
            grishamSignature.add(totalBook);
            grishamSignature.add(averageWordLength);
            //grishamSignature.add(typeToken);
            //grishamSignature.add(hapax);
            //grishamSignature.add(avgWordPerSentence);
            //grishamSignature.add(complex);
            
        }
        if ("King".equals(typedAuthor)) {
            double totalBook = King.getTitle().size() + 1;
            //System.out.println(totalBook);
            King.setTitle(titleText);
            King.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            kingSignature.clear();
            kingSignature.add(totalBook);
            kingSignature.add(averageWordLength);
            //kingSignature.add(typeToken);
            //kingSignature.add(hapax);
            //kingSignature.add(avgWordPerSentence);
            //kingSignature.add(complex);
            
        }
        if ("Melville".equals(typedAuthor)) {
            double totalBook = Melville.getTitle().size() + 1;
            //System.out.println(totalBook);
            Melville.setTitle(titleText);
            Melville.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            melvilleSignature.clear();
            melvilleSignature.add(totalBook);
            melvilleSignature.add(averageWordLength);
            //melvilleSignature.add(typeToken);
            //melvilleSignature.add(hapax);
            //melvilleSignature.add(avgWordPerSentence);
            //melvilleSignature.add(complex);
            
        }
        if ("Shakespeare".equals(typedAuthor)) {
            double totalBook = Shakespeare.getTitle().size() + 1;
            //System.out.println(totalBook);
            Shakespeare.setTitle(titleText);
            Shakespeare.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            shakespeareSignature.clear();
            shakespeareSignature.add(totalBook);
            shakespeareSignature.add(averageWordLength);
            //shakespeareSignature.add(typeToken);
            //shakespeareSignature.add(hapax);
            //shakespeareSignature.add(avgWordPerSentence);
            //shakespeareSignature.add(complex);
            
        }
        if ("Tolstoy".equals(typedAuthor)) {
            double totalBook = Tolstoy.getTitle().size() + 1;
            //System.out.println(totalBook);
            Tolstoy.setTitle(titleText);
            Tolstoy.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            tolstoySignature.clear();
            tolstoySignature.add(totalBook);
            tolstoySignature.add(averageWordLength);
            //tolstoySignature.add(typeToken);
            //tolstoySignature.add(hapax);
            //tolstoySignature.add(avgWordPerSentence);
            //tolstoySignature.add(complex);
            
        }
        if ("Twain".equals(typedAuthor)) {
            double totalBook = Twain.getTitle().size() + 1;
            //System.out.println(totalBook);
            Twain.setTitle(titleText);
            Twain.getTitle();
            averageWordLength = b.getAvg(averageWordLength, totalBook);

            twainSignature.clear();
            twainSignature.add(totalBook);
            twainSignature.add(averageWordLength);
            //twainSignature.add(typeToken);
            //twainSignature.add(hapax);
            //twainSignature.add(avgWordPerSentence);
            //twainSignature.add(complex);
            
        }

        bookLibrary.setText("");
        bookLibrary.appendText("Austen: " + austenSignature + "\n");
        bookLibrary.appendText("Dickens: " + dickensSignature + "\n");
        bookLibrary.appendText("Grisham: " + grishamSignature + "\n");
        bookLibrary.appendText("King: " + kingSignature + "\n");
        bookLibrary.appendText("Melville: " + melvilleSignature + "\n");
        bookLibrary.appendText("Shakespeare: " + shakespeareSignature + "\n");
        bookLibrary.appendText("Tolstoy: " + tolstoySignature + "\n");
        bookLibrary.appendText("Twain: " + twainSignature + "\n");
    }

    @FXML
    void initialize() {
        yoBook = new Book();
        mysBook = new Book();
        loadBook = new Book();

        assert daBook != null : "fx:id=\"daBook\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert words != null : "fx:id=\"words\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert authorText != null : "fx:id=\"authorText\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert authorLibrary != null : "fx:id=\"authorLibrary\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert bookLibrary != null : "fx:id=\"bookLibrary\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert mysteryBookText != null : "fx:id=\"mysteryBookText\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert mysteryAuthorText != null : "fx:id=\"mysteryAuthorText\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert mysteryAuthorButton != null : "fx:id=\"mysteryAuthorButton\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'AuthorshipDocument.fxml'.";

    }
}
