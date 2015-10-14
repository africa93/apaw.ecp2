package presentation.presenters;

import business.controllers.BusinessController;
import business.views.TransferObject2;
import presentation.models.Model;

public class ThemeManagerPresenter {
    public String process(Model model){
        model.put("log", "ThemeManagerPresenter:process");
        return "ThemeManagerView";
    }
    
    public String createTheme(Model model, String name){
        model.put(name, Double.NaN);
        //Mostrar lo que tiene el modelo?
        new BusinessController().createTheme(new TransferObject2());
        return "ThemeManagerView";
    }
}
