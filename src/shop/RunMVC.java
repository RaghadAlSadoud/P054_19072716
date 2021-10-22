package shop;

public class RunMVC {


    public static void main(String[] args) {
        RunMVC mainRunMVC = new RunMVC();
    }

    public RunMVC() {
        Model myModel = new Model();
        View myView = new View();
        myModel.addObserver(myView);
        
        Controller myController = new Controller();
        myController.addModel(myModel);
        myController.addView(myView);
        myController.initModel();
        myView.addController(myController);
    }
}
