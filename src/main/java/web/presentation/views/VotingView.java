package web.presentation.views;

import java.util.List;

import web.presentation.models.Model;

public class VotingView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.print("Temas: [");
        List<String> averages = (List<String>) model.get("votes");
        for (int i = 0; i < averages.size(); i++) {
            System.out.print("ThemeTransfer " + averages.get(i));
        }
        System.out.print(" ] \n");
    }

}
