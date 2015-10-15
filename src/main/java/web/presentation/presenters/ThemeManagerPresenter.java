package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.BusinessController;
import web.presentation.models.Model;

public class ThemeManagerPresenter {
    
    private String themeName;
    
    public ThemeManagerPresenter(String name){
        this.themeName = name;
    }
    
    public ThemeManagerPresenter(){
        this.themeName = "";
    }
    
    public String process(Model model){
        List<String> themes = new BusinessController().getThemes();
        model.put("themes", themes);
        return "ThemeManagerView";
    }
    
    public String createTheme(Model model){
        model.put(themeName, Double.NaN);
        //Método que cree un tema con el nombre que se le pasa
        new BusinessController().createTheme(themeName);
        return "ThemeManagerView";
    }
}
