package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.BusinessController;
import web.presentation.models.Model;

public class ThemeManagerPresenter {

    public List<String> process() {
        List<String> themes = new BusinessController().getThemes();
        return themes;
    }

    public void createTheme(Model model) {
        // Método que cree un tema con el nombre que se le pasa
        new BusinessController().createTheme((String) model.get("themeName"));
    }
}
