package web.presentation.views;

import java.util.List;

import web.presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page");
        List<String> themes = (List<String>) model.get("themes");
        System.out.print("Temas: [ ");
        for(int i=0; i<themes.size(); i++){
            System.out.print(themes.get(i)+" ");
        }
        System.out.print("] \n");
    }

}
