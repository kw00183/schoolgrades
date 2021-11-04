package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
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
 * Cotroller class for the SchoolGrades project
 * 
 * @author Kim Weible
 * @version cs6241
 */
public class MainController implements Initializable {
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
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.buttonRecalculate.setOnAction(e -> this.clickRecalculate());

		this.menuOptions();

		this.createListQuiz();
		this.createListHomework();
		this.createListExam();

		this.calculateQuiz();
		this.calculateHomework();
		this.calculateExam();
		this.calculateFinalGrade();
	}

	private void menuOptions() {
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

	private void addDefaultQuizGrades() {
		this.quizGrades.add(new SimpleGrade(0));
		this.quizGrades.add(new SimpleGrade(10));
	}

	private void addDefaultHomeworkGrades() {
		this.homeworkGrades.add(new SimpleGrade(100));
		this.homeworkGrades.add(new SimpleGrade(80));
		this.homeworkGrades.add(new SimpleGrade(60));
		this.homeworkGrades.add(new SimpleGrade(40));
		this.homeworkGrades.add(new SimpleGrade(20));
	}

	private void addDefaultExamGrades() {
		this.examGrades.add(new SimpleGrade(99));
		this.examGrades.add(new SimpleGrade(67));
		this.examGrades.add(new SimpleGrade(73));
		this.examGrades.add(new SimpleGrade(88));
	}

	private void addNewQuizGrade() {
		this.quizGrades.add(new SimpleGrade(0));
	}

	private void addNewHomeworkGrade() {
		this.homeworkGrades.add(new SimpleGrade(0));
	}

	private void addNewExamGrade() {
		this.examGrades.add(new SimpleGrade(0));
	}

	private void clearGrades() {
		this.quizGrades.clear();
		this.homeworkGrades.clear();
		this.examGrades.clear();

		this.calculateFinalGrade();
	}

	private void clickRecalculate() {
		this.buttonRecalculate
				.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent arg0) {
						MainController.this.calculateFinalGrade();
					}
				});
	}

	private void createListQuiz() {
		this.addDefaultQuizGrades();

		this.listViewQuiz.setItems(this.quizGrades);

		this.listViewQuiz.setEditable(true);

		this.listViewQuiz.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> grades) {
						TextFieldListCell<Grade> textCell = new TextFieldListCell<Grade>() {
							
							@Override
							public void updateItem(Grade item, boolean empty) {
								super.updateItem(item, empty);
								if (item != null) {
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
				                newGrade.setValue(Double.parseDouble(string));
				                return newGrade;
				            }
				        });
				        return textCell;
					}
				});
	}

	private void createListHomework() {
		this.addDefaultHomeworkGrades();

		this.listViewHomework.setItems(this.homeworkGrades);

		this.listViewHomework.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> grades) {
						return new GradeCell();
					}
				});
	}

	private void createListExam() {
		this.addDefaultExamGrades();

		this.listViewExam.setItems(this.examGrades);

		this.listViewExam.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> quizzes) {
						return new GradeCell();
					}
				});
	}

	private void calculateQuiz() {
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		this.subtotalQuiz = new SimpleGrade(
				strategy.calculate(this.quizGrades));

		this.textFieldQuiz.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalQuiz.getValue()),
				new NumberStringConverter());
	}

	private void calculateHomework() {
		GradeCalculationStrategy strategy = new DropLowestStrategy(
				new AverageOfGradesStrategy());
		this.subtotalHomework = new SimpleGrade(
				strategy.calculate(this.homeworkGrades));

		this.textFieldHomework.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalHomework.getValue()),
				new NumberStringConverter());
	}

	private void calculateExam() {
		GradeCalculationStrategy strategy = new AverageOfGradesStrategy();
		this.subtotalExam = new SimpleGrade(
				strategy.calculate(this.examGrades));

		this.textFieldExam.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalExam.getValue()),
				new NumberStringConverter());
	}

	private void calculateFinalGrade() {
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		List<Grade> finalGrades = new ArrayList<>();

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

		this.subtotalFinalGrade = new SimpleGrade(
				strategy.calculate(finalGrades));

		this.textFieldFinalGrade.textProperty().bindBidirectional(
				new SimpleDoubleProperty(this.subtotalFinalGrade.getValue()),
				new NumberStringConverter());
	}

	static class GradeCell extends ListCell<Grade> {
		public void updateItem(Grade item, boolean empty) {
			super.updateItem(item, empty);
			if (item != null) {
				setText(String.format("%.2f", item.getValue()));
				setAccessibleText(String.format("%.2f", item.getValue()));
			} else {
				setText("");
			}
		}
	}
}