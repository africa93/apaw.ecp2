package presentation.views;

import presentation.models.Model;

public class VotingView implements View{
    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.println(model.toString());
    }

}
