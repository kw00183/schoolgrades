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
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

public class MainController implements Initializable {
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
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.buttonRecalculate.setOnAction(e -> this.calculateFinalGrade());

		this.createListQuiz();
		this.createListHomework();
		this.createListExam();

		this.calculateQuiz();
		this.calculateHomework();
		this.calculateExam();
		this.calculateFinalGrade();
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

	private void createListQuiz() {
		this.addDefaultQuizGrades();

		this.listViewQuiz.setItems(this.quizGrades);

		this.listViewQuiz.setCellFactory(
				new Callback<ListView<Grade>, ListCell<Grade>>() {

					@Override
					public ListCell<Grade> call(ListView<Grade> grades) {
						return new GradeCell();
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
		double weightQuiz = 0.2;
		double weightHomework = 0.3;
		double weightExam = 0.5;
		
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		List<Grade> finalGrades = new ArrayList<>();

		Grade decoratedQuiz = new WeightedGrade(this.subtotalQuiz, weightQuiz);
		Grade decoratedHomework = new WeightedGrade(this.subtotalHomework,
				weightHomework);
		Grade decoratedExam = new WeightedGrade(this.subtotalExam, weightExam);
		
		finalGrades.add(decoratedQuiz);
		finalGrades.add(decoratedHomework);
		finalGrades.add(decoratedExam);

		this.subtotalFinalGrade = new SimpleGrade(strategy.calculate(finalGrades));
		
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