package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

/**
 * Controller class for the SchoolGrades project
 * 
 * @author Kim Weible
 * @version cs6241
 */
public class MainController implements Initializable {
	@FXML
	private Label labelQuizzes;
	@FXML
	private Label labelHomeworks;
	@FXML
	private Label labelExams;
	@FXML
	private Label labelFinalGrade;
	@FXML
	private Label labelSubtotalQuiz;
	@FXML
	private Label labelSubtotalHomework;
	@FXML
	private Label labelSubtotalExam;
	@FXML
	private Label labelSubtotalFinalGrade;

	@FXML
	private MenuItem menuAddQuiz;
	@FXML
	private MenuItem menuAddHomework;
	@FXML
	private MenuItem menuAddExam;
	@FXML
	private MenuItem menuClearGrades;

	@FXML
	private ListView<Grade> listViewQuiz;
	@FXML
	private ListView<Grade> listViewHomework;
	@FXML
	private ListView<Grade> listViewExam;

	@FXML
	private TextField textFieldQuiz;
	@FXML
	private TextField textFieldHomework;
	@FXML
	private TextField textFieldExam;
	@FXML
	private TextField textFieldFinalGrade;

	@FXML
	private Button buttonRecalculate;

	private Grade subtotalQuiz;
	private Grade subtotalHomework;
	private Grade subtotalExam;
	private Grade subtotalFinalGrade;

	private ObservableList<Grade> quizGrades;
	private ObservableList<Grade> homeworkGrades;
	private ObservableList<Grade> examGrades;

	private double weightQuiz;
	private double weightHomework;
	private double weightExam;

	/**
	 * Constructor used to initialize list view and class objects for GUI
	 */
	public MainController() {
		this.quizGrades = FXCollections.observableArrayList();
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();

		this.listViewQuiz = new ListView<Grade>(this.quizGrades);
		this.listViewHomework = new ListView<Grade>(this.homeworkGrades);
		this.listViewExam = new ListView<Grade>(this.examGrades);

		this.weightQuiz = 0.2;
		this.weightHomework = 0.3;
		this.weightExam = 0.5;

		this.subtotalQuiz = new SimpleGrade(88.5);
		this.subtotalHomework = new SimpleGrade(9.85);
		this.subtotalExam = new SimpleGrade(42.64);
		this.subtotalFinalGrade = new SimpleGrade(75.03);
	}

	/**
	 * Initialize the application
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.buttonRecalculate.setOnAction(e -> this.clickButtonRecalculate());

		this.buildMainMenuOptions();
		this.buildContextMenuOptions();

		this.createListViewQuiz();
		this.createListViewHomework();
		this.createListViewExam();

		this.buildTextFields();
	}

	/**
	 * Method used to build the menu options
	 */
	private void buildMainMenuOptions() {
		this.menuAddQuiz.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainController.this.addNewQuizGrade();
			}
		});

		this.menuAddHomework.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainController.this.addNewHomeworkGrade();
			}
		});

		this.menuAddExam.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainController.this.addNewExamGrade();
			}
		});

		this.menuClearGrades.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainController.this.clearGrades();
			}
		});
	}

	/**
	 * Method used to build the context menu options of the list views
	 */
	private void buildContextMenuOptions() {
		this.listViewQuiz.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.SECONDARY) {
				ContextMenu quizContextMenu = new ContextMenu();
				MenuItem addQuizMenuItem = new MenuItem("add quiz");

				addQuizMenuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MainController.this.addNewQuizGrade();
					}
				});
				quizContextMenu.getItems().add(addQuizMenuItem);
				this.listViewQuiz.setContextMenu(quizContextMenu);
			}
		});

		this.listViewHomework.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.SECONDARY) {
				ContextMenu homeworkContextMenu = new ContextMenu();
				MenuItem addHomeworkMenuItem = new MenuItem("add homework");

				addHomeworkMenuItem
						.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								MainController.this.addNewHomeworkGrade();
							}
						});
				homeworkContextMenu.getItems().add(addHomeworkMenuItem);
				this.listViewHomework.setContextMenu(homeworkContextMenu);
			}
		});

		this.listViewExam.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.SECONDARY) {
				ContextMenu examContextMenu = new ContextMenu();
				MenuItem addExamMenuItem = new MenuItem("add exam");

				addExamMenuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MainController.this.addNewExamGrade();
					}
				});
				examContextMenu.getItems().add(addExamMenuItem);
				this.listViewExam.setContextMenu(examContextMenu);
			}
		});
	}

	/**
	 * Method used to add the default quiz grades
	 */
	private void addDefaultQuizGrades() {
		this.quizGrades.add(new SimpleGrade(0));
		this.quizGrades.add(new SimpleGrade(10));
	}

	/**
	 * Method used to add the default homework grades
	 */
	private void addDefaultHomeworkGrades() {
		this.homeworkGrades.add(new SimpleGrade(100));
		this.homeworkGrades.add(new SimpleGrade(80));
		this.homeworkGrades.add(new SimpleGrade(60));
		this.homeworkGrades.add(new SimpleGrade(40));
		this.homeworkGrades.add(new SimpleGrade(20));
	}

	/**
	 * Method used to add the default exam grades
	 */
	private void addDefaultExamGrades() {
		this.examGrades.add(new SimpleGrade(99));
		this.examGrades.add(new SimpleGrade(67));
		this.examGrades.add(new SimpleGrade(73));
		this.examGrades.add(new SimpleGrade(88));
	}

	/**
	 * Method used to add a new quiz grade
	 */
	private void addNewQuizGrade() {
		this.quizGrades.add(new SimpleGrade(0));
	}

	/**
	 * Method used to add a new homework grade
	 */
	private void addNewHomeworkGrade() {
		this.homeworkGrades.add(new SimpleGrade(0));
	}

	/**
	 * Method used to add a new exam grade
	 */
	private void addNewExamGrade() {
		this.examGrades.add(new SimpleGrade(0));
	}

	/**
	 * Method used to clear all grades
	 */
	private void clearGrades() {
		this.quizGrades.clear();
		this.homeworkGrades.clear();
		this.examGrades.clear();

		this.calculateFinalGrade();
	}

	/**
	 * Method used to calculate all subtotals when button Recalculate is clicked
	 */
	private void clickButtonRecalculate() {
		this.buttonRecalculate
				.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent arg0) {
						MainController.this.calculateFinalGrade();
					}
				});
	}

	/**
	 * Method used to create list view of quizzes
	 */
	private void createListViewQuiz() {
		this.addDefaultQuizGrades();

		this.listViewQuiz.setItems(this.quizGrades);

		this.listViewQuiz.setEditable(true);

		this.listViewQuiz.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> grades) {
						return MainController.this.buildListView();
					}
				});
	}

	/**
	 * Method used to create list view of Homeworks
	 */
	private void createListViewHomework() {
		this.addDefaultHomeworkGrades();

		this.listViewHomework.setItems(this.homeworkGrades);

		this.listViewHomework.setEditable(true);

		this.listViewHomework.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> homeworks) {
						return MainController.this.buildListView();
					}
				});
	}

	/**
	 * Method used to create list view of exams
	 */
	private void createListViewExam() {
		this.addDefaultExamGrades();

		this.listViewExam.setItems(this.examGrades);

		this.listViewExam.setEditable(true);

		this.listViewExam.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> exams) {
						return MainController.this.buildListView();
					}
				});
	}

	/**
	 * Method used to create list views
	 * 
	 * @return ListCell the list cell values for the list view
	 */
	private ListCell<Grade> buildListView() {
		TextFieldListCell<Grade> textCell = new TextFieldListCell<Grade>() {

			@Override
			public void updateItem(Grade item, boolean empty) {
				super.updateItem(item, empty);
				if (item != null && MainController.isNumeric(item)) {
					setText(String.format("%.2f", item.getValue()));
					setAccessibleText(String.format("%.2f", item.getValue()));
				} else {
					setText("");
				}
			}
		};

		textCell.setConverter(new StringConverter<Grade>() {

			@Override
			public String toString(Grade newGrade) {
				return String.valueOf(newGrade.getValue());
			}

			@Override
			public SimpleGrade fromString(String string) {
				SimpleGrade newGrade = (SimpleGrade) textCell.getItem();
				try {
					newGrade.setValue(Double.parseDouble(string));
				} catch (NumberFormatException nfe) {
					System.out.println("value is not a number");
				} catch (IllegalArgumentException iae) {
					System.out.println("value should not be < 0");
				}
				return newGrade;
			}
		});
		return textCell;
	}

	/**
	 * Method used to populate text fields
	 */
	private void buildTextFields() {
		this.textFieldQuiz.setEditable(false);
		this.textFieldHomework.setEditable(false);
		this.textFieldExam.setEditable(false);
		this.textFieldFinalGrade.setEditable(false);
		
		this.textFieldQuiz.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalQuiz.getValue()),
				new NumberStringConverter());
		this.textFieldHomework.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalHomework.getValue()),
				new NumberStringConverter());
		this.textFieldExam.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalExam.getValue()),
				new NumberStringConverter());
		this.textFieldFinalGrade.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalFinalGrade.getValue()),
				new NumberStringConverter());
	}

	/**
	 * Method used to check if grade is a numeric value
	 * 
	 * @param stringNumber
	 *            the string to check if it is a numeric value
	 * @return boolean is string numeric or not
	 */
	private static boolean isNumeric(Grade stringNumber) {
		if (stringNumber == null) {
			return false;
		}
		try {
			String.format("%.2f", stringNumber.getValue());
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Method used to calculate quiz subtotal
	 */
	private void calculateQuiz() {
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		this.subtotalQuiz = this.calculateSubtotal(strategy, this.quizGrades);
	}

	/**
	 * Method used to calculate homework subtotal
	 */
	private void calculateHomework() {
		GradeCalculationStrategy strategy = new DropLowestStrategy(
				new AverageOfGradesStrategy());
		this.subtotalHomework = this.calculateSubtotal(strategy,
				this.homeworkGrades);
	}

	/**
	 * Method used to calculate exam subtotal
	 */
	private void calculateExam() {
		GradeCalculationStrategy strategy = new AverageOfGradesStrategy();
		this.subtotalExam = this.calculateSubtotal(strategy, this.examGrades);
	}

	/**
	 * Method used to calculate subtotal
	 * 
	 * @param strategy
	 *            the strategy used to decorate the grade
	 * @param decorateGrade
	 *            the grade to decorate
	 * @return decorated grade the decorated grade
	 */
	private Grade calculateSubtotal(GradeCalculationStrategy strategy,
			ObservableList<Grade> decorateGrade) {
		return new SimpleGrade(strategy.calculate(decorateGrade));
	}

	/**
	 * Method used to calculate final grade subtotal
	 */
	private void calculateFinalGrade() {
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		ObservableList<Grade> finalGrades = FXCollections.observableArrayList();

		this.calculateQuiz();
		this.calculateHomework();
		this.calculateExam();

		Grade decoratedQuiz = new WeightedGrade(this.subtotalQuiz,
				this.weightQuiz);
		Grade decoratedHomework = new WeightedGrade(this.subtotalHomework,
				this.weightHomework);
		Grade decoratedExam = new WeightedGrade(this.subtotalExam,
				this.weightExam);

		finalGrades.add(decoratedQuiz);
		finalGrades.add(decoratedHomework);
		finalGrades.add(decoratedExam);

		this.subtotalFinalGrade = this.calculateSubtotal(strategy, finalGrades);

		this.buildTextFields();
	}
}