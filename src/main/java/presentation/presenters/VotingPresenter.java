package presentation.presenters;

import business.controllers.BusinessController;
import business.views.TransferObject1;
import presentation.models.Model;

public class VotingPresenter {
    public String process(Model model){
        model.put("log", "VotingPresenter:process");
        return "VotingView";
    }
    
    public String vote(Model model){
        model.put("log", "VotingPresenter:vote");
        new BusinessController().m1(new TransferObject1());
        return "VotingView";
    }
}
