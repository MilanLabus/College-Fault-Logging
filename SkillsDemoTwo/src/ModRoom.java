import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModRoom {

	public static void dispay() {
		// Main Scene
		BorderPane borderpane = new BorderPane();
		VBox v = new VBox();
		HBox bottom = new HBox();
		Insets insets = new Insets(10);

		// remove a room Scene
		BorderPane borderpane2 = new BorderPane();
		VBox remove = new VBox();
		HBox bottomre = new HBox();

		// Add a room Scene
		BorderPane borderpane3 = new BorderPane();
		VBox addvbox = new VBox();
		HBox addbottom = new HBox();

		Stage window5 = new Stage();
		window5.setTitle("Mod Room Menu");
		window5.initModality(Modality.APPLICATION_MODAL);

		// main modRoom scene
		Button close = new Button("Close");
		close.setMaxWidth(150);
		close.setOnAction(e -> {
			window5.close();
		});

		Button help = new Button("Help");
		help.setMaxWidth(150);
		help.setOnAction(e -> {
			getHelp();
		});

		// Remove a room Scene
		Label remRoom = new Label();
		remRoom.setText("Enter a Room");
		remRoom.setFont(new Font("Arial", 20));
		remRoom.setPadding(new Insets(50, 10, 10, 10));

		TextField EnterRoom = new TextField();
		EnterRoom.setMaxWidth(250);

		Button rmv = new Button("Remove");
		rmv.setMaxWidth(150);
		rmv.setOnAction(e -> {
			if (Technicians.isInt(EnterRoom)) {
				int RmNumber = Integer.parseInt(EnterRoom.getText());
				ConnectionClass.RemoveARoom(RmNumber);
			} else {
				Technicians.inputError();
			}
		});

		Label ModRoomMenu = new Label();
		ModRoomMenu.setText("Modify room menu");
		ModRoomMenu.setFont(new Font("Arial", 20));
		ModRoomMenu.setPadding(new Insets(50, 10, 10, 10));

		borderpane.setTop(ModRoomMenu);
		BorderPane.setAlignment(ModRoomMenu, Pos.CENTER);
		borderpane.setPadding(new Insets(6));
		borderpane.setCenter(v);
		BorderPane.setMargin(v, insets);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));

		Scene ModRoom = new Scene(borderpane, 400, 400);
		ModRoom.getStylesheets().add("style.css");

		// Add a room Scene
		Label addroomlbl = new Label();
		addroomlbl.setText("Add a Room");
		addroomlbl.setFont(new Font("Arial", 23));
		addroomlbl.setPadding(new Insets(50, 10, 10, 10));

		Label Enterroomolbl = new Label();
		Enterroomolbl.setText("Enter a Room Number");
		Enterroomolbl.setFont(new Font(14));
		Enterroomolbl.setPadding(new Insets(50, 10, 10, 10));

		TextField roomnotxt = new TextField();
		roomnotxt.setMaxWidth(250);

		Button adroombtn = new Button("Add");
		adroombtn.setMaxWidth(200);
		adroombtn.setOnAction(e -> {
			if (isInt(roomnotxt)) {
				int RoomNumber = Integer.parseInt(roomnotxt.getText());
				ConnectionClass.AddRoom(RoomNumber);
			} else
				Teacher.inputError();
		});

		// remove User Scene
		Button closeadd = new Button("Close");
		closeadd.setMaxWidth(150);
		closeadd.setOnAction(e -> {
			window5.setScene(ModRoom);
		});

		Button helpadd = new Button("Help");
		helpadd.setMaxWidth(150);
		helpadd.setOnAction(e -> {
			getHeladd();
		});

		addvbox.getChildren().addAll(Enterroomolbl, roomnotxt, adroombtn);
		addvbox.setAlignment(Pos.CENTER);
		addvbox.setPadding(new Insets(10, 10, 10, 10));
		addvbox.setSpacing(15);

		addbottom.getChildren().addAll(closeadd, helpadd);
		addbottom.setAlignment(Pos.BOTTOM_LEFT);
		addbottom.setSpacing(6);

		borderpane3.setTop(addroomlbl);
		BorderPane.setAlignment(addroomlbl, Pos.CENTER);
		borderpane3.setPadding(new Insets(6));
		borderpane3.setCenter(addvbox);
		BorderPane.setMargin(addvbox, insets);
		borderpane3.setBottom(addbottom);

		Scene addRoom = new Scene(borderpane3, 400, 400);
		addRoom.getStylesheets().add("style.css");

		// Add Room
		Button AddRoom = new Button("Add Room");
		AddRoom.setMaxWidth(200);
		AddRoom.setOnAction(e -> {
			window5.setScene(addRoom);

		});

		// remove a room
		Button closere = new Button("Close");
		closere.setMaxWidth(150);
		closere.setOnAction(e -> {
			window5.setScene(ModRoom);
			;
		});
		Button helpre = new Button("Help");
		helpre.setMaxWidth(150);
		helpre.setOnAction(e -> {
			getHelprve();
		});

		remove.getChildren().addAll(EnterRoom, rmv);
		remove.setAlignment(Pos.CENTER);
		remove.setPadding(new Insets(10, 10, 10, 10));
		remove.setSpacing(15);

		bottomre.getChildren().addAll(closere, helpre);
		bottomre.setAlignment(Pos.BOTTOM_LEFT);
		bottomre.setSpacing(6);

		borderpane2.setTop(remRoom);
		BorderPane.setAlignment(remRoom, Pos.CENTER);
		borderpane2.setCenter(remove);
		BorderPane.setMargin(remove, insets);
		borderpane2.setBottom(bottomre);
		borderpane2.setPadding(new Insets(6));

		Scene removeScene = new Scene(borderpane2, 400, 400);
		removeScene.getStylesheets().add("style.css");

		Button RmvRoom = new Button("Remove Room");
		RmvRoom.setMaxWidth(200);
		RmvRoom.setOnAction(e -> {
			window5.setScene(removeScene);
		});

		// Main Scene
		v.getChildren().addAll(RmvRoom, AddRoom);
		v.setAlignment(Pos.CENTER);
		v.setPadding(new Insets(10, 10, 10, 10));
		v.setSpacing(15);

		bottom.getChildren().addAll(close, help);
		bottom.setAlignment(Pos.BOTTOM_LEFT);
		bottom.setSpacing(6);

		window5.setTitle("Modify Room Menu");
		window5.setScene(ModRoom);
		window5.show();

	}

	public static Alert getHelp() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Press one the buttons Available add\n"
				+ "1. To remove a room press the first button\n" + "2. To add a room press the second button\n"
				+ "3. To modify a room press the third button\n" + "4. Press exit press the close button\n");
		alert.showAndWait();

		return alert;
	}

	public static Alert getHelprve() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Enter the room you wish to remove\n" + "1. Then press the remove button\n"
				+ "2. To go back press close\n"

		);
		alert.showAndWait();

		return alert;
	}

	public static Alert getHeladd() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Enter the room you wish to add\n" + "1. Then press the add button to add it\n"
				+ "2. To go back press close\n"

		);
		alert.showAndWait();

		return alert;
	}

	public static boolean isInt(TextField textone) {
		try {
			int Room = Integer.parseInt(textone.getText());
			return true;
		} catch (NumberFormatException e) {

		}
		return false;

	}

}
