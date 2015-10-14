package presentation.views;

import presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page");
        System.out.println(model.toString());
    }

}