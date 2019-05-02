import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoverViewerController {

    @FXML private ListView<Book> booksListView;
    @FXML private ImageView coverImageView1;
    @FXML private ImageView coverImageView2;
    @FXML private ImageView coverImageView3;
    @FXML private ImageView coverImageView4;
    @FXML private ImageView coverImageView5;
    @FXML private ImageView coverImageView6;
    @FXML private ImageView coverImageView7;
    @FXML private ImageView coverImageView8;
    @FXML private ImageView coverImageView9;

    private final ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize() {
        books.add(new Book("Android How to Program",
            "/images/small/androidhtp.jpg", "/images/large/androidhtp.jpg"));
        books.add(new Book("C How to Program",
            "/images/small/chtp.jpg", "/images/large/chtp.jpg"));
        books.add(new Book("C++ How to Program",
            "/images/small/cpphtp.jpg", "/images/large/cpphtp.jpg"));
        books.add(new Book("Internet and World Wide Web How to Program",
           "/images/small/iw3htp.jpg", "/images/large/iw3htp.jpg"));
        books.add(new Book("Java How to Program",
           "/images/small/jhtp.jpg", "/images/large/jhtp.jpg"));
        books.add(new Book("Visual Basic How to Program",
            "/images/small/vbhtp.jpg", "/images/large/vbhtp.jpg"));
        books.add(new Book("Visual C# How to Program",
            "/images/small/vcshtp.jpg", "/images/large/vcshtp.jpg"));
        booksListView.setItems(books);

        booksListView.getSelectionModel().selectedItemProperty().
            addListener(
                new ChangeListener<Book>() {
                    @Override
                    public void changed(ObservableValue<? extends Book> ov, Book oldValue, Book newValue) {
                        coverImageView9.setImage(coverImageView8.getImage());
                        coverImageView8.setImage(coverImageView7.getImage());
                        coverImageView7.setImage(coverImageView6.getImage());
                        coverImageView6.setImage(coverImageView5.getImage());
                        coverImageView5.setImage(coverImageView4.getImage());
                        coverImageView4.setImage(coverImageView3.getImage());
                        coverImageView3.setImage(coverImageView2.getImage());
                        coverImageView2.setImage(coverImageView1.getImage());
                        coverImageView1.setImage(new Image(newValue.getLargeImage()));
                    }
                }
            );
    }
}
