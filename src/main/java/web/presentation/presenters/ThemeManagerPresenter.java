package web.presentation.presenters;

import rest.business.controllers.BusinessController;
import rest.business.views.TransferObject2;
import web.presentation.models.Model;

public class ThemeManagerPresenter {
    public String process(Model model){
        model.put("log", "ThemeManagerPresenter:process");
        return "ThemeManagerView";
    }
    
    public String createTheme(Model model, String name){
        model.put(name, Double.NaN);
        //Método que cree un tema con el nombre que se le pasa
        new BusinessController().createTheme(new TransferObject2());
        return "ThemeManagerView";
    }
}
